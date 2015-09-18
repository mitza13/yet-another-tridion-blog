using System.Xml.Linq;

namespace Mitza.ModelGenerator.Common
{
    public static class Constants
    {
        public readonly static XNamespace XSD_NAMESPACE = XNamespace.Get("http://www.w3.org/2001/XMLSchema");
        public readonly static XNamespace TCM_NAMESPACE = XNamespace.Get("http://www.tridion.com/ContentManager/5.0");
        public readonly static XNamespace XLINK_NAMESPACE = XNamespace.Get("http://www.w3.org/1999/xlink");

        public const string FOLDER = "Folder";
        public const string NAMESPACE = "Namespace";
        public const string PASSWORD = "Password";
        public const string START_TCMURI = "StartTcmUri";
        public const string TRIDION_CME_URL = "TridionCmeUrl";
        public const string USER_NAME = "Username";
    }
}
