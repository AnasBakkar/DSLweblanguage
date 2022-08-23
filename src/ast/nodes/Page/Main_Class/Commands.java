package ast.nodes.Page.Main_Class;

// Expresses every command on the page

import ast.nodes.Main.Node;
import ast.nodes.Page.Attributes.Attribute_Command;

import java.util.ArrayList;

public class Commands extends Node {

    protected String name ;
    protected ArrayList<Attribute_Command> all_Attribute ;

    public String getName() {
        return name;
    }

    public Commands() {
        all_Attribute = new ArrayList<>();
    }

    public ArrayList<Attribute_Command> getAll_Attribute() {
        return all_Attribute;
    }

}
