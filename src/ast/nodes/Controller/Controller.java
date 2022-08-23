package ast.nodes.Controller;

import ast.nodes.Main.Node;

import java.util.List;

public class Controller extends Node {
    private String controllerId;
    private String controlledPage;
    private List<ControllerBody> controllerStatments;

    public String getControlledPage() {
        return controlledPage;
    }

    public void setControllerStatments(List<ControllerBody> controllerStatments) {
        this.controllerStatments = controllerStatments;
    }

    public List<ControllerBody> getControllerStatments() {
        return controllerStatments;
    }

    public void setControllerId(String controllerId) {
        this.controllerId = controllerId;
    }

    public String getControllerId() {
        return controllerId;
    }

    public void setControlledPage(String controlledPage) {
        this.controlledPage = controlledPage;
    }

    public String toString(){
        return "Controller name : " + controllerId +'\n' +"Controlled page : "+ controlledPage + '\n' + "  " + controllerStatments;
    }

    @Override
    public String codeGenerate() {
        String result = "<?php\nsession_start();\n";
        for (ControllerBody controller:controllerStatments) {
            result += controller.codeGenerate();
        }
        result+="\n?>";
        return result;
    }
}
