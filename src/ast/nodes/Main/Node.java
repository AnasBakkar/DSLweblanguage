package ast.nodes.Main;

import ast.nodes.Page.Main_Class.Htmlable;
import symbol_table.Scope;

public class Node implements Htmlable {
    private int line;
    private int col;

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    //a recursive function to a scope and all its parents if the variable was defined earlier and its type
    public int checkVariable(String name, Scope targetScope, Scope parent, String type) {
        System.out.println("scope ID " + targetScope.getID());
        System.out.println(targetScope.getScopeVariables());

        if (targetScope == null) {
            System.out.println("current" + targetScope.toString());
            System.out.println("0");
            return 0;
        }

        if (targetScope.getScopeVariables().containsKey(name)) {
            if(targetScope.getScopeVariables().get(name).equals(type)) {
                System.out.println("1");
                return 1;
            }
        }

        if (parent == null) {
            System.out.println("0");
            //System.out.println("parent" + parent.toString());
            return 0;
        }
        if (parent.getScopeVariables().containsKey(name)) {
            if(parent.getScopeVariables().get(name).equals(type)) {
                System.out.println("1");
                return 1;
            }
        }

        return checkVariable(name, parent, parent.getParent(), type);
    }

    public void errorHandle(Scope targetScope) {
        return;
    }

    @Override
    public String toHtml() {
        return "";
    }

    public String codeGenerate() {
        return "";
    }


}
