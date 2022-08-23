package ast.nodes.Controller.valueTypes;

import ast.nodes.Controller.ValueNode;

public class NumericValue extends ValueNode<Double> {
    @Override
    public String toString() {
        return "NumericValue{" +
                "value=" + value +
                '}';
    }
}
