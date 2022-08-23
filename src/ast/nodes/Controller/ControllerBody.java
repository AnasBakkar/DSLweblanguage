package ast.nodes.Controller;

import ast.nodes.Main.Node;

public class ControllerBody extends Node {
    private NestedCode nestedBlock;

    public NestedCode getNestedBlocks() {
        return nestedBlock;
    }

    public void setNestedBlock(NestedCode nestedBlocks) {
        this.nestedBlock = nestedBlocks;
    }

    public NestedCode getNestedBlock() {
        return nestedBlock;
    }

    @Override
    public String toString() {
        return "ControllerBody{" +
                "nestedBlock=" + nestedBlock +
                '}';
    }

    @Override
    public String codeGenerate() {
        if(nestedBlock != null)
        return nestedBlock.codeGenerate();
        return "";
    }
}
