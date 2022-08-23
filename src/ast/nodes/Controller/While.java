package ast.nodes.Controller;

import java.util.List;

public class While extends ControllerBody{

    List<Condition> conditions;
    List<String> operators;
    private NestedCode nestedCode;

    public List<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    public List<String> getOperators() {
        return operators;
    }

    public void setOperators(List<String> operators) {
        this.operators = operators;
    }

    public NestedCode getNestedCode() {
        return nestedCode;
    }

    public void setNestedCode(NestedCode nestedCode) {
        this.nestedCode = nestedCode;
    }

    @Override
    public String toString() {
        return "While{" +
                "conditions=" + conditions +
                ", operators=" + operators +
                ", nestedCode=" + nestedCode +
                '}';
    }

    @Override
    public String codeGenerate() {
        String result = "while(";
        int i = 0;
        for (Condition c:conditions) {
            result += c.codeGenerate();
            if(i < operators.size()) {
                result += operators.get(i);
                i++;
            }
        }
        result += ")\n{\n"+nestedCode.codeGenerate()+"\n}";
        return result;
    }
}
