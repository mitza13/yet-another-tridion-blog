using System.Collections.Generic;
using System.Linq;

namespace Mitza.ModelGenerator.Model
{
    public class Field
    {
        public bool IsHeterogenous { get { return Types.Count > 1; } }
        public bool IsMandatory { get; set; }
        public bool IsMultivalue { get; set; }
        public string Name { get; set; }

        private ISet<Type> _types = new HashSet<Type>();
        public Type Type { get { return Types.FirstOrDefault(); } }
        public ISet<Type> Types { get { return _types; } }
    }
}
