using System.Text;
using System.Xml;
using System.Xml.Linq;

namespace Mitza.RenameField.Common
{
    public static class Util
    {
        public static string PrettyXml(string xml)
        {
            var stringBuilder = new StringBuilder();
            var element = XElement.Parse(xml);
            var settings = new XmlWriterSettings();

            settings.OmitXmlDeclaration = true;
            settings.Indent = true;
            settings.NewLineOnAttributes = true;

            using (var xmlWriter = XmlWriter.Create(stringBuilder, settings))
            {
                element.Save(xmlWriter);
            }

            return stringBuilder.ToString();
        }
    }
}
