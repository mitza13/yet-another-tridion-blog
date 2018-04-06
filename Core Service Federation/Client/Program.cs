using System;

namespace Federation.Client
{
    public class Program
    {
        public static void Main(string[] args)
        {
            try
            {
                new Example1();
                new Example2();
                new Example3();
                new Example4();
                new Example5();
            }
            catch (Exception e)
            {
                Console.Error.WriteLine(e);
            }

            Console.Write("\r\nPress any key...");
            Console.ReadKey();
        }
    }
}
