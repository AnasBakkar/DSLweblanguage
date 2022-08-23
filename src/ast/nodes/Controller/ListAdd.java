package ast.nodes.Controller;


public class ListAdd extends OperationType {
    private ValueNode value;

    public ValueNode getValue() {
        return value;
    }

    public void setValue(ValueNode value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ListAdd{" +
                value +
                '}'+'\n';
    }

    @Override
    public String codeGenerate() {
        String result = value.codeGenerate();
        return result;
    }
}
