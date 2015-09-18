using Mitza.ModelGenerator.Common;
using Mitza.ModelGenerator.Model;
using System;
using System.Configuration;
using System.IO;

namespace Mitza.ModelGenerator.Generators
{
    public class GeneratorBase
    {
        protected ModelBase Model { get; private set; }

        private string _filePath;
        protected string FilePath
        {
            get
            {
                if (_filePath == null)
                {
                    string folder = ConfigurationManager.AppSettings[Constants.FOLDER];
                    _filePath = string.Format(@"{0}\{1}.cs", folder, ClassName);
                }
                return _filePath;
            }
        }

        private string _className;
        protected string ClassName
        {
            get
            {
                if (_className == null)
                {
                    if (Model is ComponentModel)
                    {
                        _className = Util.MakeClassName(Model.Name);
                    }
                    else if (Model is EmbeddedModel)
                    {
                        _className = Util.MakeEmbeddedClassName(Model.Name);
                    }
                    else if (Model is MultimediaModel)
                    {
                        _className = Util.MakeMultimediaClassName(Model.Name);
                    }
                    else
                    {
                        throw new NotSupportedException("Invalid model type " + Model.GetType());
                    }
                }
                return _className;
            }
        }

        public string MetadataClassName
        {
            get
            {
                return ClassName + "Metadata";
            }
        }

        private string _namespace;
        public string Namespace
        {
            get
            {
                if (_namespace == null)
                {
                    _namespace = ConfigurationManager.AppSettings[Constants.NAMESPACE];
                }
                return _namespace;
            }
        }

        public GeneratorBase(ModelBase model)
        {
            Model = model;
        }

        protected void CreateModelClass()
        {
            File.WriteAllText(FilePath, string.Empty);
        }

        protected void Write(string message, params object[] parameters)
        {
            File.AppendAllText(FilePath, string.Format(message, parameters));
        }

        protected void WriteLine(string message = null, params object[] parameters)
        {
            Write(message + "\r\n", parameters);
        }
    }
}
