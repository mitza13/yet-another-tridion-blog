using Federation.Client.MyCoreService;
using System;
using System.Configuration;
using System.IdentityModel.Protocols.WSTrust;
using System.IdentityModel.Tokens;
using System.Linq;
using System.ServiceModel;
using System.ServiceModel.Security;

namespace Federation.Client
{
    /// <summary>
    /// Instantiate SessionAwareCoreService client directly and feed in ClientCredentials to the proxy
    /// </summary>
    public class Example5
    {
        private static string username = ConfigurationManager.AppSettings["Username"];
        private static string password = ConfigurationManager.AppSettings["Password"];
        private static string audienceId = "https://web85.playground/webservices/CoreService201603.svc/wsFederationHttp";
        private static string tokenEndpointAddress = "https://adssdl-publishe.adssdl.com/adfs/services/trust/2005/usernamemixed";

        public Example5()
        {
            Console.WriteLine("\r\nExample 5");

            using (var factory = new ChannelFactory<ISessionAwareCoreService>("coreServiceFederation"))
            {
                factory.Credentials.UserName.UserName = username;
                factory.Credentials.UserName.Password = password;

                var token = GetToken();
                ISessionAwareCoreService coreService = factory.CreateChannelWithIssuedToken(token);

                Console.WriteLine("API Version: {0}", coreService.GetApiVersion());

                UserData user = coreService.GetCurrentUser();
                Console.WriteLine("User: {0} | {1} | {2}", user.Title, user.Description, user.Id);

                IdentifiableObjectData[] publications = coreService.GetSystemWideList(new PublicationsFilterData());
                Console.WriteLine("Found {0} Publications:", publications.Length);
                publications.Cast<PublicationData>().ToList().
                    ForEach(x => Console.WriteLine("\t{0} | {1}", x.Title, x.Id));
            }
        }

        private SecurityToken GetToken()
        {
            WSHttpBinding binding = new WSHttpBinding();
            binding.Security.Message.ClientCredentialType = MessageCredentialType.UserName;
            binding.Security.Message.EstablishSecurityContext = false;
            binding.Security.Mode = SecurityMode.TransportWithMessageCredential;

            var endpoint = new EndpointAddress(tokenEndpointAddress);

            WSTrustChannelFactory factory = new WSTrustChannelFactory(binding, endpoint);
            factory.Credentials.UserName.UserName = username;
            factory.Credentials.UserName.Password = password;

            RequestSecurityToken request = new RequestSecurityToken(RequestTypes.Issue);
            request.AppliesTo = new EndpointReference(audienceId);

            return factory.CreateChannel().Issue(request);
        }
    }
}
