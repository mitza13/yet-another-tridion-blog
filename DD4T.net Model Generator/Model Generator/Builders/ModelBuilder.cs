using Mitza.ModelGenerator.Common;
using Mitza.ModelGenerator.Model;
using System.Linq;
using System.Xml.Linq;
using Tridion.ContentManager.CoreService.Client;

namespace Mitza.ModelGenerator.Builders
{
    public class ModelBuilder
    {
        public ModelBuilder(SchemaData schema, ModelBase model)
        {
            XDocument doc = XDocument.Parse(schema.Xsd);
            model.Name = schema.Title;

            if (model is EmbeddedModel)
            {
                XElement complexType = doc.Root.Descendants(Constants.XSD_NAMESPACE + "complexType")
                    .FirstOrDefault(x => x.Attribute("name") != null && x.Attribute("name").Value == schema.RootElementName);
                new FieldsBuilder(complexType, model.Fields);
            }
            else
            {
                XElement content = doc.Root.Descendants(Constants.XSD_NAMESPACE + "element")
                    .FirstOrDefault(x => x.Attribute("name") != null && x.Attribute("name").Value == "Content");
                new FieldsBuilder(content, model.Fields);

                XElement metadata = doc.Root.Descendants(Constants.XSD_NAMESPACE + "element")
                    .FirstOrDefault(x => x.Attribute("name") != null && x.Attribute("name").Value == "Metadata");
                new FieldsBuilder(metadata, model.MetadataFields);
            }
        }
    }
}
