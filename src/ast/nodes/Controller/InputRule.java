package ast.nodes.Controller;

import ast.nodes.Main.Node;

import java.util.List;

public class InputRule extends Node {
    private String inputType;
    private List<pageAttribute> attributes;

    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    public List<pageAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<pageAttribute> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "InputRule{" +
                "inputType='" + inputType + '\'' +
                ", attributes=" + attributes +
                '}';
    }
}
