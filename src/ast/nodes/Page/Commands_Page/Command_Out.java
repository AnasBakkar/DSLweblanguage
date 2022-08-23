package ast.nodes.Page.Commands_Page;



import ast.nodes.Page.Attributes.Attribute_Command;
import ast.nodes.Page.Attributes.Source_Attribute;
import ast.nodes.Page.Attributes.Value_Attribute;
import ast.nodes.Page.Main_Class.Commands;

public class Command_Out extends Commands {

    @Override
    public String toHtml() {
        String Attributes = "" ;
        for (Attribute_Command Attr: this.all_Attribute) {
            if(!Attributes.equals(""))
                Attributes = Attributes.concat(",");
            Attributes = Attributes.concat(Attr.toHtml());
        }
        return "out : " + this.name + "(" + Attributes + ")" ;
    }

    @Override
    public String codeGenerate() {
        String TypeOut = "" ;
        String Attributes = "" ;
        boolean IsDoubleTag = false ;
        String DataTag = "" ;
        switch (super.name) {
            case "Paragraph" :
                TypeOut = "p" ;
                IsDoubleTag = true ;
                break;
            case "Image" :
                TypeOut = "img" ;
                break;
            case "Header" :
                TypeOut = "h1" ;
                IsDoubleTag = true ;
                break;
        }
        for (Attribute_Command Attr: this.all_Attribute) {
            if(Attr instanceof Value_Attribute) {
                DataTag  = Attr.getValue().codeGenerate() ;
                continue;
            }
            if(!Attributes.equals(""))
                Attributes = Attributes.concat(" ");
            if (Attr instanceof Source_Attribute) {
                Attributes = Attributes.concat("src=\"" + Attr.getValue().codeGenerate() + "\"");
                continue;
            }
            Attributes = Attributes.concat(Attr.codeGenerate());
        }
        if(Attributes.length() > 0)
            TypeOut+=" " ;
        if(IsDoubleTag)
            return "<br><" + TypeOut + Attributes + "><br>"
                    + DataTag + "<br><" + TypeOut + "><br>";
        return "<br><" + TypeOut + Attributes + "><br>";
    }
}
