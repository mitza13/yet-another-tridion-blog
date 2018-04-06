using Federation.Client.MyService;
using System;

namespace Federation.Client
{
    /// <summary>
    /// Instantiate factory using ChannelFactory, then get the service proxy from it.
    /// User/pass is set in the factory.
    /// </summary>
    public class Example2
    {
        public Example2()
        {
            Console.WriteLine("\r\nExample 2");

            using (var factory = new CoreServiceFactory<IMyService>("myServiceEndpoint"))
            {
                IMyService service = factory.CreateChannel();

                string result = service.GetData();
                Console.WriteLine(result);
            }
        }
    }
}
