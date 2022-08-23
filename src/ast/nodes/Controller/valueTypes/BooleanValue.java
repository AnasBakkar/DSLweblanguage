package ast.nodes.Controller.valueTypes;

import ast.nodes.Controller.ValueNode;

public class BooleanValue extends ValueNode<Boolean> {
    @Override
    public String toString() {
        return "BooleanValue{" +
                "value=" + value +
                '}';
    }
}
