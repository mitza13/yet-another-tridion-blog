using System;
using System.Collections.Generic;
using System.Configuration;
using System.IO;
using System.Reflection;
using System.Xml;
using Tridion.ContentManager;
using Tridion.ContentManager.ContentManagement;
using Tridion.ContentManager.ContentManagement.Fields;

namespace Com.Mitza.YAES {

    /// <summary>
    /// ConfigurationManager stores settings for all events in publications.
    /// </summary>
    public class ConfigurationManager {

        public const string PUBLICATION = "Publication";
        public const string CURRENT = "Current";
        public const string SYSTEM_COMPONENT_LOCATION = "SystemComponentLocation";
        public const string SYSTEM_COMPONENT_FIELD = "SystemComponentField";
        public const string SYSTEM_COMPONENT_RECURSIVE = "SystemComponentRecursive";
        public const string SYSTEM_COMPONENT_OVERRIDE = "SystemComponentOverride";

        private static ConfigurationManager instance;
        private Configuration dllConfiguration;

        internal DateTime LastModifiedCheck { get; set; }

        private Dictionary<string, string> configurations;
        public Dictionary<string, string> Configurations {
            get { return configurations; }
        }

        private int cacheMinutes = 5;
        public int CacheMinutes {
            get {
                return cacheMinutes;
            }
            set {
                cacheMinutes = value;
            }
        }

        /// <summary>
        /// Initiate values, and Load settings xml file.
        /// </summary>
        /// <param name="configFilename">Filepath to the config file of Event System</param>
        private ConfigurationManager() {
            configurations = new Dictionary<string, string>();
            dllConfiguration = GetDllConfiguration();
        }

        public static ConfigurationManager GetInstance(RepositoryLocalObject repositoryLocalObject) {
            if (instance == null) {
                instance = new ConfigurationManager();
            }

            instance.ReloadIfModified(repositoryLocalObject);

            return instance;
        }

        private void ReloadIfModified(RepositoryLocalObject repositoryLocalObject) {
            DateTime dateTimeNow = DateTime.Now;
            DateTime lastModifiedCheck = instance.LastModifiedCheck;
            DateTime expiredDateTime = lastModifiedCheck.AddMinutes(cacheMinutes);

            if (dateTimeNow > expiredDateTime) { // check for modifications
                IEnumerable<Component> configurationComponents = GetConfigurationComponents(repositoryLocalObject); // 'expensive' call

                bool isReload = false;
                foreach (Component configurationComponent in configurationComponents) {
                    if (configurationComponent.RevisionDate > lastModifiedCheck) {
                        isReload = true;
                        break;
                    }
                }

                if (isReload) {
                    configurations.Clear();
                    foreach (Component configurationComponent in configurationComponents) {
                        instance.Load(configurationComponent); // even more 'expensive' call
                    }
                }
                LastModifiedCheck = dateTimeNow;
            }
        }

        private List<Component> GetConfigurationComponents(RepositoryLocalObject repositoryLocalObject) {
            List<Component> results = new List<Component>();
            Component configurationComponent = null;
            string systemComponentLocation = GetAppSetting(SYSTEM_COMPONENT_LOCATION);
            systemComponentLocation = string.IsNullOrEmpty(systemComponentLocation) ? PUBLICATION : systemComponentLocation;
            string systemComponentField = GetAppSetting(SYSTEM_COMPONENT_FIELD);
            systemComponentField = string.IsNullOrEmpty(systemComponentField) ? string.Empty : systemComponentField;

            foreach (string location in systemComponentLocation.Split(',')) {
                try {
                    if (location == PUBLICATION) { // read from Publication metadata
                        Repository publication = repositoryLocalObject.ContextRepository;
                        results.AddRange(GetConfigurationComponents(publication.Metadata, publication.MetadataSchema, systemComponentField));
                    } else if (location == CURRENT) { // read from parent metadata
                        OrganizationalItem organizationalItem = repositoryLocalObject.OrganizationalItem;
                        bool isRecursive = Convert.ToBoolean(GetAppSetting(SYSTEM_COMPONENT_RECURSIVE));
                        results.AddRange(GetConfigurationComponents(organizationalItem, isRecursive));
                    } else if (location.StartsWith("/webdav") || TcmUri.IsValid(location)) {
                        configurationComponent = (Component)repositoryLocalObject.Session.GetObject(location);
                        results.Add(configurationComponent);
                    }
                } catch (Exception ex) {
                    // Log error
                }
            }

            return results;
        }

        private List<Component> GetConfigurationComponents(OrganizationalItem organizationalItem, bool isRecursive) {
            List<Component> results = new List<Component>();

            if (isRecursive && !organizationalItem.IsRootOrganizationalItem) {
                results.AddRange(GetConfigurationComponents(organizationalItem.OrganizationalItem, isRecursive));
            }
            results.AddRange(GetConfigurationComponents(organizationalItem, isRecursive));

            return results;
        }

        private List<Component> GetConfigurationComponents(XmlElement metadataElement, Schema metadataSchema, string fieldNames) {
            List<Component> results = new List<Component>();

            if (metadataElement != null && metadataSchema != null) {
                ItemFields metaFields = new ItemFields(metadataElement, metadataSchema);

                foreach (string fieldName in fieldNames.Split(',')) {
                    if (metaFields.Contains(fieldName)) {
                        ItemField itemField = metaFields[fieldName];
                        if (itemField is ComponentLinkField) {
                            results.Add(((ComponentLinkField)itemField).Value);
                        }
                    }
                }
            }

            return results;
        }

        private Configuration GetDllConfiguration() {
            ExeConfigurationFileMap fileMap = new ExeConfigurationFileMap() {
                ExeConfigFilename = Assembly.GetExecutingAssembly().Location + ".config"
            };

            return System.Configuration.ConfigurationManager.OpenMappedExeConfiguration(fileMap, ConfigurationUserLevel.None);
        }

        private string GetAppSetting(string key) {
            KeyValueConfigurationElement configElement = dllConfiguration.AppSettings.Settings[key];

            if (configElement != null) {
                string value = configElement.Value;
                if (!string.IsNullOrEmpty(value)) {
                    return value;
                }
            }

            return string.Empty;
        }

        private void Load(Component configurationComponent) {
            XmlElement dom = configurationComponent.Content;
            string systemComponentOverride = GetAppSetting(SYSTEM_COMPONENT_OVERRIDE);
            bool isOverride = string.IsNullOrEmpty(systemComponentOverride) ? false : Convert.ToBoolean(systemComponentOverride);

            foreach (XmlNode node in dom.SelectNodes("//*")) {
                string key = node.Name;
                string value = node.InnerText.Trim();
                if (!configurations.ContainsKey(key) || isOverride) {
                    configurations[key] = value;
                }
            }
        }

        /// <summary>
        /// Check if event is enabled.
        /// </summary>
        /// <param name="eventName">Event Name</param>
        /// <returns>true - enabled, false - disabled</returns>
        public bool IsEventEnabled(string eventName) {
            //if (configurations.ContainsKey(eventName) && !configurations[eventName].Enabled) {
            //    return false;
            //}
            return true;
        }

        /// <summary>
        /// Check if Exceptions will be raised in specific Event.
        /// </summary>
        /// <param name="eventName">Event Name</param>
        /// <returns>true - will be raised, false - not</returns>
        public bool IsExceptionsEnabled(string eventName) {
            //if (configurations.ContainsKey(eventName) && !configurations[eventName].ThrowExceptions) {
            //    return false;
            //}
            return true;
        }

        /// <summary>
        /// Check if event is enabled in specific publication.
        /// </summary>
        /// <param name="eventName">Event Name</param>
        /// <param name="publicationId">Publication TcmUri</param>
        /// <returns>true - enabled, false - disabled</returns>
        public bool IsEventEnabled(string eventName, TcmUri publicationId) {
            //if (configurations.ContainsKey(eventName) && configurations[eventName].Publications.ContainsKey(publicationId) && !configurations[eventName].Publications[publicationId]) {
            //    return false;
            //}
            return true;
        }

        /// <summary>
        /// Get all configuration values for Event.
        /// </summary>
        /// <param name="eventName">Event Name</param>
        /// <returns>Collection of key-value pairs with configuration values</returns>
        public Dictionary<string, string> GetConfigValues(string eventName) {
            //if (configurations.ContainsKey(eventName)) {
            //    return configurations[eventName].Configurations;
            //} else {
            return null;
            //}
        }

        /// <summary>
        /// Get specific configuration value for specific event.
        /// </summary>
        /// <param name="eventName">Event Name</param>
        /// <param name="configName">Configuration Name</param>
        /// <returns>The value of configuration setting</returns>
        public string GetConfigValues(string eventName, string configName) {
            //if (configurations.ContainsKey(eventName) && configurations[eventName].Configurations.ContainsKey(configName)) {
            //    return configurations[eventName].Configurations[configName];
            //} else {
            return string.Empty;
            //}
        }
    }
}
