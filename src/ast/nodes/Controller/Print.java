package ast.nodes.Controller;

import java.util.ArrayList;

public class Print extends ControllerBody{
    private ArrayList<ValueNode> valuesToPrint;

    public ArrayList<ValueNode> getValuesToPrint() {
        return valuesToPrint;
    }

    public void setValuesToPrint(ArrayList<ValueNode> valuesToPrint) {
        this.valuesToPrint = valuesToPrint;
    }

    @Override
    public String toString() {
        return "Print{" +
                "valuesToPrint=" + valuesToPrint +
                '}'+'\n';
    }

    @Override
    public String codeGenerate() {
        String result = "echo ";
        int i = 0;
        for (ValueNode value:valuesToPrint) {
            result += value.codeGenerate();
            if(i != valuesToPrint.size() - 1)
                result += ".";
            i++;
        }
        result += ";\n";
        return result;
    }
}
