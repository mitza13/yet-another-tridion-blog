using Mitza.ModelGenerator.Model;
using System;

namespace Mitza.ModelGenerator.Generators
{
    class MultimediaGenerator : GeneratorBase
    {
        public MultimediaGenerator(MultimediaModel model)
            : base(model)
        {
            Console.WriteLine("Generating Multimedia class {0}", ClassName);

            CreateModelClass();

            new UsingsGenerator(Model);

            WriteLine("namespace {0}", Namespace);
            WriteLine("{{");
            WriteLine("    public class {0} : MultimediaBase", ClassName);
            WriteLine("    {{");
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
