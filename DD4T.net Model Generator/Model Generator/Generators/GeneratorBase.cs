using Mitza.ModelGenerator.Common;
using Mitza.ModelGenerator.Model;
using System;
using System.Configuration;
using System.IO;
using System.Text;

namespace Mitza.ModelGenerator.Generators
{
    public enum GeneratorMode { Model, Builder };

    public class GeneratorBase
    {
        protected ModelBase Model { get; private set; }
        protected GeneratorMode GeneratorMode { get; set; }
        protected UsingsGenerator UsingsGenerator { get; set; }
        protected ConstructorGenerator ConstructorGenerator { get; set; }

        private string _modelObjectName;
        public object ModelObjectName
        {
            get
            {
                if (_modelObjectName == null)
                {
                    _modelObjectName = ClassNameModel.Substring(0, 1).ToLower() + ClassNameModel.Substring(1);
                }
                return _modelObjectName;
            }
        }

        string folder = ConfigurationManager.AppSettings[Constants.FOLDER];
        protected string FilePath
        {
            get
            {
                if (GeneratorMode == GeneratorMode.Builder)
                {
                    return string.Format(@"{0}\Builder\{1}.cs", folder, ClassName);
                }
                else
                {
                    return string.Format(@"{0}\DomainModel\{1}.cs", folder, ClassName);
                }
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

                if (GeneratorMode == GeneratorMode.Builder)
                {
                    return _className + "Builder";
                }

                return _className;
            }
            set { _className = value; }
        }

        public string ClassNameModel { get { return _className; } }

        public string MetadataClassName
        {
            get
            {
                return _className + "Metadata";
            }
        }

        private string _namespace = ConfigurationManager.AppSettings[Constants.NAMESPACE];
        public string Namespace
        {
            get
            {
                if (GeneratorMode == GeneratorMode.Builder)
                {
                    return _namespace + ".Builder";
                }
                else
                {
                    return NamespaceModel;
                }
            }
        }

        public string NamespaceModel { get { return _namespace + ".DomainModel"; } }

        public GeneratorBase(ModelBase model)
        {
            Model = model;
        }

        protected void CreateClass()
        {
            Directory.CreateDirectory(Path.GetDirectoryName(FilePath));
            File.WriteAllText(FilePath, string.Empty);
        }

        protected string GetPropertyName(Field field)
        {
            string name = Util.MakePropertyName(field.Name);
            switch (name)
            {
                case "Id":
                case "Title":
                case "Schema":
                    name += "Field";
                    break;
            }

            return name;
        }

        protected string GetFieldInitializer(Field field, string baseName)
        {
            StringBuilder result = new StringBuilder();

            if (field.IsHeterogenous)
            {
                result.AppendFormat("HeterogenousBuilder.Instance.Build({0}.LinkedComponentValue{1}(\"{2}\"))",
                    baseName,
                    field.IsMultivalue ? "s" : "",
                    field.Name);
            }
            else
            {
                Mitza.ModelGenerator.Model.Type fieldType = field.Type;
                switch (fieldType.TypeKind)
                {
                    case TypeKind.ComponentLink:
                        result.AppendFormat("{0}.Instance.Build({1}.LinkedComponentValue{2}(\"{3}\"))",
                            Util.MakeBuilderClassName(fieldType.Name),
                            baseName,
                            field.IsMultivalue ? "s" : "",
                            field.Name);
                        break;

                    case TypeKind.Date:
                        result.AppendFormat("{0}.DateTimeValue{1}(\"{2}\")", baseName, field.IsMultivalue ? "s" : "", field.Name);
                        break;

                    case TypeKind.Embedded:
                        result.AppendFormat("{0}.Instance.Build({1}.EmbeddedValue{2}(\"{3}\"))",
                            Util.MakeEmbeddedBuilderClassName(fieldType.Name),
                            baseName,
                            field.IsMultivalue ? "s" : "",
                            field.Name);
                        break;

                    case TypeKind.Keyword:
                        result.AppendFormat("{0}.KeywordValue{1}(\"{2}\")", baseName, field.IsMultivalue ? "s" : "", field.Name);
                        break;

                    case TypeKind.MultimediaLink:
                        result.AppendFormat("{0}.Instance.Build({1}.LinkedComponentValue{2}(\"{3}\"))",
                            Util.MakeMultimediaBuilderClassName(fieldType.Name),
                            baseName,
                            field.IsMultivalue ? "s" : "",
                            field.Name);
                        break;

                    case TypeKind.Numeric:
                        result.AppendFormat("{0}.NumericValue{1}(\"{2}\")", baseName, field.IsMultivalue ? "s" : "", field.Name);
                        break;

                    case TypeKind.RichText:
                        result.AppendFormat("{0}.ResolveRichText{1}(\"{2}\")", baseName, field.IsMultivalue ? "s" : "", field.Name);
                        break;

                    case TypeKind.Text:
                    default:
                        result.AppendFormat("{0}.StringValue{1}(\"{2}\")", baseName, field.IsMultivalue ? "s" : "", field.Name);
                        break;
                }
            }

            return result.ToString();
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
