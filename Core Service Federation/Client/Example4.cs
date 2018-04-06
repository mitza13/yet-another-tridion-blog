using Federation.Client.MyCoreService;
using System;
using System.Configuration;
using System.Linq;

namespace Federation.Client
{
    /// <summary>
    /// Instantiate SessionAwareCoreService client directly and feed in ClientCredentials to the proxy
    /// </summary>
    public class Example4
    {
        public Example4()
        {
            Console.WriteLine("\r\nExample 4");

            using (var coreService = new SessionAwareCoreServiceClient("coreServiceFederation"))
            {
                coreService.ClientCredentials.UserName.UserName = ConfigurationManager.AppSettings["Username"];
                coreService.ClientCredentials.UserName.Password = ConfigurationManager.AppSettings["Password"];

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
