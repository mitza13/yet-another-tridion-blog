using Mitza.ModelGenerator.Common;
using Mitza.ModelGenerator.Model;
using System.Collections.Generic;
using System.Linq;

namespace Mitza.ModelGenerator.Generators
{
    public class Generator
    {
        public void GenerateCode()
        {
            new ModelBaseGenerator();
            new BuilderBaseGenerator();
            new IFieldsSetExtensionMethodsGenerator();
            new MultimediaBaseGenerator();

            Repository repository = Repository.Instance;
            ICollection<ModelBase> models = repository.Models;

            foreach (ModelBase model in models)
            {
                if (model is ComponentModel)
                {
                    new ComponentGenerator((ComponentModel)model);
                }
                else if (model is MultimediaModel)
                {
                    new MultimediaGenerator((MultimediaModel)model);
                }
                else if (model is EmbeddedModel)
                {
                    new EmbeddedGenerator((EmbeddedModel)model);
                }
            }

            IEnumerable<Field> heterogenousFields = models.SelectMany(x => x.Fields).Where(x => x.IsHeterogenous);
            heterogenousFields.Union(models.SelectMany(x => x.MetadataFields).Where(x => x.IsHeterogenous));
            new HeterogenousBuilderGenerator(heterogenousFields.SelectMany(x => x.Types));
        }
    }
}
