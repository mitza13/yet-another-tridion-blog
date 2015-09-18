namespace Mitza.ModelGenerator.Model
{
    public enum TypeKind { ComponentLink, Date, Embedded, Keyword, MultimediaLink, Numeric, Text };

    public class Type
    {
        public string Name { get; set; }
        public TypeKind TypeKind { get; set; }
    }
}
