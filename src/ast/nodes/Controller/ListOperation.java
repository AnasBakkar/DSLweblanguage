package ast.nodes.Controller;

public class ListOperation extends ControllerBody{
    private String listName;
    private OperationType operation;

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public OperationType getOperation() {
        return operation;
    }

    public void setOperation(OperationType operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "ListOperation{" +
                "listName='" + listName + '\'' +
                ", operation=" + operation +
                '}';
    }

    @Override
    public String codeGenerate() {
        String result = "";
        if(operation instanceof ListAdd){
            result += "array_push($" + listName + ",";
            result += operation.codeGenerate();
            result += ");\n";
        }
        else if(operation instanceof ListRemove){
            result += "unset($" + listName + "[";
            result += operation.codeGenerate() + "]);\n";
            //$jk = array_values($jk);
        }
        else if(operation instanceof ListGet){
            result += "$" + listName + "["+operation.codeGenerate()+"];\n";
            //$jk = array_values($jk);
        }
        else if(operation instanceof ListLength){
            result += "count($" + listName + ");\n";
            //$jk = array_values($jk);
        }
        return result;

    }
}
