package ast.nodes.Main;

import ast.nodes.Controller.Controller;
import ast.nodes.Page.Scops.Page;

import java.util.ArrayList;
import java.util.List;

public class Program_Scops extends Node{

    List<Page> HTML_Blocks ;
    List<Controller> PHP_Blocks ;

    public Program_Scops() {
        this.HTML_Blocks = new ArrayList<>();
        this.PHP_Blocks = new ArrayList<>();
    }

    public void setPHP_Blocks(List<Controller> PHP_Blocks) {
        this.PHP_Blocks = PHP_Blocks;
    }

    public List<Controller> getPHP_Blocks() {
        return PHP_Blocks;
    }

    public void setHTML_Blocks(List<Page> HTML_Blocks) {
        this.HTML_Blocks = HTML_Blocks;
    }

    public List<Page> getHTML_Blocks() {
        return HTML_Blocks;
    }

    @Override
    public String toString() {
        String Temp_HTML = "" ;
        String Temp_PHP = "" ;
        for (Page Page_Block: this.HTML_Blocks) {
            if(!Temp_HTML.equals(""))
                Temp_HTML = Temp_HTML.concat("\n");
            Temp_HTML = Temp_HTML.concat(Page_Block.toHtml());
        }

        for (Controller Controller_Block: this.PHP_Blocks) {
            if(!Temp_PHP.equals(""))
                Temp_PHP = Temp_PHP.concat("\n");
            Temp_PHP = Temp_PHP.concat(Controller_Block.toString());
        }

        return Temp_HTML + Temp_PHP;
    }

    @Override
    public String codeGenerate() {

        String Result_Php = "";
        String Result_Page = "";

        for (Controller controller:PHP_Blocks) {
            Result_Php += controller.codeGenerate();
        }

        for (Page Page_Block: this.HTML_Blocks) {
            if(!Result_Page.equals(""))
                Result_Page = Result_Page.concat("\n");
            Result_Page = Result_Page.concat(Page_Block.codeGenerate());
        }

        return Result_Page + Result_Php;
    }
}
