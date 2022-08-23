package ast.nodes.Page.AttributeValue;


import ast.nodes.Main.Node;

public abstract class Literal_Value<T> extends Node implements Valuable {

    protected T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
