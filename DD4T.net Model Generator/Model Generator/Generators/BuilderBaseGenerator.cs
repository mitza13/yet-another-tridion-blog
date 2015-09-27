using Mitza.ModelGenerator.Common;
using Mitza.ModelGenerator.Model;
using System;
using System.Configuration;
using System.IO;

namespace Mitza.ModelGenerator.Generators
{
    public class BuilderBaseGenerator : GeneratorBase
    {
        public BuilderBaseGenerator()
            : base(new ComponentModel(string.Empty) { Name = "Builder Base" })
        {
            Console.WriteLine("Generating class BuilderBase");

            ClassName = "BuilderBase";
            GeneratorMode = GeneratorMode.Builder;

            string content = "using {0};\r\n" +
                "using DD4T.ContentModel;\r\n" +
                "using System.Collections.Generic;\r\n" +
                "using System.Linq;\r\n" +
                "\r\n" +
                "namespace {1}\r\n" +
                "{{\r\n" +
                "    public abstract class {2}<From, To> where To : ModelBase\r\n" +
                "    {{\r\n" +
                "        public abstract To Build(From fromValue);\r\n" +
                "\r\n" +
                "        public IList<To> Build(IList<From> fromValueList)\r\n" +
                "        {{\r\n" +
                "            if (fromValueList == null || fromValueList.Count == 0)\r\n" +
                "            {{\r\n" +
                "                return new List<To>();\r\n" +
                "            }}\r\n" +
                "\r\n" +
                "            IList<To> result = fromValueList.Select(x => Build(x)).ToList<To>();\r\n" +
                "\r\n" +
                "            return result;\r\n" +
                "        }}\r\n" +
                "    }}\r\n" +
                "}}";

            string filePath = string.Format(@"{0}\Builder\{1}.cs", ConfigurationManager.AppSettings[Constants.FOLDER], ClassNameModel);
            Directory.CreateDirectory(Path.GetDirectoryName(filePath));
            File.WriteAllText(filePath, string.Format(content, NamespaceModel, Namespace, ClassNameModel));
        }
    }
}
