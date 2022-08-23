package com;

import ast.BaseVisitor;
import ast.nodes.Controller.Controller;
import ast.nodes.Main.Program_Scops;
import ast.nodes.Page.Scops.Page;
import gen.generated.HTMLLexer;
import gen.generated.HTMLParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import symbol_table.SymbolTable;

import java.io.IOException;
import java.io.*;

import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class Main {
    public static SymbolTable symbolTable = new SymbolTable() ;

    public static void main(String[] args) {
        try {
            String source = "samples//samples.txt";
            String dest ="samples//result.txt";
            String cgDest ="samples//cgresult.txt";
            CharStream cs = fromFileName(source);
            File c = new File(source);
            HTMLLexer lexer = new HTMLLexer(cs);
            CommonTokenStream token  = new CommonTokenStream(lexer);
            HTMLParser parser = new HTMLParser(token);
            ParseTree tree = parser.program();
            Program_Scops doc = (Program_Scops) new BaseVisitor().visit(tree);
            int I = 1 ;
            for (Page Item: doc.getHTML_Blocks()) {
                FileWriter result = new FileWriter("C:\\xampp\\htdocs\\" + Item.getName() + ".php");
                result.write(Item.codeGenerate());
                result.close();
                I++ ;
            }
            I = 1 ;
            for (Controller Item: doc.getPHP_Blocks()) {
                FileWriter result = new FileWriter("C:\\xampp\\htdocs\\" + Item.getControllerId() + ".php");
                result.write(Item.codeGenerate());
                result.close();
                I++ ;
            }
            //System.out.println(doc.codeGenerate());
            System.out.println(doc);
            FileWriter result = new FileWriter(dest);
            result.write(doc.toString());
            result.close();
            /*FileWriter cgResult = new FileWriter(cgDest);
            cgResult.write(doc.codeGenerate());
            cgResult.close();*/

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
