package ast.nodes.Controller;

import com.Main;
import symbol_table.Scope;

import java.util.ArrayList;

public class FunctionCall extends ControllerBody {
    private String functionName;
    private ArrayList<ValueNode> functionParams;

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public ArrayList<ValueNode> getFunctionParams() {
        return functionParams;
    }

    public void setFunctionParams(ArrayList<ValueNode> functionParams) {
        this.functionParams = functionParams;
    }

    @Override
    public String toString() {
        return "FunctionCall{" +
                "functionName='" + functionName + '\'' +
                ", functionParams=" + functionParams +
                '}' + '\n';
    }

    @Override
    public String codeGenerate() {
        String result = functionName + "(";
        int i = 0;
        for (ValueNode value : functionParams) {
            result += value.codeGenerate();
            if (i != functionParams.size() - 1)
                result += ",";
            i++;
        }
        result += ");\n";
        return result;
    }

    @Override
    public void errorHandle(Scope targetScope) {
        System.out.println(Main.symbolTable.getParamsNumber());
        System.out.println(functionName);
        if (Main.symbolTable.getParamsNumber().containsKey(functionName)) {
            System.out.println("size "+functionParams.size());
            if (Main.symbolTable.getParamsNumber().get(functionName) != functionParams.size()) {
                System.out.println("error in line " + this.getLine() + ", the number of parameters in function " + this.functionName + " is not correct");
            }
        }
    }
}
