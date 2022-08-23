package ast.nodes.Controller;

import java.util.List;

public class ListNode extends ControllerBody {
    private List<ValueNode> values;
    private String listName;

    public List<ValueNode> getValues() {
        return values;
    }

    public void setValues(List<ValueNode> values) {
        this.values = values;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "values=" + values +
                ", listName='" + listName + '\'' +
                '}' + '\n';
    }

    @Override
    public String codeGenerate() {
        String result = "$" + listName + "=" + "array(";
        int i = 0;
        for (ValueNode value : values) {
            result += value.codeGenerate();
            if(i != values.size() - 1)
                result += ",";
            i++;
        }
        result += ");\n";
        return result;
    }
}
