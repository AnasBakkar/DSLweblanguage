package ast.nodes.Controller;

import ast.nodes.Main.Node;

public class VariableDeclaration extends ControllerBody {
    private VariableAssignment variableAssignment;

    public VariableAssignment getVariableAssignment() {
        return variableAssignment;
    }

    public void setVariableAssignment(VariableAssignment variableAssignment) {
        this.variableAssignment = variableAssignment;
    }

    @Override
    public String codeGenerate() {
        return variableAssignment.codeGenerate();
    }
}
