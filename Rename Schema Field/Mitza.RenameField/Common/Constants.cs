using System.Xml.Linq;

namespace Mitza.RenameField.Common
{
    public static class Constants
    {
        public readonly static XNamespace TCM_NAMESPACE = XNamespace.Get("http://www.tridion.com/ContentManager/5.0");

        public const string CORE_SERVICE_ENDPOINT = "/webservices/CoreService2013.svc/basicHttp";
        public const string NEW_FIELD = "DestinationField";
        public const string OLD_FIELD = "SourceField";
        public const string PASSWORD = "Password";
        public const string SCHEMA_URI = "SchemaUri";
        public const string TRIDION_CME_URL = "TridionCmeUrl";
        public const string USER_NAME = "Username";
    }
}
