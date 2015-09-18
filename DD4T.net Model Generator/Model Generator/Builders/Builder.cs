using Mitza.ModelGenerator.Common;
using Mitza.ModelGenerator.Generators;
using Mitza.ModelGenerator.Model;
using System;
using Tridion.ContentManager.CoreService.Client;

namespace Mitza.ModelGenerator.Builders
{
    public class Builder
    {
        public void BuildModels()
        {
            using (CoreServiceProvider provider = new CoreServiceProvider())
            {
                string[] tcmUris = provider.GetSchemaIds();
                Repository repository = Repository.Instance;

                ModelBase model = null;
                foreach (string tcmUri in tcmUris)
                {
                    SchemaData schema = provider.GetSchema(tcmUri);
                    Console.WriteLine("Generating {0} model {1}", schema.Purpose, schema.Title);

                    switch (schema.Purpose)
                    {
                        case SchemaPurpose.Component:
                            model = new ComponentModel(tcmUri);
                            repository[model.Id] = model;
                            break;

                        case SchemaPurpose.Embedded:
                            model = new EmbeddedModel(tcmUri);
                            repository[model.Id] = model;
                            break;

                        case SchemaPurpose.Multimedia:
                            model = new MultimediaModel(tcmUri);
                            repository[model.Id] = model;
                            break;
                    }

                    new ModelBuilder(schema, model);

                    switch (schema.Purpose)
                    {
                        case SchemaPurpose.Component:
                            new ComponentGenerator((ComponentModel)model);
                            break;

                        case SchemaPurpose.Embedded:
                            new EmbeddedGenerator((EmbeddedModel)model);
                            break;

                        case SchemaPurpose.Multimedia:
                            new MultimediaGenerator((MultimediaModel)model);
                            break;
                    }
                }
            }
        }
    }
}
