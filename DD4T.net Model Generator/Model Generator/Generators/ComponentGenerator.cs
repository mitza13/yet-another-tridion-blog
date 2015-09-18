using Mitza.ModelGenerator.Model;
using System;

namespace Mitza.ModelGenerator.Generators
{
    public class ComponentGenerator : GeneratorBase
    {
        public ComponentGenerator(ComponentModel model)
            : base(model)
        {
            Console.WriteLine("Generating Component class {0}", ClassName);

            CreateModelClass();

            new UsingsGenerator(Model);

            WriteLine("namespace {0}", Namespace);
            WriteLine("{{");
            WriteLine("    public class {0} : ModelBase", ClassName);
            WriteLine("    {{");

            new FieldsGenerator(Model, Model.Fields);

            if (Model.MetadataFields.Count > 0)
            {
                WriteLine("        public {0} Metadata {{ get; set; }}", MetadataClassName);
                WriteLine();
                WriteLine("        public class {0}", MetadataClassName);
                WriteLine("        {{");

                new FieldsGenerator(Model, Model.MetadataFields, "    ");

                WriteLine("        }}");
            }

            WriteLine();
            new ConstructorGenerator(Model);

            WriteLine("    }}");
            WriteLine("}}");
        }
    }
}
