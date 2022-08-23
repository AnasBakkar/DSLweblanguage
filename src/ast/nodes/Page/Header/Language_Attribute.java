package ast.nodes.Page.Header;

public class Language_Attribute extends Attribute_Header {

    public Language_Attribute() {
        super.name = "language" ;
    }

    @Override
    public String codeGenerate() {
        return "<meta charset=\"" + super.value.codeGenerate() + "\">" ;
    }
}
