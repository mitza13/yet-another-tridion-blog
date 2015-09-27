using Mitza.ModelGenerator.Model;
using System;

namespace Mitza.ModelGenerator.Generators
{
    public class ModelBaseGenerator : GeneratorBase
    {
        public ModelBaseGenerator()
            : base(new ComponentModel(string.Empty) { Name = "Model Base" })
        {
            Console.WriteLine("Generating class ModelBase");

            CreateClass();

            string content = "using DD4T.ContentModel;\r\n" +
                "using DD4T.ContentModel.Factories;\r\n" +
                "using System;\r\n" +
                "using System.Web.Mvc;\r\n" +
                "\r\n" +
                "namespace {0}\r\n" +
                "{{\r\n" +
                "    public class ModelBase : IComparable<ModelBase>\r\n" +
                "    {{\r\n" +
                "        public string Id {{ get; set; }}\r\n" +
                "        public ISchema Schema {{ get; set; }}\r\n" +
                "        public string Title {{ get; set; }}\r\n" +
                "\r\n" +
                "        private string resolvedUrl;\r\n" +
                "        public string ResolvedUrl\r\n" +
                "        {{\r\n" +
                "            get\r\n" +
                "            {{\r\n" +
                "                if (string.IsNullOrEmpty(resolvedUrl))\r\n" +
                "                {{\r\n" +
                "                    ILinkFactory linkFactory = DependencyResolver.Current.GetService<ILinkFactory>();\r\n" +
                "                    resolvedUrl = linkFactory.ResolveLink(Id);\r\n" +
                "                }}\r\n" +
                "\r\n" +
                "                return resolvedUrl;\r\n" +
                "            }}\r\n" +
                "        }}\r\n" +
                "\r\n" +
                "        public ModelBase() {{ }}\r\n" +
                "\r\n" +
                "        public ModelBase(IComponent component)\r\n" +
                "        {{\r\n" +
                "            Id = component.Id;\r\n" +
                "            Schema = component.Schema;\r\n" +
                "            Title = component.Title;\r\n" +
                "        }}\r\n" +
                "\r\n" +
                "        public int CompareTo(ModelBase other)\r\n" +
                "        {{\r\n" +
                "            if (other == null)\r\n" +
                "            {{\r\n" +
                "                return 1;\r\n" +
                "            }}\r\n" +
                "\r\n" +
                "            string otherId = other.Id;\r\n" +
                "\r\n" +
                "            if (Id == null && otherId == null)\r\n" +
                "            {{\r\n" +
                "                return 0;\r\n" +
                "            }}\r\n" +
                "            else if (otherId == null)\r\n" +
                "            {{\r\n" +
                "                return 1;\r\n" +
                "            }}\r\n" +
                "            else if (Id == null)\r\n" +
                "            {{\r\n" +
                "                return -1;\r\n" +
                "            }}\r\n" +
                "\r\n" +
                "            return Id.CompareTo(otherId);\r\n" +
                "        }}\r\n" +
                "\r\n" +
                "        public override int GetHashCode()\r\n" +
                "        {{\r\n" +
                "            return Id.GetHashCode();\r\n" +
                "        }}\r\n" +
                "\r\n" +
                "        public override bool Equals(object other)\r\n" +
                "        {{\r\n" +
                "            if (other == null || !(other is ModelBase))\r\n" +
                "            {{\r\n" +
                "                return false;\r\n" +
                "            }}\r\n" +
                "\r\n" +
                "            return this.CompareTo((ModelBase)other) == 0;\r\n" +
                "        }}\r\n" +
                "    }}\r\n" +
                "}}";

            Write(content, Namespace);
        }
    }
}
