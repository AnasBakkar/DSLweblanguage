package ast.nodes.Page.Header;

public class PageTitle_Attribute extends Attribute_Header {

    public PageTitle_Attribute() {
        super.name = "pageTitle";
    }

    @Override
    public String codeGenerate() {
        return "<title>" + super.value.codeGenerate() + "</title>" ;
    }
}
