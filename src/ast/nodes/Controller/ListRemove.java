package ast.nodes.Controller;

public class ListRemove extends OperationType{
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ListRemove{" +
                "value=" + value +
                '}'+'\n';
    }

    @Override
    public String codeGenerate() {
        return String.valueOf(value);
    }
}
