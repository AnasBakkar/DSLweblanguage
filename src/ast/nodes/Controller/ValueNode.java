package ast.nodes.Controller;

import ast.nodes.Main.Node;
import javafx.geometry.Pos;

public class ValueNode<T> extends Node {
    public T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "value=" + value ;
    }

    @Override
    public String codeGenerate() {
        String result = value.toString();
        String fResult = "";
        char firstChar = result.charAt(0);
        if(value instanceof Session){
            System.out.println("value node classssssssssssssss");
            fResult += ((Session) value).codeGenerate();
            return fResult;
        }
        if(value instanceof Post){
            fResult += ((Post) value).codeGenerate();
            return fResult;
        }
        else if(!result.startsWith("\"") && !result.startsWith("-") && !result.contains("true") && !result.contains("false") && !Character.isDigit(firstChar))
            fResult += "$" + result;
        else
            fResult += result;
        return fResult;
    }
}
