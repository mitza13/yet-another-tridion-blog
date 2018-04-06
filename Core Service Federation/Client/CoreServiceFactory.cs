using System;
using System.Configuration;
using System.ServiceModel;

namespace Federation.Client
{
    public class CoreServiceFactory<T> : IDisposable
    {
        private static string username = ConfigurationManager.AppSettings["Username"];
        private static string password = ConfigurationManager.AppSettings["Password"];

        private ChannelFactory<T> factory;

        public CoreServiceFactory(string endpoint)
        {
            factory = new ChannelFactory<T>(endpoint);
            factory.Credentials.UserName.UserName = username;
            factory.Credentials.UserName.Password = password;
        }

        public void Dispose()
        {
            factory.Close();
        }

        public T CreateChannel()
        {
            return factory.CreateChannel();
        }
    }
}