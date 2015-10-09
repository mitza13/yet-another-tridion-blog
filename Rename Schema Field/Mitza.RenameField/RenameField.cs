using Mitza.RenameField.Common;
using System;
using System.Configuration;
using System.Web;
using System.Xml;
using Tridion.ContentManager.CoreService.Client;

namespace Mitza.RenameField
{
    public class RenameField
    {
        #region Properties

        string _schemaUri;
        public string SchemaUri
        {
            get
            {
                if (_schemaUri == null)
                {
                    _schemaUri = ConfigurationManager.AppSettings[Constants.SCHEMA_URI];
                }
                return _schemaUri;
            }
        }

        string _oldField;
        public string OldField
        {
            get
            {
                if (_oldField == null)
                {
                    _oldField = ConfigurationManager.AppSettings[Constants.OLD_FIELD];
                }
                return _oldField;
            }
        }

        string _newField;
        public string NewField
        {
            get
            {
                if (_newField == null)
                {
                    _newField = ConfigurationManager.AppSettings[Constants.NEW_FIELD];
                }
                return _newField;
            }
        }

        #endregion

        public RenameField()
        {
            using (CoreServiceProvider coreService = new CoreServiceProvider())
            {
                string[] componentUris = coreService.FindComponentsBySchema(SchemaUri);

                foreach (string componentUri in componentUris)
                {
                    ComponentData componentData = coreService.Read<ComponentData>(componentUri);
                    Console.WriteLine("Processing \"{0}\" ({1}) in\r\n\"{2}\"",
                        componentData.Title,
                        componentUri,
                        HttpUtility.UrlDecode(componentData.LocationInfo.WebDavUrl));

                    if (ProcessComponent(componentData))
                    {
                        coreService.Update(componentData);
                        Console.WriteLine("Renamed");
                    }
                    else
                    {
                        componentData.Title += " ";
                        coreService.Update(componentData);
                        Console.WriteLine("Resynced");
                    }

                    Console.WriteLine();
                }
            }
        }

        private bool ProcessComponent(ComponentData componentData)
        {
            XmlDocument componentXml = new XmlDocument();
            componentXml.LoadXml(componentData.Metadata);

            XmlNode rootNode = componentXml.DocumentElement;
            XmlNamespaceManager nsmgr = new XmlNamespaceManager(componentXml.NameTable);
            nsmgr.AddNamespace("ns", rootNode.NamespaceURI);

            XmlNodeList sourceNodes = rootNode.SelectNodes("ns:" + OldField, nsmgr);
            if (sourceNodes.Count == 0)
            {
                return false;
            }

            foreach (XmlNode sourceNode in sourceNodes)
            {
                RenameNode(sourceNode, rootNode.NamespaceURI, NewField);
            }

            Console.WriteLine(Util.PrettyXml(componentXml.OuterXml));
            componentData.Metadata = componentXml.OuterXml;

            return true;
        }

        private XmlNode RenameNode(XmlNode oldNode, string namespaceUri, string newName)
        {
            if (oldNode.NodeType == XmlNodeType.Element)
            {
                XmlElement oldElement = (XmlElement)oldNode;
                XmlElement newElement = oldNode.OwnerDocument.CreateElement(newName, namespaceUri);

                while (oldElement.HasAttributes)
                {
                    newElement.SetAttributeNode(oldElement.RemoveAttributeNode(oldElement.Attributes[0]));
                }

                while (oldElement.HasChildNodes)
                {
                    newElement.AppendChild(oldElement.FirstChild);
                }

                if (oldElement.ParentNode != null)
                {
                    oldElement.ParentNode.ReplaceChild(newElement, oldElement);
                }

                return newElement;
            }
            else
            {
                return null;
            }
        }
    }
}
