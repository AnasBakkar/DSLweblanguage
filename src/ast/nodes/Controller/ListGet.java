package ast.nodes.Controller;

public class ListGet extends OperationType{
    private int index;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "ListRemove{" +
                "value=" + index +
                '}'+'\n';
    }

    @Override
    public String codeGenerate() {
        return String.valueOf(index);
    }
}
