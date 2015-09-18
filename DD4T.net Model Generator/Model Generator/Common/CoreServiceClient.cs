using System;
using System.Configuration;
using System.Linq;
using System.Net;
using System.ServiceModel;
using System.Xml;
using Tridion.ContentManager.CoreService.Client;

namespace Mitza.ModelGenerator.Common
{
    public class CoreServiceProvider : IDisposable
    {
        public ICoreService Client { get; private set; }
        private readonly ChannelFactory<ICoreService> factory;

        public CoreServiceProvider()
        {
            var binding = new BasicHttpBinding
            {
                MaxReceivedMessageSize = 10485760,
                ReaderQuotas = new XmlDictionaryReaderQuotas
                {
                    MaxStringContentLength = 10485760,
                    MaxArrayLength = 10485760
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

            string coreServiceUrl = ConfigurationManager.AppSettings[Constants.TRIDION_CME_URL] + "/webservices/CoreService2013.svc/basicHttp";
            Console.WriteLine("Connect to CoreService " + coreServiceUrl);

            EndpointAddress endpoint = new EndpointAddress(coreServiceUrl);
            factory = new ChannelFactory<ICoreService>(binding, endpoint);

            string userName = ConfigurationManager.AppSettings[Constants.USER_NAME];
            string password = ConfigurationManager.AppSettings[Constants.PASSWORD];
            factory.Credentials.Windows.ClientCredential = new NetworkCredential(userName, password);

            Client = factory.CreateChannel();

            UserData user = Client.GetCurrentUser();
            Console.WriteLine("Connected as {0} ({1})", user.Description, user.Title);
        }

        public void Dispose()
        {
            if (factory.State == CommunicationState.Faulted)
            {
                factory.Abort();
            }
            else
            {
                factory.Close();
            }
        }

        public string[] GetSchemaIds()
        {
            string tcmUri = ConfigurationManager.AppSettings[Constants.START_TCMURI];
            SubjectRelatedListFilterData filter = new RepositoryItemsFilterData
            {
                ItemTypes = new[] {
                    ItemType.Schema
                },
                SchemaPurposes = new[] {
                    SchemaPurpose.Component,
                    SchemaPurpose.Embedded,
                    SchemaPurpose.Multimedia
                },
                Recursive = true
            };

            string[] result = Client.GetList(tcmUri, filter).Select(x => x.Id).ToArray();
            Console.WriteLine("Found {0} Schemas", result.Length);

            return result;
        }

        public SchemaData GetSchema(string tcmUri)
        {
            ReadOptions readOptions = new ReadOptions { LoadFlags = LoadFlags.None };
            return (SchemaData)Client.Read(tcmUri, readOptions);
        }
    }
}
