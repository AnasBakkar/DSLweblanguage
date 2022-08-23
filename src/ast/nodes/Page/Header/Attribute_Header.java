package ast.nodes.Page.Header;

import ast.nodes.Page.AttributeValue.Literal_Value;
import ast.nodes.Page.Main_Class.AttributeNode;

public abstract class Attribute_Header extends AttributeNode<Literal_Value<String>> {

    @Override
    public String toHtml() {
        return this.name + "(" + this.value.toHtml() + ")" ;
    }

    @Override
    public String codeGenerate() {
        return super.codeGenerate();
    }
}
