using System.Collections.Generic;

namespace Mitza.ModelGenerator.Model
{
    public class ModelBase
    {
        private IList<Field> _fields = new List<Field>();
        public IList<Field> Fields { get { return _fields; } }

        private IList<Field> _metadataFields = new List<Field>();
        public IList<Field> MetadataFields { get { return _metadataFields; } }

        public string Id { get; private set; }
        public string Name { get; set; }

        public ModelBase(string tcmUri)
        {
            Id = tcmUri;
        }
    }
}
