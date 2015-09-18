using Mitza.ModelGenerator.Common;
using Mitza.ModelGenerator.Model;
using System.Collections.Generic;
using System.Linq;

namespace Mitza.ModelGenerator.Generators
{
    public class FieldsGenerator : GeneratorBase
    {
        public FieldsGenerator(ModelBase model, IList<Field> fields, string padding = "")
            : base(model)
        {
            foreach (Field field in fields.OrderBy(x => x.Name))
            {
                GenerateField(field, padding);
            }
        }

        private void GenerateField(Field field, string padding)
        {
            GenerateComment(field, padding);
            WriteLine("{0}        public {1} {2} {{ get; set; }}", padding, GetPropertyType(field), GetPropertyName(field));
        }

        private void GenerateComment(Field field, string padding)
        {
            if (field.IsHeterogenous)
            {
                WriteLine("{0}        /// <summary>", padding);
                string types = string.Join(", ", field.Types.Select(x => x.Name).OrderBy(x => x));
                if (field.IsMultivalue)
                {
                    WriteLine("{0}        /// List of either: {1}", padding, types);
                }
                else
                {
                    WriteLine("{0}        /// Can be one of: Article, Asset, Internal Link, External Link", padding);
                }
                WriteLine("{0}        /// </summary>", padding);
            }
        }

        private string GetPropertyType(Field field)
        {
            string type;
            if (field.IsHeterogenous)
            {
                type = "ModelBase";
            }
            else
            {
                Type fieldType = field.Type;
                switch (fieldType.TypeKind)
                {
                    case TypeKind.ComponentLink:
                        type = Util.MakeClassName(fieldType.Name);
                        break;

                    case TypeKind.Date:
                        type = "DateTime";
                        break;

                    case TypeKind.Embedded:
                        type = Util.MakeEmbeddedClassName(fieldType.Name);
                        break;

                    case TypeKind.Keyword:
                        type = "IKeyword";
                        break;

                    case TypeKind.MultimediaLink:
                        type = Util.MakeMultimediaClassName(fieldType.Name);
                        break;

                    case TypeKind.Numeric:
                        type = "double";
                        break;

                    case TypeKind.Text:
                    default:
                        type = "string";
                        break;
                }
            }

            if (field.IsMultivalue)
            {
                type = string.Format("IList<{0}>", type);
            }

            return type;
        }

        private string GetPropertyName(Field field)
        {
            string name = Util.MakePropertyName(field.Name);
            switch (name)
            {
                case "Id":
                case "Title":
                case "Schema":
                    name += "Field";
                    break;
            }

            return name;
        }
    }
}
