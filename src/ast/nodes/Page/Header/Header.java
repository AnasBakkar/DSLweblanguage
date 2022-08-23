package ast.nodes.Page.Header;

import ast.nodes.Main.Node;
import ast.nodes.Page.Attributes.Value_Attribute;

import java.util.ArrayList;

public class Header extends Node {

    public ArrayList<Attribute_Header> all_Attribute ;

    public Header() {
        this.all_Attribute = new ArrayList<>();
    }

    public ArrayList<Attribute_Header> getAll_Attribute() {
        return all_Attribute;
    }

    @Override
    public String toHtml() {
        String Temp = "";
        for (Attribute_Header S: this.all_Attribute) {
            Temp = Temp.concat(S.toHtml());
            Temp = Temp.concat(";") ;
        }
        return "Header [" + Temp + "]";
    }

    @Override
    public String codeGenerate() {
        String Attributes = "" ;
        for (Attribute_Header Attr: this.all_Attribute) {
            if(!Attributes.equals(""))
                Attributes = Attributes.concat("\n");
            Attributes = Attributes.concat(Attr.codeGenerate());
        }
        return Attributes ;
    }
}
