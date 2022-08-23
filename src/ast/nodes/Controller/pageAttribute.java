package ast.nodes.Controller;

import ast.nodes.Main.Node;

public class pageAttribute extends Node {
    private String attributeType;
    private String attributeValue;

    public String getAttributeType() {
        return attributeType;
    }

    public void setAttributeType(String attributeType) {
        this.attributeType = attributeType;
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }

    @Override
    public String toString() {
        return "pageAttribute{" +
                "attributeType='" + attributeType + '\'' +
                ", attributeValue='" + attributeValue + '\'' +
                '}';
    }
}
