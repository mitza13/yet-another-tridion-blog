using Mitza.ModelGenerator.Model;
using System.Linq;

namespace Mitza.ModelGenerator.Generators
{
    public class UsingsGenerator : GeneratorBase
    {
        public UsingsGenerator(ModelBase model) : base(model) { }

        public void GenerateModelUsings()
        {
            GeneratorMode = GeneratorMode.Model;
            bool found = false;

            if (Model is MultimediaModel ||
                Model is ComponentModel ||
                Model.Fields.FirstOrDefault(x => x.Type.TypeKind == TypeKind.Keyword) != null ||
                Model.MetadataFields.FirstOrDefault(x => x.Type.TypeKind == TypeKind.Keyword) != null)
            {
                found = true;
                WriteLine("using DD4T.ContentModel;");
            }

            if (Model.Fields.FirstOrDefault(x => x.Type.TypeKind == TypeKind.Date) != null ||
                Model.MetadataFields.FirstOrDefault(x => x.Type.TypeKind == TypeKind.Date) != null)
            {
                found = true;
                WriteLine("using System;");
            }

            if (Model.Fields.FirstOrDefault(x => x.IsMultivalue) != null ||
                Model.MetadataFields.FirstOrDefault(x => x.IsMultivalue) != null)
            {
                found = true;
                WriteLine("using System.Collections.Generic;");
            }

            if (found)
            {
                WriteLine();
            }
        }

        public void GenerateBuilderUsings()
        {
            GeneratorMode = GeneratorMode.Builder;

            WriteLine("using {0};", NamespaceModel);
            WriteLine("using dd4t = DD4T.ContentModel;");
            WriteLine();
        }
    }
}
