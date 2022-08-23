package ast.nodes.Page.Main_Class;

import ast.nodes.Main.Node;

public abstract class AttributeNode<T> extends Node {

    protected String name;
    protected T value;

    public AttributeNode() { }

    public String getName() {
        return name;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

}
