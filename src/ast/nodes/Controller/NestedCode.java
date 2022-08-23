package ast.nodes.Controller;

import java.util.List;

public class NestedCode extends ControllerBody{
    private List<ControllerBody> nestedStatements;

    public List<ControllerBody> getNestedStatements() {
        return nestedStatements;
    }

    public void setNestedStatements(List<ControllerBody> nestedStatments) {
        this.nestedStatements = nestedStatments;
    }

    @Override
    public String toString() {
        return "NestedCode{" + '\n'+ '\t' +
                "nestedStatements=" + nestedStatements +
                '}'+'\n';
    }

    @Override
    public String codeGenerate() {
        String result = "";
        for (ControllerBody co:nestedStatements) {
            result += co.codeGenerate();
        }
        return result;
    }
}
