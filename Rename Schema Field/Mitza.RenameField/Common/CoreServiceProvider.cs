using System;
using System.Configuration;
using System.Linq;
using System.Net;
using System.ServiceModel;
using System.Xml;
using System.Xml.Linq;
using Tridion.ContentManager.CoreService.Client;

namespace Mitza.RenameField.Common
{
    public class CoreServiceProvider : IDisposable
    {
        #region Properties

        private ReadOptions _readOptions;
        private ReadOptions ReadOptions
        {
            get
            {
                if (_readOptions == null)
                {
                    _readOptions = new ReadOptions { LoadFlags = LoadFlags.Expanded };
                }
                return _readOptions;
            }
        }

        private ChannelFactory<ICoreService> _factory;
        private ChannelFactory<ICoreService> Factory
        {
            get
            {
                if (_factory == null)
                {
                    var binding = new BasicHttpBinding
                    {
                        MaxReceivedMessageSize = 1048576,
                        ReaderQuotas = new XmlDictionaryReaderQuotas
                        {
                            MaxStringContentLength = 1048576,
                            MaxArrayLength = 1048576
                        },
                        Security = new BasicHttpSecurity
                        {
                            Mode = BasicHttpSecurityMode.TransportCredentialOnly,
                            Transport = new HttpTransportSecurity
                            {
                                ClientCredentialType = HttpClientCredentialType.Windows
                            }
                        }
                    };

                    string coreServiceUrl = ConfigurationManager.AppSettings[Constants.TRIDION_CME_URL] + Constants.CORE_SERVICE_ENDPOINT;
                    Console.WriteLine("Connect to CoreService " + coreServiceUrl);

                    EndpointAddress endpoint = new EndpointAddress(coreServiceUrl);
                    _factory = new ChannelFactory<ICoreService>(binding, endpoint);

                    string userName = ConfigurationManager.AppSettings[Constants.USER_NAME];
                    string password = ConfigurationManager.AppSettings[Constants.PASSWORD];
                    _factory.Credentials.Windows.ClientCredential = new NetworkCredential(userName, password);
                }

                return _factory;
            }
            set { _factory = value; }
        }

        private ICoreService _client;
        private ICoreService Client
        {
            get
            {
                if (_client == null)
                {
                    _client = Factory.CreateChannel();

                    UserData user = _client.GetCurrentUser();
                    Console.WriteLine("Connected as {0} ({1})", user.Description, user.Title);
                }

                return _client;
            }
        }

        #endregion

        public void Dispose()
        {
            if (Factory.State == CommunicationState.Faulted)
            {
                Factory.Abort();
            }
            else
            {
                Factory.Close();
            }
        }

        public T CheckOut<T>(string tcmUri) where T : VersionedItemData
        {
            return Client.CheckOut(tcmUri, true, ReadOptions) as T;
        }

        public T CheckIn<T>(string tcmUri) where T : VersionedItemData
        {
            return Client.CheckIn(tcmUri, true, "Mitza.RenameField", ReadOptions) as T;
        }

        public T UndoCheckOut<T>(string tcmUri) where T : VersionedItemData
        {
            return Client.UndoCheckOut(tcmUri, true, ReadOptions) as T;
        }

        public T Read<T>(string tcmUri) where T : IdentifiableObjectData
        {
            return Client.Read(tcmUri, ReadOptions) as T;
        }

        public T Save<T>(T deltaData) where T : IdentifiableObjectData
        {
            return Client.Save(deltaData, ReadOptions) as T;
        }

        public T Update<T>(T deltaData) where T : IdentifiableObjectData
        {
            return Client.Update(deltaData, ReadOptions) as T;
        }

        public string[] FindComponentsBySchema(string schemaUri)
        {
            SubjectRelatedListFilterData filter = new UsingItemsFilterData
            {
                ItemTypes = new[] { ItemType.Component },
                IncludedVersions = VersionCondition.OnlyLatestAndCheckedOutVersions,
                IncludeLocalCopies = true
            };

            XElement element = Client.GetListXml(schemaUri, filter);

            string[] result = element.Descendants(Constants.TCM_NAMESPACE + "Item")
                .Select(x => x.Attribute("ID").Value)
                .ToArray();
            Console.WriteLine("Found {0} Components on Schema '{1}'", result.Length, schemaUri);

            return result;
        }
    }
}
