using Mitza.ModelGenerator.Model;
using System;
using System.Collections.Generic;
using System.Linq;

namespace Mitza.ModelGenerator.Generators
{
    public class ComponentGenerator : GeneratorBase
    {
        public ComponentGenerator(ComponentModel model)
            : base(model)
        {
            UsingsGenerator = new UsingsGenerator(model);
            ConstructorGenerator = new ConstructorGenerator(model);

            GenerateModel();
            GenerateBuilder();
        }

        private void GenerateModel()
        {
            Console.WriteLine("Generating Component class {0}", ClassName);

            CreateClass();

            UsingsGenerator.GenerateModelUsings();

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
            WriteLine("        public override {0} Build(dd4t.IComponent component)", ClassNameModel);
            WriteLine("        {{");
            WriteLine("            if (component == null)");
            WriteLine("            {{");
            WriteLine("                return null;");
            WriteLine("            }}");
            WriteLine();

            if (Model.Fields.Count > 0)
            {
                WriteLine("            dd4t.IFieldSet fields = component.Fields;");
            }

            if (Model.MetadataFields.Count > 0)
            {
                WriteLine("            dd4t.IFieldSet metadataFields = component.MetadataFields;");
            }

            WriteLine("            {0} {1} = new {0}(component)", ClassNameModel, ModelObjectName);
            WriteLine("            {{");

            if (Model.Fields.Count > 0)
            {
                IList<Field> fields = Model.Fields.OrderBy(x => x.Name).ToList();
                for (int i = 0; i < fields.Count; i++)
                {
                    Field field = fields[i];
                    WriteLine("                {0} = {1}{2}",
                        GetPropertyName(field),
                        GetFieldInitializer(field, "fields"),
                        i == fields.Count - 1 && Model.MetadataFields.Count == 0 ? "" : ",");
                }
                if (Model.MetadataFields.Count > 0)
                {
                    WriteLine();
                }
            }

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
