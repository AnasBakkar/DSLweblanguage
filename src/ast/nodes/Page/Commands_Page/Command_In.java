package ast.nodes.Page.Commands_Page;


import ast.nodes.Page.Attributes.Attribute_Command;
import ast.nodes.Page.Attributes.Title_Attribute;
import ast.nodes.Page.Attributes.Value_Attribute;
import ast.nodes.Page.Main_Class.Commands;

import java.util.ArrayList;

public class Command_In extends Commands {

    protected String action ;

    protected ArrayList<Commands> XXX ;

    public ArrayList<Commands> getXXX() {
        return XXX;
    }

    public void setXXX(ArrayList<Commands> XXX) {
        this.XXX = XXX;
    }
    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toHtml() {
        String Attributes = "" ;
        for (Attribute_Command Attr: this.all_Attribute) {
            if(!Attributes.equals(""))
                Attributes = Attributes.concat(",");
            Attributes = Attributes.concat(Attr.toHtml());
        }
        return "in : " + this.name + "(" + Attributes + ")" ;
    }

    private String Input(String Type_in,String title ,String value,String Lable){
        return Lable + "<input"   + " type=\"" +Type_in+"\" "
                 + title + value +">\n<br>";
    }
    /*@Override
    public String codeGenerate() {
        String Type_in = super.name;
        String value = "";
        String title = "";
        String Temp_action = "";
        if (!this.action.equals("")){
            Temp_action = " action=\""+this.action+"\""+" method=\"post\"";
        }
        for (Attribute_Command Attr: this.all_Attribute) {
            if (Attr instanceof Title_Attribute){
                if(!Attr.getValue().codeGenerate().equals("")){
                    title = "name=\"" + Attr.getValue().codeGenerate() + "\" " ;
                }
            }
            if(Attr instanceof Value_Attribute) {
                value ="value=\"" + Attr.getValue().codeGenerate() + "\"" ;
            }
        }
        return "<form"+Temp_action+">\n"+
                this.Input(Type_in,title,value)+
                this.Input("submit",""," value=\"Submit\"")
                +"</form>";
    }*/
    @Override
    public String codeGenerate() {
        String Test1 = "";
        String Type_in = "";
        String value = "";
        String title = "";
        String Lable ="";
        String Temp_action = "";
        if (!this.action.equals("")){
            Temp_action = " action=\"http://localhost/"+this.action+".php\""+" method=\"post\"";
        }
        for (Commands item: this.getXXX()) {
            Type_in = item.getName();
            //System.out.println(Type_in);
            title = "";
            value = "";
            for (Attribute_Command Attr: item.getAll_Attribute()) {
                if (Attr instanceof Title_Attribute){
                    if(!Attr.getValue().codeGenerate().equals("")){
                        title= "name=\"" + Attr.getValue().codeGenerate() + "\" ";
                        //System.out.println(title);
                        Lable =Attr.getValue().codeGenerate() +": <br>";
                    }
                }
                if(Attr instanceof Value_Attribute) {
                    value = "value=\"" + Attr.getValue().codeGenerate() + "\"" ;
                    //System.out.println(value);
                }
            }
            Test1 += this.Input(Type_in,title,value,Lable);
            //System.out.println("moner");
        }
        return "<form"+Temp_action+">\n"+
                Test1+
                this.Input("submit",""," value=\"Submit\"","")
                +"</form>";
    }

}
