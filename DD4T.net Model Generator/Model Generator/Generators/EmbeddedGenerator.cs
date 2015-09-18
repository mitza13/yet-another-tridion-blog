using Mitza.ModelGenerator.Model;
using System;

namespace Mitza.ModelGenerator.Generators
{
    class EmbeddedGenerator : GeneratorBase
    {
        public EmbeddedGenerator(EmbeddedModel model)
            : base(model)
        {
            Console.WriteLine("Generating Embedded class {0}", ClassName);

            CreateModelClass();

            new UsingsGenerator(Model);

            WriteLine("namespace {0}", Namespace);
            WriteLine("{{");
            WriteLine("    public class {0} : ModelBase", ClassName);
            WriteLine("    {{");

            new FieldsGenerator(Model, Model.Fields);

            WriteLine("    }}");
            WriteLine("}}");
        }
    }
}
