package ast.nodes.Controller;

public class Post extends ValueNode{

    @Override
    public String codeGenerate() {
        return "$_POST[\""+value+"\"]";
    }
}
