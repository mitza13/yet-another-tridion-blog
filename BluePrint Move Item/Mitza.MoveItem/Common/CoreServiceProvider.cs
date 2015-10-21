using System;
using System.Configuration;
using System.Net;
using System.ServiceModel;
using System.Xml;
using Tridion.ContentManager.CoreService.Client;

namespace Mitza.MoveItem.Common
{
    public class CoreServiceProvider : IDisposable
    {
        #region Properties

        private ReadOptions _readOptions;
        public ReadOptions ReadOptions
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

                    string coreServiceUrl = ConfigurationManager.AppSettings[Constants.CORE_SERVICE_ENDPOINT];
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
        public ICoreService Client
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
    }
}
