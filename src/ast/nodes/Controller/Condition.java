package ast.nodes.Controller;

import symbol_table.Scope;

public class Condition extends ControllerBody{
    ValueNode leftOperand , rightOperand;
    String operator;

    public ValueNode getLeftOperand() {
        return leftOperand;
    }

    public void setLeftOperand(ValueNode leftOperand) {
        this.leftOperand = leftOperand;
    }

    public ValueNode getRightOperand() {
        return rightOperand;
    }

    public void setRightOperand(ValueNode rightOperand) {
        this.rightOperand = rightOperand;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "leftOperand=" + leftOperand +
                ", rightOperand=" + rightOperand +
                ", operator='" + operator + '\'' +
                '}'+'\n';
    }

    @Override
    public void errorHandle(Scope targetScope) {
        if(!(leftOperand instanceof Session)&& !(rightOperand instanceof Session) && !(rightOperand instanceof Post) &&!(leftOperand instanceof Post)) {
            String left = leftOperand.value.toString();
            String right = rightOperand.value.toString();
            System.out.println(leftOperand);
            char firstChar = left.charAt(0);
            char firstCharRight = right.charAt(0);
            if(!left.startsWith("\"") && !left.startsWith("-") && !left.contains("true") && !left.contains("false") && !Character.isDigit(firstChar)) {
                if (checkVariable(leftOperand.value.toString(), targetScope, targetScope.getParent(), "var") != 1) {
                    System.out.println("error in line " + this.getLine() + ", the variable " + leftOperand.value + "  is not defined");
                    //throw new RuntimeException("error in line " + this.getLine() + ", the variable " + leftOperand.value + "  is not defined");
                }
            }
            if(!right.startsWith("\"") && !right.startsWith("-") && !right.contains("true") && !right.contains("false") && !Character.isDigit(firstCharRight)) {
                if (checkVariable(rightOperand.value.toString(), targetScope, targetScope.getParent(), "var") != 1) {
                    System.out.println("error in line " + this.getLine() + ", the variable " + rightOperand.value + "  is not defined");
                    throw new RuntimeException("error in line " + this.getLine() + ", the variable " + rightOperand.value + "  is not defined");
                }
            }
            //Main.fWriter.write("error in line  " + this.getLine() + " ..The List " + name + "  not define\n");
        //else if (checkVariable(name, scope, scope.getParent(), "list") == 2)
            //Main.fWriter.write("error in line  " + this.getLine() + " .." + name + "  not the type list\n");
        }
    }

    @Override
    public String codeGenerate() {
        return "(" + leftOperand.codeGenerate() + operator + rightOperand.codeGenerate() + ")";
    }

    /*@Override
    public String toPhp() {
        return "(" + leftOperand + operator + rightOperand + ")";
    }*/
}
