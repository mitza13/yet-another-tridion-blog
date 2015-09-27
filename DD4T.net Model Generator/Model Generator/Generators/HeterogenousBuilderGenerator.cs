using Mitza.ModelGenerator.Common;
using Mitza.ModelGenerator.Model;
using System;
using System.Collections.Generic;
using System.Linq;

namespace Mitza.ModelGenerator.Generators
{
    public class HeterogenousBuilderGenerator : GeneratorBase
    {
        public HeterogenousBuilderGenerator(IEnumerable<Mitza.ModelGenerator.Model.Type> types)
            : base(new ComponentModel(string.Empty) { Name = "Heterogenous" })
        {
            GeneratorMode = GeneratorMode.Builder;

            if (types.Count() == 0)
            {
                return;
            }

            Console.WriteLine("Generating builder for class {0}", ClassName);
            UsingsGenerator = new UsingsGenerator(Model);
            ConstructorGenerator = new ConstructorGenerator(Model);

            CreateClass();

            UsingsGenerator.GenerateBuilderUsings();

            WriteLine("namespace {0}", Namespace);
            WriteLine("{{");
            WriteLine("    public class {0} : BuilderBase<dd4t.IComponent, ModelBase>", ClassName);
            WriteLine("    {{");
            WriteLine("        private static readonly {0} _instance = new {0}();", ClassName);
            WriteLine("        public static {0} Instance {{ get {{ return _instance; }} }}", ClassName);
            WriteLine();

            ConstructorGenerator.GenerateBuilderConstructor();

            GenerateBuildMethod(types);

            WriteLine("    }}");
            WriteLine("}}");
        }

        private void GenerateBuildMethod(IEnumerable<Model.Type> types)
        {
            WriteLine("        public override ModelBase Build(dd4t.IComponent component)", ClassNameModel);
            WriteLine("        {{");
            WriteLine("            if (component == null)");
            WriteLine("            {{");
            WriteLine("                return null;");
            WriteLine("            }}");
            WriteLine();
            WriteLine("            ModelBase model = null;");
            WriteLine();
            WriteLine("            switch (component.Schema.Title)");
            WriteLine("            {{");

            foreach (Model.Type type in types.GroupBy(x => x.Name).Select(x => x.First()).OrderBy(x => x.Name))
            {
                WriteLine("                case \"{0}\":", type.Name);
                WriteLine("                    model = {0}.Instance.Build(component);", Util.MakeBuilderClassName(type));
                WriteLine("                    break;");
                WriteLine();
            }

            WriteLine("                default:");
            WriteLine("                    // Some error");
            WriteLine("                    break;");

            WriteLine("            }}");
            WriteLine();
            WriteLine("            return model;");
            WriteLine("        }}");
        }
    }
}
