package ast.nodes.Page.Attributes;


import ast.nodes.Page.AttributeValue.Valuable;
import ast.nodes.Page.Main_Class.AttributeNode;

public abstract class Attribute_Command extends AttributeNode<Valuable> {

    @Override
    public String toHtml() {
        return this.name + "(" + this.value.toHtml() + ")" ;
    }

    @Override
    public String codeGenerate() {
        return this.name + "=" + "\"" + this.value.codeGenerate() + "\"" ;
    }
}
