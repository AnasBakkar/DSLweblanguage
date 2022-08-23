package ast.nodes.Page.AttributeValue;

public class String_Value extends Literal_Value<String> {

    @Override
    public String toHtml() {
        return "'" + value + "'";
    }

    @Override
    public String codeGenerate() {
        return value ;
    }
}
