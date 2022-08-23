package ast.nodes.Controller;

import java.util.ArrayList;

public class FunctionDeclaration extends ControllerBody{
    private String functionName;
    private ArrayList<String> params;
    private NestedCode nestedCode;


    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public ArrayList<String> getParams() {
        return params;
    }

    public void setParams(ArrayList<String> params) {
        this.params = params;
    }

    public NestedCode getNestedCode() {
        return nestedCode;
    }

    public void setNestedCode(NestedCode nestedCode) {
        this.nestedCode = nestedCode;
    }

    @Override
    public String toString() {
        return "FunctionDeclaration{" +
                "functionName='" + functionName + '\'' +
                ", params=" + params +
                ", nestedCode=" + nestedCode +
                '}'+'\n';
    }

    @Override
    public String codeGenerate() {
        String result = "function "+functionName + "(";
        int i = 0;
        for (String param : params) {
            result += "$" + param;
            if(i != params.size() - 1)
                result += ",";
            i++;
        }
        result += ")" + "\n{\n" + nestedCode.codeGenerate() +"\n}";
        return result;
    }

    /*public static class FunctionParam extends Node {
        private String paramName;

        public String getParamName() {
            return paramName;
        }

        public void setParamName(String paramName) {
            this.paramName = paramName;
        }
    }*/
}