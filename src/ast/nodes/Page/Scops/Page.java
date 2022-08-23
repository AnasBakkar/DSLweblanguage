package ast.nodes.Page.Scops;

import ast.nodes.Main.Node;
import ast.nodes.Page.Commands_Page.Command_In;
import ast.nodes.Page.Header.Header;
import ast.nodes.Page.Main_Class.Commands;
import com.Main;

import java.util.ArrayList;
import java.util.Arrays;

public class Page extends Node {

    String name ;
    ArrayList<Commands> Rules ;
    Header Head ;
    private final ExtendsHTML Extends ;

    public Page() {
        this.Rules = new ArrayList<>();
        this.Extends = new ExtendsHTML();
        this.Head = new Header();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Commands> getRules() {
        return Rules;
    }

    public ArrayList<Page> getExtendsBlock() {
        return this.Extends.HTML_Blocks;
    }

    public void setExtends_Name(String blocks_Name) {
        if (!this.Extends.Blocks_Name.equals(""))
            this.Extends.Blocks_Name = this.Extends.Blocks_Name + ",";
        Extends.Blocks_Name = Extends.Blocks_Name.concat(blocks_Name);
    }

    public ArrayList<String> GetAllExtendsName() {
        if(this.Extends.Blocks_Name.equals(""))
            return new ArrayList<>();
        return new ArrayList<>(Arrays.asList(this.Extends.Blocks_Name.split(",")));
    }

    public Header getHead() {
        return Head;
    }

    public static boolean CheckExtends(ArrayList<Page> HTML_Blocks) {
        // True : no Error With Extends
        // False : rror With Extends
        for (Page Block: HTML_Blocks) {
            ArrayList<String> Temp = Block.GetAllExtendsName(); //All Name Extends
            if(Temp.size() == 0)
                continue;
            if(Temp.contains(Block.getName()))
                return false;
            ArrayList<Page> Temp_2 = new ArrayList<>(); // All Page insert to this page
            for (Page Anthor_Block : HTML_Blocks) {
                if(Temp.remove(Anthor_Block.getName())) {
                    for (Page Temp_3 : Temp_2)
                        if(Temp_3.getName().equals(Anthor_Block.getName())) {
                            return false;
                        }
                    Temp_2.add(Anthor_Block);
                }
            }
            if(Temp.size() >= 1)
                return false;

            Block.getExtendsBlock().addAll(Temp_2);
        }
        return true;
    }

    public static boolean CheckExtendsMulti(ArrayList<Page> HTML_Blocks) {
        for (Page Block_1: HTML_Blocks) {
            for (Page Block_2 : Block_1.getExtendsBlock()) {
                if(Block_2.getExtendsBlock().contains(Block_1))
                {
                    return false ;
                }
            }
        }
        return true ;
    }

    @Override
    public String toHtml() {
        String Temp = "" ;
        for (Commands Comm: this.Rules) {
            Temp = Temp.concat("\n");
            Temp = Temp.concat(Comm.toHtml());
        }
        return "page " + this.name + ((this.Extends.Blocks_Name.equals(""))? "" : " extends " + this.Extends.Blocks_Name)
                + " " + this.Head.toHtml() + " { " + Temp + " \n}" ;
    }

    @Override
    public String codeGenerate() {
        String controllerForThisPage = "";
        if(Main.symbolTable.getPageAndItsController().containsKey(this.name)){
            controllerForThisPage = Main.symbolTable.getPageAndItsController().get(this.name);
        }
        String HeadElement = "" ;
        String BodyElement = "" ;
        HeadElement = this.Head.codeGenerate() ;
        for (Commands Comm: this.Rules) {
            BodyElement = BodyElement.concat("\n");
            BodyElement = BodyElement.concat(Comm.codeGenerate());
        }
        return "<html>" + "\n"
                +"<head>" + "\n"
                + HeadElement + "\n"
                +"</head>" + "\n"
                +"<body>"
                //+"<?php include 'C:\\xampp\\htdocs\\" + controllerForThisPage+".php'; ?>"
                + BodyElement + "\n"
                +"</body>" + "\n"
                +"</html>" + "\n" ;
    }
}

class ExtendsHTML {

    public String Blocks_Name; //Between All Name put comma(,)
    public ArrayList<Page> HTML_Blocks;

    public ExtendsHTML() {
        Blocks_Name = "";
        HTML_Blocks = new ArrayList<>();
    }
}

