using Mitza.ModelGenerator.Model;
using System.Text;
using System.Text.RegularExpressions;

namespace Mitza.ModelGenerator.Common
{
    public static class Util
    {
        public static TypeKind Parse(string typeType)
        {
            switch (typeType)
            {
                case "ComponentLink":
                    return TypeKind.ComponentLink;

                case "MultimediaLink":
                    return TypeKind.MultimediaLink;

                case "tcmi:MultiLineText":
                case "tcmi:SimpleLink":
                case "tcmi:XHTML":
                case "xsd:normalizedString":
                    return TypeKind.Text;

                case "xsd:dateTime":
                    return TypeKind.Date;

                case "xsd:decimal":
                    return TypeKind.Numeric;

                default:
                    if (typeType == null)
                    {
                        return TypeKind.Text;
                    }
                    if (typeType.StartsWith("category:"))
                    {
                        return TypeKind.Keyword;
                    }

                    return TypeKind.Text;
            }
        }

        public static string MakeCamelCase(string name)
        {
            StringBuilder sb = new StringBuilder();
            foreach (string part in Regex.Split(name, @"[\W_]+"))
            {
                if (part.Length > 0)
                {
                    sb.Append(part.Substring(0, 1).ToUpper());
                    if (part.Length > 1)
                    {
                        sb.Append(part.Substring(1).ToLower());
                    }
                }
            }
            return sb.ToString();
        }

        public static string RemoveLeadingDigits(string name)
        {
            return Regex.Replace(name, @"^\d+", string.Empty);
        }

        public static string MakeClassName(string name)
        {
            name = MakeCamelCase(name);
            name = RemoveLeadingDigits(name);

            return name;
        }

        public static string MakeEmbeddedClassName(string name)
        {
            return "Embedded" + MakeClassName(name);
        }

        public static string MakeMultimediaClassName(string name)
        {
            return "Multimedia" + MakeClassName(name);
        }

        public static string MakePropertyName(string name)
        {
            return MakeClassName(name);
        }
    }
}
