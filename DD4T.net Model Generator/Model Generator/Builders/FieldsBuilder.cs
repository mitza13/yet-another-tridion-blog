using Mitza.ModelGenerator.Common;
using Mitza.ModelGenerator.Model;
using System.Collections.Generic;
using System.Xml.Linq;

namespace Mitza.ModelGenerator.Builders
{
    public class FieldsBuilder
    {
        public FieldsBuilder(XElement fieldsElement, IList<Field> fields)
        {
            if (fieldsElement == null)
            {
                return;
            }

            foreach (XElement fieldElement in fieldsElement.Descendants(Constants.XSD_NAMESPACE + "element"))
            {
                Field field = new Field
                {
                    Name = fieldElement.Attribute("name").Value,
                    IsMultivalue = fieldElement.Attribute("maxOccurs").Value == "unbounded"
                };
                fields.Add(field);

                TypesBuilder typeBuilder = new TypesBuilder(fieldElement);
                field.Types.UnionWith(typeBuilder.Types);
            }
        }
    }
}
