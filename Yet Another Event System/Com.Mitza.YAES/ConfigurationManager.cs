using System;
using System.Collections.Generic;
using System.Configuration;
using System.Reflection;
using System.Xml;
using Tridion.ContentManager;
using Tridion.ContentManager.ContentManagement;
using Tridion.ContentManager.ContentManagement.Fields;

namespace Com.Mitza.YAES
{
    /// <summary>
    /// Handles reading System Configuration Components, loading them as Dictionary and checking for modifications of Configuration Components,
    /// so they get reloaded every few minutes.
    /// Singleton implementaton.
    /// </summary>
    public class ConfigurationManager
    {
        public const string PUBLICATION = "Publication";
        public const string CURRENT = "Current";
        public const string SYSTEM_COMPONENT_LOCATION = "SystemComponentLocation";
        public const string SYSTEM_COMPONENT_FIELD = "SystemComponentField";
        public const string SYSTEM_COMPONENT_RECURSIVE = "SystemComponentRecursive";
        public const string SYSTEM_COMPONENT_OVERRIDE = "SystemComponentOverride";
        public const string SYSTEM_COMPONENT_CACHE_MINUTES = "SystemComponentCacheMinutes";

        private static ConfigurationManager instance;
        DateTime LastModifiedCheck { get; set; }

        private Dictionary<string, string> _configurations;
        /// <summary>
        /// Returns the dictionary containing key, value configuration pairs
        /// </summary>
        public Dictionary<string, string> Configurations
        {
            get { return _configurations; }
        }

        /// <summary>
        /// Indexer accessor. Returns the value from the Configurations dictionary that is associated to the given key.
        /// </summary>
        public string this[string key]
        {
            get
            {
                return _configurations[key];
            }
        }

        private int _systemComponentCacheMinutes = -1;
        /// <summary>
        /// DLL configuration value representing how long should a loaded configuration object be kept in memory cache
        /// </summary>
        private int SystemComponentCacheMinutes
        {
            get
            {
                if (_systemComponentCacheMinutes < 0)
                {
                    string value = GetAppSetting(SYSTEM_COMPONENT_CACHE_MINUTES);
                    if (string.IsNullOrEmpty(value))
                    {
                        _systemComponentCacheMinutes = 0;
                    }
                    else
                    {
                        _systemComponentCacheMinutes = Convert.ToInt32(value);
                    }
                }
                return _systemComponentCacheMinutes;
            }
        }

        private string _systemComponentLocation = null;
        /// <summary>
        /// DLL configuration value indicating the locations (comma-separated) where to read the System Configuration Component from
        /// </summary>
        private string SystemComponentLocation
        {
            get
            {
                if (_systemComponentLocation == null)
                {
                    _systemComponentLocation = GetAppSetting(SYSTEM_COMPONENT_LOCATION);
                    _systemComponentLocation = string.IsNullOrEmpty(_systemComponentLocation) ? PUBLICATION : _systemComponentLocation;
                }
                return _systemComponentLocation;
            }
        }

        private string _systemComponentField = null;
        /// <summary>
        /// DLL configuration value indicating the metadata field names (comma-separated) where to look for Component Links to actual Configuration Components
        /// </summary>
        private string SystemComponentField
        {
            get
            {
                if (_systemComponentField == null)
                {
                    _systemComponentField = GetAppSetting(SYSTEM_COMPONENT_FIELD);
                    _systemComponentField = string.IsNullOrEmpty(_systemComponentField) ? string.Empty : _systemComponentField;
                }
                return _systemComponentField;
            }
        }

        /// <summary>
        /// DLL Configuration value indicating whether existing values in the Configurations dictionary can be overridden by other values (for the same key)
        /// </summary>
        private bool SystemComponentOverride
        {
            get
            {
                string value = GetAppSetting(SYSTEM_COMPONENT_OVERRIDE);
                return string.IsNullOrEmpty(value) ? false : Convert.ToBoolean(value);
            }
        }

        /// <summary>
        /// DLL configuration value indicating whether to attempt searching for Configuration Components in a recursive fashion (to the parent Organizational Item)
        /// </summary>
        private bool SystemComponentRecursive
        {
            get
            {
                string value = GetAppSetting(SYSTEM_COMPONENT_RECURSIVE);
                return string.IsNullOrEmpty(value) ? false : Convert.ToBoolean(value);
            }
        }

        private Configuration _dllConfiguration;
        /// <summary>
        /// Returns the Configuration object next to the current executing DLL
        /// </summary>
        private Configuration DllConfiguration
        {
            get
            {
                if (_dllConfiguration == null)
                {
                    ExeConfigurationFileMap fileMap = new ExeConfigurationFileMap()
                    {
                        ExeConfigFilename = Assembly.GetExecutingAssembly().Location + ".config"
                    };
                    _dllConfiguration = System.Configuration.ConfigurationManager.OpenMappedExeConfiguration(fileMap, ConfigurationUserLevel.None);
                }
                return _dllConfiguration;
            }
        }

        /// <summary>
        /// Private constructor. Singleton implemmentation. Use static method GetInstance(RepositoryLocalObject) instead
        /// </summary>
        private ConfigurationManager()
        {
            _configurations = new Dictionary<string, string>();
        }

        /// <summary>
        /// Returns the ConfigurationManager singleton object. It also checks to reload the Configuration Component vales, if needed.
        /// </summary>
        /// <param name="repositoryLocalObject">the current object to check reloading configuration values for</param>
        /// <returns>the singleton ConfigurationManager object</returns>
        public static ConfigurationManager GetInstance(RepositoryLocalObject repositoryLocalObject)
        {
            if (instance == null)
            {
                instance = new ConfigurationManager();
            }

            instance.ReloadIfModified(repositoryLocalObject);
            return instance;
        }

        /// <summary>
        /// Checks if the current configuration needs to be reloaded. If so, it performs the reloads.
        /// </summary>
        private void ReloadIfModified(RepositoryLocalObject repositoryLocalObject)
        {
            DateTime dateTimeNow = DateTime.Now;
            DateTime lastModifiedCheck = instance.LastModifiedCheck;
            DateTime expiredDateTime = lastModifiedCheck.AddMinutes(SystemComponentCacheMinutes);

            if (dateTimeNow > expiredDateTime) // check for modifications
            {
                IEnumerable<Component> configurationComponents = GetConfigurationComponents(repositoryLocalObject); // 'expensive' call

                bool isReload = false;
                foreach (Component configurationComponent in configurationComponents)
                {
                    if (configurationComponent.RevisionDate > lastModifiedCheck)
                    {
                        isReload = true;
                        break;
                    }
                }

                if (isReload)
                {
                    _configurations.Clear();
                    foreach (Component configurationComponent in configurationComponents)
                    {
                        instance.Load(configurationComponent); // even more 'expensive' call
                    }
                }
                LastModifiedCheck = dateTimeNow;
            }
        }

        /// <summary>
        /// Returns a list of Components representing all encountered configurations that were found according to the locations in the .config file
        /// </summary>
        private List<Component> GetConfigurationComponents(RepositoryLocalObject repositoryLocalObject)
        {
            List<Component> results = new List<Component>();
            Component configurationComponent = null;

            foreach (string location in SystemComponentLocation.Split(','))
            {
                try
                {
                    if (location == PUBLICATION) // read from Publication metadata
                    {
                        Repository publication = repositoryLocalObject.ContextRepository;
                        results.AddRange(GetConfigurationsFromMetadata(publication.Metadata, publication.MetadataSchema));
                    }
                    else if (location == CURRENT) // read from parent metadata
                    {
                        OrganizationalItem organizationalItem = repositoryLocalObject.OrganizationalItem;
                        results.AddRange(GetConfigurationsFromStructureGroup(organizationalItem, SystemComponentRecursive));
                    }
                    else if (location.StartsWith("/webdav") || TcmUri.IsValid(location))
                    {
                        configurationComponent = (Component)repositoryLocalObject.Session.GetObject(location);
                        results.Add(configurationComponent);
                    }
                }
                catch
                {
                    // Log error
                }
            }

            return results;
        }

        /// <summary>
        /// Returns Configuration Components from the OrganizationalItem's metadata, possibly recursive.
        /// </summary>
        private List<Component> GetConfigurationsFromStructureGroup(OrganizationalItem organizationalItem, bool isRecursive)
        {
            List<Component> results = new List<Component>();
            results.AddRange(GetConfigurationsFromMetadata(organizationalItem.Metadata, organizationalItem.MetadataSchema));

            if (isRecursive && !organizationalItem.IsRootOrganizationalItem)
            {
                results.AddRange(GetConfigurationsFromStructureGroup(organizationalItem.OrganizationalItem, isRecursive));
            }

            return results;
        }

        /// <summary>
        /// Returns Configuration Components from the given metadata element and Schema
        /// </summary>
        private List<Component> GetConfigurationsFromMetadata(XmlElement element, Schema schema)
        {
            List<Component> results = new List<Component>();
            if (element != null && schema != null)
            {
                ItemFields metaFields = new ItemFields(element, schema);
                foreach (string fieldName in SystemComponentField.Split(','))
                {
                    if (metaFields.Contains(fieldName))
                    {
                        ItemField itemField = metaFields[fieldName];
                        if (itemField is ComponentLinkField)
                        {
                            results.Add(((ComponentLinkField)itemField).Value);
                        }
                    }
                }
            }

            return results;
        }

        /// <summary>
        /// Returns the configuration value corresponding to the given key from Configuration corresponding to the current executing DLL AppSettings section
        /// </summary>
        private string GetAppSetting(string key)
        {
            KeyValueConfigurationElement configElement = DllConfiguration.AppSettings.Settings[key];

            if (configElement != null)
            {
                string value = configElement.Value;
                if (!string.IsNullOrEmpty(value))
                {
                    return value;
                }
            }

            return string.Empty;
        }

        /// <summary>
        /// Loads all fields from the given configuration Component into the Configurations dictionary. Each key represents an XML field name and its value
        /// represents the field value.
        /// </summary>
        private void Load(Component configurationComponent)
        {
            XmlElement dom = configurationComponent.Content;
            foreach (XmlNode node in dom.SelectNodes("//*"))
            {
                string key = node.Name;
                string value = node.InnerText.Trim();
                if (!_configurations.ContainsKey(key) || SystemComponentOverride)
                {
                    _configurations[key] = value;
                }
            }
        }
    }
}
