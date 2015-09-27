using Mitza.ModelGenerator.Model;

namespace Mitza.ModelGenerator.Generators
{
    public class ConstructorGenerator : GeneratorBase
    {
        public ConstructorGenerator(ModelBase model) : base(model) { }

        public void GenerateModelConstructor()
        {
            GeneratorMode = GeneratorMode.Model;

            WriteLine("        public {0}(IComponent component) : base(component) {{ }}", ClassName);
        }

        public void GenerateBuilderConstructor()
        {
            GeneratorMode = GeneratorMode.Builder;

            WriteLine("        private {0}() {{ }}", ClassName);
            WriteLine();
        }
    }
}
