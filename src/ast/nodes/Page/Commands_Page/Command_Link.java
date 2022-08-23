package ast.nodes.Page.Commands_Page;


import ast.nodes.Page.Attributes.Attribute_Command;
import ast.nodes.Page.Attributes.Source_Attribute;
import ast.nodes.Page.Attributes.Value_Attribute;
import ast.nodes.Page.Main_Class.Commands;

public class Command_Link extends Commands {

    @Override
    public String toHtml() {
        String Attributes = "" ;
        for (Attribute_Command Attr: this.all_Attribute) {
            if(!Attributes.equals(""))
                Attributes = Attributes.concat(",");
            Attributes = Attributes.concat(Attr.toHtml());
        }
        return this.name + "(" + Attributes + ")" ;
    }

    @Override
    public String codeGenerate() {
        String Attributes = "" ;
        String DataTag = "" ;
        String Source = "" ;
        for (Attribute_Command Attr: this.all_Attribute) {
            if(Attr instanceof Value_Attribute) {
                DataTag  = Attr.getValue().codeGenerate() ;
                continue;
            }else if(Attr instanceof Source_Attribute) {
                Source = Attr.getValue().codeGenerate();
                continue;
            }
            if(!Attributes.equals(""))
                Attributes = Attributes.concat(",");
            Attributes = Attributes.concat(Attr.codeGenerate());
        }
        if(Source.length() > 0) {
            Source = " href=\"" + Source + "\"";
            if(Attributes.length() > 0)
                Source += " " ;
        }
        return "<br><a" + Source + Attributes + ">"
                + DataTag + "</a><br>";
    }
}
