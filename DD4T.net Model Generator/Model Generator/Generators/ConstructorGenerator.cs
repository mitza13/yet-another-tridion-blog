using Mitza.ModelGenerator.Model;

namespace Mitza.ModelGenerator.Generators
{
    public class ConstructorGenerator : GeneratorBase
    {
        public ConstructorGenerator(ModelBase model)
            : base(model)
        {
            WriteLine("        public {0}(IComponent component) : base(component) {{ }}", ClassName);
        }
    }
}
