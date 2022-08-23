package ast.nodes.Page.Header;

public class Author_Attribute extends Attribute_Header {

    public Author_Attribute() {
        super.name = "author";
    }

    @Override
    public String codeGenerate() {
        return "<meta " + "name=\"" + super.name +
                "\" content=\"" + super.value.codeGenerate() + "\">" ;
    }
}
