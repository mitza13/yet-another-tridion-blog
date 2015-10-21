using Mitza.MoveItem.Common;
using System;
using Tridion.ContentManager.CoreService.Client;

namespace Mitza.MoveItem
{
    public class Program
    {
        public static void Main(string[] args)
        {
            if (args.Length < 3)
            {
                PrintUsage();
            }
            else
            {
                using (CoreServiceProvider coreService = new CoreServiceProvider())
                {
                    ICoreService client = coreService.Client;

                    string componentId = args[1];
                    string destinationRepositoryId = args[2];
                    OperationInstruction instruction = new OperationInstruction { Mode = OperationMode.FailOnError };
                    ReadOptions readOptions = coreService.ReadOptions;

                    RepositoryLocalObjectData originalData = (RepositoryLocalObjectData)client.Read(componentId, readOptions);
                    Console.WriteLine("Original item:\t{0} | Publication: \"{1}\"",
                        originalData.Id, originalData.BluePrintInfo.OwningRepository.Title);

                    try
                    {
                        OperationResultDataOfRepositoryLocalObjectData result = null;
                        switch (args[0])
                        {
                            case "promote":
                                result = client.Promote(componentId, destinationRepositoryId, instruction, readOptions);
                                break;

                            case "demote":
                                result = client.Demote(componentId, destinationRepositoryId, instruction, readOptions);
                                break;

                            default:
                                PrintUsage();
                                break;
                        }

                        if (result != null)
                        {
                            if (result.ValidationWarnings.Length > 0)
                            {
                                Console.WriteLine("Validation warnings:");
                                foreach (ValidationWarningData warning in result.ValidationWarnings)
                                {
                                    Console.WriteLine("\tMessage:{0} | Source:{1} | Location:{2}",
                                        warning.Message, warning.Source, warning.Location);
                                }
                            }
                            else
                            {
                                RepositoryLocalObjectData objectData = result.Result;
                                Console.WriteLine("Moved item:\t{0} | Publication: \"{1}\"",
                                    objectData.Id, objectData.BluePrintInfo.OwningRepository.Title);
                            }
                        }
                    }
                    catch (Exception e)
                    {
                        Console.Error.WriteLine("Fail: " + e);
                    }
                }
            }

            Console.Write("Press any key...");
            Console.ReadKey();
        }

        private static void PrintUsage()
        {
            Console.WriteLine("Usage parameters: promote|demote itemTcmuri destinationPublicationTcmUri");
        }
    }
}
