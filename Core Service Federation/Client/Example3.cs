using Federation.Client.MyCoreService;
using System;
using System.Linq;

namespace Federation.Client
{
    /// <summary>
    /// Instantiate factory using ChannelFactory, then get the SessionAwareCoreService proxy from it.
    /// User/pass is set in the factory.
    /// </summary>
    public class Example3
    {
        public Example3()
        {
            Console.WriteLine("\r\nExample 3");

            using (var factory = new CoreServiceFactory<ISessionAwareCoreService>("coreServiceFederation"))
            {
                //var token = Token.GetToken();
                //ISessionAwareCoreService coreService = factory.CreateFederatedChannel(token);
                ISessionAwareCoreService coreService = factory.CreateChannel();

                Console.WriteLine("API Version: {0}", coreService.GetApiVersion());

                UserData user = coreService.GetCurrentUser();
                Console.WriteLine("User: {0} | {1} | {2}", user.Title, user.Description, user.Id);

                IdentifiableObjectData[] publications = coreService.GetSystemWideList(new PublicationsFilterData());
                Console.WriteLine("Found {0} Publications:", publications.Length);
                publications.Cast<PublicationData>().ToList().
                    ForEach(x => Console.WriteLine("\t{0} | {1}", x.Title, x.Id));
            }
        }
    }
}
