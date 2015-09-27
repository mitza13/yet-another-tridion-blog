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
            WriteLine("{0}        /// <summary>", padding);
            if (field.IsHeterogenous)
            {
                string types = string.Join(", ", field.Types.Select(x => x.Name).OrderBy(x => x));
                if (field.IsMultivalue)
                {
                    WriteLine("{0}        /// <para>List of either: {1}</para>", padding, types);
                }
                else
                {
                    WriteLine("{0}        /// <para>Can be one of: {1}</para>", padding, types);
                }
            }
            if (field.IsMandatory)
            {
                WriteLine("{0}        /// <para>Mandatory field</para>", padding);
            }
            else
            {
                WriteLine("{0}        /// <para>Optional field might be null</para>", padding);
            }
            WriteLine("{0}        /// </summary>", padding);
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
                type = Util.GetPropertyType(field.Type);
            }

            if (field.IsMultivalue)
            {
                type = string.Format("IList<{0}>", type);
            }

            return type;
        }
    }
}
