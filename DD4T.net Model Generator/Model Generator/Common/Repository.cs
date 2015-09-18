using Mitza.ModelGenerator.Model;
using System.Collections.Generic;

namespace Mitza.ModelGenerator.Common
{
    public class Repository
    {
        private static readonly IDictionary<string, ModelBase> cache = new Dictionary<string, ModelBase>();

        private static readonly Repository _instance = new Repository();
        public static Repository Instance { get { return _instance; } }

        private Repository() { }

        public ModelBase this[string tcmUri]
        {
            get
            {
                return cache[tcmUri];
            }
            set
            {
                cache[tcmUri] = value;
            }
        }

        public ICollection<ModelBase> Models { get { return cache.Values; } }

        public int Count { get { return cache.Count; } }
    }
}
