using Federation.Client.MyService;
using System;
using System.Configuration;

namespace Federation.Client
{
    /// <summary>
    /// Instantiate service proxy directly and feed in ClientCredentials to the proxy
    /// </summary>
    public class Example1
    {
        public Example1()
        {
            Console.WriteLine("Example 1");

            using (var service = new MyServiceClient("myServiceEndpoint"))
            {
                service.ClientCredentials.UserName.UserName = ConfigurationManager.AppSettings["Username"];
                service.ClientCredentials.UserName.Password = ConfigurationManager.AppSettings["Password"];

                string result = service.GetData();
                Console.WriteLine(result);
            }
        }
    }
}
