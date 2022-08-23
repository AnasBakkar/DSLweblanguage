package ast.nodes.Controller;

public class Session extends ValueNode{
    /*String variableName;

    public String getVariableName() {
        return variableName;
    }

    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }*/

    @Override
    public String codeGenerate() {
        System.out.println("code generateeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
        return "$_SESSION[\""+value+"\"]";
    }
}
