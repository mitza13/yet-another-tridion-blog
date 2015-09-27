using Mitza.ModelGenerator.Model;
using System;

namespace Mitza.ModelGenerator.Generators
{
    public class MultimediaBaseGenerator : GeneratorBase
    {
        public MultimediaBaseGenerator()
            : base(new ComponentModel(string.Empty) { Name = "Multimedia Base" })
        {
            Console.WriteLine("Generating class MultimediaBase");

            CreateClass();

            string content = "using dd4t = DD4T.ContentModel;\r\n" +
                "\r\n" +
                "namespace {0}\r\n" +
                "{{\r\n" +
                "    public class MultimediaBase : ModelBase\r\n" +
                "    {{\r\n" +
                "        public dd4t.IMultimedia Multimedia {{ get; set; }}\r\n" +
                "\r\n" +
                "        public MultimediaBase(dd4t.IComponent multimediaComponent)\r\n" +
                "            : base(multimediaComponent)\r\n" +
                "        {{\r\n" +
                "            Multimedia = multimediaComponent.Multimedia;\r\n" +
                "        }}\r\n" +
                "    }}\r\n" +
                "}}";

            Write(content, Namespace);
        }
    }
}
