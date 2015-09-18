using Mitza.ModelGenerator.Common;
using Mitza.ModelGenerator.Model;

namespace Mitza.ModelGenerator.Generators
{
    public class Generator
    {
        public void GenerateCode()
        {
            Repository repository = Repository.Instance;
            foreach (ModelBase model in repository.Models)
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
        }
    }
}
