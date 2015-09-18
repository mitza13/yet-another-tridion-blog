using Mitza.ModelGenerator.Common;
using Mitza.ModelGenerator.Model;
using System.Collections.Generic;
using System.Linq;
using System.Xml.Linq;

namespace Mitza.ModelGenerator.Builders
{
    public class TypesBuilder
    {
        public ISet<Type> Types { get; private set; }

        public TypesBuilder(XElement element)
        {
            Types = new HashSet<Type>();
            XAttribute typeAttribute = element.Attribute("type");
            if (typeAttribute == null)
            {
                Types.Add(new Type { TypeKind = TypeKind.Text });
                return;
            }

            IEnumerable<XElement> targets = element.Descendants(Constants.TCM_NAMESPACE + "TargetSchema");
            if (targets.Count() > 0)
            {
                TypeKind typeKind = Util.Parse(element.Descendants(Constants.TCM_NAMESPACE + "linktype").First().Value);
                foreach (XElement target in targets)
                {
                    Types.Add(new Type { Name = target.Attribute(Constants.XLINK_NAMESPACE + "title").Value, TypeKind = typeKind });
                }
                return;
            }

            XElement embedded = element.Descendants(Constants.TCM_NAMESPACE + "EmbeddedSchema").FirstOrDefault();
            if (embedded != null)
            {
                Types.Add(new Type { Name = embedded.Attribute(Constants.XLINK_NAMESPACE + "title").Value, TypeKind = TypeKind.Embedded });
                return;
            }

            Types.Add(new Type { TypeKind = Util.Parse(typeAttribute.Value) });
        }
    }
}
