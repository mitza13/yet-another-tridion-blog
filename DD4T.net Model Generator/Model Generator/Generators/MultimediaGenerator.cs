using Mitza.ModelGenerator.Model;
using System;
using System.Collections.Generic;
using System.Linq;

namespace Mitza.ModelGenerator.Generators
{
    class MultimediaGenerator : GeneratorBase
    {
        public UsingsGenerator UsingsGenerator { get; set; }
        public ConstructorGenerator ConstructorGenerator { get; set; }

        public MultimediaGenerator(MultimediaModel model)
            : base(model)
        {
            UsingsGenerator = new UsingsGenerator(model);
            ConstructorGenerator = new ConstructorGenerator(model);

            GenerateModel();
            GenerateBuilder();
        }

        private void GenerateModel()
        {
            Console.WriteLine("Generating multimedia class {0}", ClassName);

            CreateClass();

            UsingsGenerator.GenerateModelUsings();

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
            ConstructorGenerator.GenerateModelConstructor();

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
            WriteLine("    public class {0} : BuilderBase<dd4t.IComponent, {1}>", ClassName, ClassNameModel);
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
            WriteLine("        public override {0} Build(dd4t.IComponent multimediaComponent)", ClassNameModel);
            WriteLine("        {{");
            WriteLine("            if (multimediaComponent == null)");
            WriteLine("            {{");
            WriteLine("                return null;");
            WriteLine("            }}");
            WriteLine();

            if (Model.MetadataFields.Count > 0)
            {
                WriteLine("            dd4t.IFieldSet metadataFields = multimediaComponent.MetadataFields;");
            }

            WriteLine("            {0} {1} = new {0}(multimediaComponent)", ClassNameModel, ModelObjectName);
            WriteLine("            {{");

            if (Model.MetadataFields.Count > 0)
            {
                WriteLine("                Metadata = new {0}.{1}()", ClassNameModel, MetadataClassName);
                WriteLine("                {{");

                IList<Field> fields = Model.MetadataFields.OrderBy(x => x.Name).ToList();
                for (int i = 0; i < fields.Count; i++)
                {
                    Field field = fields[i];
                    WriteLine("                    {0} = {1}{2}",
                        GetPropertyName(field),
                        GetFieldInitializer(field, "metadataFields"),
                        i == fields.Count - 1 ? "" : ",");
                }

                WriteLine("                }}");
            }

            WriteLine("            }};");
            WriteLine();
            WriteLine("            return {0};", ModelObjectName);
            WriteLine("        }}");
        }
    }
}
