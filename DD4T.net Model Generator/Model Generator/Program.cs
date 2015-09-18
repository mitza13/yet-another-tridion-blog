using Mitza.ModelGenerator.Builders;
using Mitza.ModelGenerator.Generators;
using System;

namespace Mitza.ModelGenerator
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Builder builder = new Builder();
            builder.BuildModels();

            Generator generator = new Generator();
            generator.GenerateCode();

            Console.Write("Press any key...");
            Console.ReadKey();
        }
    }
}
