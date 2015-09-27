using Mitza.ModelGenerator.Common;
using Mitza.ModelGenerator.Model;
using System;
using System.Configuration;
using System.IO;

namespace Mitza.ModelGenerator.Generators
{
    public class IFieldsSetExtensionMethodsGenerator : GeneratorBase
    {
        public IFieldsSetExtensionMethodsGenerator()
            : base(new ComponentModel(string.Empty) { Name = "I Fields Set Extension Methods" })
        {
            Console.WriteLine("Generating class IFieldsSetExtensionMethodsGenerator");

            ClassName = "IFieldsSetExtensionMethods";
            GeneratorMode = GeneratorMode.Builder;

            string content = "using DD4T.ContentModel;\r\n" +
                "using DD4T.Mvc.Html;\r\n" +
                "using System;\r\n" +
                "using System.Collections.Generic;\r\n" +
                "using System.Linq;\r\n" +
                "\r\n" +
                "namespace {0}\r\n" +
                "{{\r\n" +
                "    public static class IFieldSetExtensionMethods\r\n" +
                "    {{\r\n" +
                "        public static IList<DateTime> DateTimeValues(this IFieldSet fieldSet, string fieldName)\r\n" +
                "        {{\r\n" +
                "            return fieldSet == null || !fieldSet.ContainsKey(fieldName) ? new List<DateTime>() : fieldSet[fieldName].DateTimeValues;\r\n" +
                "        }}\r\n" +
                "\r\n" +
                "        public static DateTime DateTimeValue(this IFieldSet fieldSet, string fieldName)\r\n" +
                "        {{\r\n" +
                "            return fieldSet == null ? default(DateTime) : DateTimeValues(fieldSet, fieldName).FirstOrDefault<DateTime>();\r\n" +
                "        }}\r\n" +
                "\r\n" +
                "        public static IList<IFieldSet> EmbeddedValues(this IFieldSet fieldSet, string fieldName)\r\n" +
                "        {{\r\n" +
                "            return fieldSet == null || !fieldSet.ContainsKey(fieldName) ? new List<IFieldSet>() : fieldSet[fieldName].EmbeddedValues;\r\n" +
                "        }}\r\n" +
                "\r\n" +
                "        public static IFieldSet EmbeddedValue(this IFieldSet fieldSet, string fieldName)\r\n" +
                "        {{\r\n" +
                "            return fieldSet == null ? null : EmbeddedValues(fieldSet, fieldName).FirstOrDefault<IFieldSet>();\r\n" +
                "        }}\r\n" +
                "\r\n" +
                "        public static IList<IKeyword> KeywordValues(this IFieldSet fieldSet, string fieldName)\r\n" +
                "        {{\r\n" +
                "            return fieldSet == null || !fieldSet.ContainsKey(fieldName) ? new List<IKeyword>() : fieldSet[fieldName].Keywords;\r\n" +
                "        }}\r\n" +
                "\r\n" +
                "        public static IKeyword KeywordValue(this IFieldSet fieldSet, string fieldName)\r\n" +
                "        {{\r\n" +
                "            return fieldSet == null ? null : KeywordValues(fieldSet, fieldName).FirstOrDefault<IKeyword>();\r\n" +
                "        }}\r\n" +
                "\r\n" +
                "        public static IList<IComponent> LinkedComponentValues(this IFieldSet fieldSet, string fieldName)\r\n" +
                "        {{\r\n" +
                "            return fieldSet == null || !fieldSet.ContainsKey(fieldName) ? new List<IComponent>() : fieldSet[fieldName].LinkedComponentValues;\r\n" +
                "        }}\r\n" +
                "\r\n" +
                "        public static IComponent LinkedComponentValue(this IFieldSet fieldSet, string fieldName)\r\n" +
                "        {{\r\n" +
                "            return fieldSet == null ? null : LinkedComponentValues(fieldSet, fieldName).FirstOrDefault<IComponent>();\r\n" +
                "        }}\r\n" +
                "\r\n" +
                "        public static IList<double> NumericValues(this IFieldSet fieldSet, string fieldName)\r\n" +
                "        {{\r\n" +
                "            return fieldSet == null || !fieldSet.ContainsKey(fieldName) ? new List<double>() : fieldSet[fieldName].NumericValues;\r\n" +
                "        }}\r\n" +
                "\r\n" +
                "        public static double NumericValue(this IFieldSet fieldSet, string fieldName)\r\n" +
                "        {{\r\n" +
                "            return fieldSet == null ? 0 : NumericValues(fieldSet, fieldName).FirstOrDefault<double>();\r\n" +
                "        }}\r\n" +
                "\r\n" +
                "        public static IList<string> StringValues(this IFieldSet fieldSet, string fieldName)\r\n" +
                "        {{\r\n" +
                "            return fieldSet == null || !fieldSet.ContainsKey(fieldName) ? new List<string>() : fieldSet[fieldName].Values;\r\n" +
                "        }}\r\n" +
                "\r\n" +
                "        public static string StringValue(this IFieldSet fieldSet, string fieldName)\r\n" +
                "        {{\r\n" +
                "            return fieldSet == null ? string.Empty : StringValues(fieldSet, fieldName).FirstOrDefault<string>() ?? string.Empty;\r\n" +
                "        }}\r\n" +
                "\r\n" +
                "        public static IList<string> ResolveRichTexts(this IFieldSet fieldSet, string fieldName)\r\n" +
                "        {{\r\n" +
                "            return StringValues(fieldSet, fieldName).Select(x => x.ResolveRichText().ToString()).ToList();\r\n" +
                "        }}\r\n" +
                "\r\n" +
                "        public static string ResolveRichText(this IFieldSet fieldSet, string fieldName)\r\n" +
                "        {{\r\n" +
                "            string value = StringValues(fieldSet, fieldName).FirstOrDefault<string>();\r\n" +
                "            return value == null ? null : value.ResolveRichText().ToString();\r\n" +
                "        }}\r\n" +
                "    }}\r\n" +
                "}}";

            string filePath = string.Format(@"{0}\Builder\{1}.cs", ConfigurationManager.AppSettings[Constants.FOLDER], ClassNameModel);
            Directory.CreateDirectory(Path.GetDirectoryName(filePath));
            File.WriteAllText(filePath, string.Format(content, Namespace));
        }
    }
}
