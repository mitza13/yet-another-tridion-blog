using Mitza.ModelGenerator.Model;
using System.Linq;

namespace Mitza.ModelGenerator.Generators
{
    public class UsingsGenerator : GeneratorBase
    {
        public UsingsGenerator(ModelBase model)
            : base(model)
        {
            bool found = false;

            if (model is MultimediaModel ||
                model is ComponentModel ||
                model.Fields.FirstOrDefault(x => x.Type.TypeKind == TypeKind.Keyword) != null ||
                model.MetadataFields.FirstOrDefault(x => x.Type.TypeKind == TypeKind.Keyword) != null)
            {
                found = true;
                WriteLine("using DD4T.ContentModel;");
            }

            if (model.Fields.FirstOrDefault(x => x.Type.TypeKind == TypeKind.Date) != null ||
                model.MetadataFields.FirstOrDefault(x => x.Type.TypeKind == TypeKind.Date) != null)
            {
                found = true;
                WriteLine("using System;");
            }

            if (model.Fields.FirstOrDefault(x => x.IsMultivalue) != null ||
                model.MetadataFields.FirstOrDefault(x => x.IsMultivalue) != null)
            {
                found = true;
                WriteLine("using System.Collections.Generic;");
            }

            if (found)
            {
                WriteLine();
            }
        }
    }
}
