using System.Collections.Generic;
using System.Linq;

namespace Mitza.ModelGenerator.Model
{
    public class Field
    {
        public string Name { get; set; }
        public Type Type { get { return Types.FirstOrDefault(); } }

        private ISet<Type> _types = new HashSet<Type>();
        public ISet<Type> Types { get { return _types; } }

        public bool IsMultivalue { get; set; }
        public bool IsHeterogenous { get { return Types.Count > 1; } }
    }
}
