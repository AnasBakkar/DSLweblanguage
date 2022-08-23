package ast.nodes.Controller;

import java.util.List;

public class VariableAssignment extends ControllerBody{

    private String VarName;
    private List<ValueNode> Value;
    private List<String> operators;

    public List<String> getOperators() {
        return operators;
    }

    public void setOperators(List<String> operators) {
        this.operators = operators;
    }

    public String getVarName() {
        return VarName;
    }

    public void setVarName(String varName) {
        VarName = varName;
    }

    public List<ValueNode> getValue() {
        return Value;
    }

    public void setValue(List<ValueNode> value) {
        Value = value;
    }

    @Override
    public String toString() {
        return "VariableAssignment{" + '\n'+ '\t'+
                "VarName='" + VarName + '\'' + '\n'+ '\t'+
                ", Value=" + Value + '\n' +'\t'+
                ", operators=" + operators + '\n'+ '\t'+
                '}'+'\n';
    }

    @Override
    public String codeGenerate() {
        String result = "$" + VarName + "=";
        int i = 0;
        for (ValueNode v:Value) {
            result += v.codeGenerate();
            if(i < operators.size()) {
                result += operators.get(i);
                i++;
            }
        }
        result += ";\n";
        return result;
    }
}
