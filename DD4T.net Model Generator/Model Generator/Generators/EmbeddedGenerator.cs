using Mitza.ModelGenerator.Model;
using System;
using System.Collections.Generic;
using System.Linq;

namespace Mitza.ModelGenerator.Generators
{
    class EmbeddedGenerator : GeneratorBase
    {
        public EmbeddedGenerator(EmbeddedModel model)
            : base(model)
        {
            UsingsGenerator = new UsingsGenerator(model);
            ConstructorGenerator = new ConstructorGenerator(model);

            GenerateModel();
            GenerateBuilder();
        }

        private void GenerateModel()
        {
            Console.WriteLine("Generating embedded class {0}", ClassName);

            CreateClass();

            UsingsGenerator.GenerateModelUsings();

            WriteLine("namespace {0}", Namespace);
            WriteLine("{{");
            WriteLine("    public class {0} : ModelBase", ClassName);
            WriteLine("    {{");

            new FieldsGenerator(Model, Model.Fields);

            WriteLine("    }}");
            WriteLine("}}");
        }

        private void GenerateBuilder()
        {
            GeneratorMode = GeneratorMode.Builder;
            Console.WriteLine("Generating builder for class {0}", ClassName);

            CreateClass();

            UsingsGenerator.GenerateBuilderUsings();

            WriteLine("namespace {0}", Namespace);
            WriteLine("{{");
            WriteLine("    public class {0} : BuilderBase<dd4t.IFieldSet, {1}>", ClassName, ClassNameModel);
            WriteLine("    {{");
            WriteLine("        private static readonly {0} _instance = new {0}();", ClassName);
            WriteLine("        public static {0} Instance {{ get {{ return _instance; }} }}", ClassName);
            WriteLine();

            ConstructorGenerator.GenerateBuilderConstructor();

            GenerateBuildMethod();

            WriteLine("    }}");
            WriteLine("}}");
        }

        private void GenerateBuildMethod()
        {
            WriteLine("        public override {0} Build(dd4t.IFieldSet fields)", ClassNameModel);
            WriteLine("        {{");
            WriteLine("            {0} {1} = new {0}()", ClassNameModel, ModelObjectName);
            WriteLine("            {{");

            IList<Field> fields = Model.Fields.OrderBy(x => x.Name).ToList();
            for (int i = 0; i < fields.Count; i++)
            {
                Field field = fields[i];
                WriteLine("                {0} = {1}{2}",
                    GetPropertyName(field),
                    GetFieldInitializer(field, "fields"),
                    i == fields.Count - 1 && Model.MetadataFields.Count == 0 ? "" : ",");
            }

            WriteLine("            }};");
            WriteLine();
            WriteLine("            return {0};", ModelObjectName);
            WriteLine("        }}");
        }
    }
}
