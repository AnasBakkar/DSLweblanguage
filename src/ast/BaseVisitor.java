package ast;

import ast.nodes.Controller.*;
import ast.nodes.Main.Program_Scops;
import ast.nodes.Page.AttributeValue.Literal_Value;
import ast.nodes.Page.AttributeValue.Numeric_Value;
import ast.nodes.Page.AttributeValue.String_Value;
import ast.nodes.Page.AttributeValue.Valuable;
import ast.nodes.Page.Attributes.*;
import ast.nodes.Page.Command_In.*;
import ast.nodes.Page.Command_Link.Link;
import ast.nodes.Page.Command_Out.Header_Command;
import ast.nodes.Page.Command_Out.Image_Command;
import ast.nodes.Page.Command_Out.Paragraph_Command;
import ast.nodes.Page.Commands_Page.Command_In;
import ast.nodes.Page.Commands_Page.Command_Link;
import ast.nodes.Page.Commands_Page.Command_Out;
import ast.nodes.Page.Header.Attribute_Header;
import ast.nodes.Page.Header.Author_Attribute;
import ast.nodes.Page.Header.Language_Attribute;
import ast.nodes.Page.Header.PageTitle_Attribute;
import ast.nodes.Page.Main_Class.Commands;
import ast.nodes.Page.Scops.Page;
import com.Main;
import gen.generated.HTMLParser;
import gen.generated.HTMLParserBaseVisitor;
import symbol_table.FunctionScope;
import symbol_table.Scope;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class BaseVisitor extends HTMLParserBaseVisitor {

    Stack<Scope> scopes = new Stack<>();

    @Override
    public Program_Scops visitProgram(HTMLParser.ProgramContext ctx) {
        if (ctx.program_structure() == null)
            throw new RuntimeException("Erorr in Program");
        Program_Scops All_Scops = new Program_Scops();
        ctx.program_structure().forEach(Part_Program -> {
            Program_Scops Temp = visitProgram_structure(Part_Program);
            All_Scops.getHTML_Blocks().addAll(Temp.getHTML_Blocks());
            All_Scops.getPHP_Blocks().addAll(Temp.getPHP_Blocks());
        });
        if (!Page.CheckExtends((ArrayList<Page>) All_Scops.getHTML_Blocks()))
            throw new RuntimeException("There are Error About Extends");
        if(!Page.CheckExtendsMulti((ArrayList<Page>) All_Scops.getHTML_Blocks()))
            throw new RuntimeException("There are Error About Extends");
        return All_Scops;
    }

    @Override
    public Program_Scops visitProgram_structure(HTMLParser.Program_structureContext ctx) {

        if (ctx.pages() == null || ctx.controllers() == null)
            throw new RuntimeException("Error in Program_structure");

        Program_Scops Part_Program = new Program_Scops();

        if (ctx.pages() != null) {
            ArrayList<Page> Blocks = visitPages(ctx.pages());
            if (Blocks != null)
                Part_Program.getHTML_Blocks().addAll(Blocks);
        }


        if (ctx.controllers() != null) {
            ArrayList<Controller> Blocks = visitControllers(ctx.controllers());
            if (Blocks != null)
                Part_Program.getPHP_Blocks().addAll(Blocks);
        }
        //com.Main.symbolTable.setPage_controller(Part_Program.getHTML_Blocks().getName().toString() , Part_Program.getPHP_Blocks().getName().toString());


        return Part_Program;
    }

    @Override
    public ArrayList<Page> visitPages(HTMLParser.PagesContext ctx) {

        if (ctx.page() == null)
            throw new RuntimeException("Error in Pages");

        ArrayList<Page> HTML_Blocks = new ArrayList<>();

        if (ctx.page() == null)
            return null;

        for (HTMLParser.PageContext HTML_Block : ctx.page())
            HTML_Blocks.add(visitPage(HTML_Block));

        return HTML_Blocks;
    }

    @Override
    public Page visitPage(HTMLParser.PageContext ctx) {

        if (ctx.PAGE_ID() == null || ctx.PAGE_ID(0) == null)
            throw new RuntimeException("The ID Page is Undefine");

        Page HTML_Block = new Page();

        HTML_Block.setLine(ctx.PAGE_ID(0).getSymbol().getLine());
        HTML_Block.setCol(ctx.PAGE_ID(0).getSymbol().getCharPositionInLine());


        HTML_Block.setName(ctx.PAGE_ID(0).getText());


        for (int i = 1; i < ctx.PAGE_ID().size(); i++)
            HTML_Block.setExtends_Name(ctx.PAGE_ID(i).getText());


        HTML_Block.getHead().all_Attribute.addAll(visitPage_header(ctx.page_header()));


        ctx.page_body().forEach(Rule -> {
            HTML_Block.getRules().add(visitPage_body(Rule));
        });
        if (Main.symbolTable.getPage_controller().containsKey(HTML_Block.getName())) {
            System.out.println("error in line  " + +HTML_Block.getLine() + "..The page name " + ctx.PAGE_ID(0) + "  is already in use. ");
            throw new RuntimeException("error in line  " + +HTML_Block.getLine() + "..The page name " + ctx.PAGE_ID(0) + "  is already in use. ");
        } else
            Main.symbolTable.setPage_controller(HTML_Block.getName(), "");

        return HTML_Block;
    }

    @Override
    public ArrayList<Attribute_Header> visitPage_header(HTMLParser.Page_headerContext ctx) {

        if (ctx.HEADER() == null)
            throw new RuntimeException("Attribute Head in Error");

        ArrayList<Attribute_Header> Attribute_H = new ArrayList<>();

        if (ctx.HEADER_TYPE() == null)
            return Attribute_H;

        for (int i = 0; i < ctx.HEADER_TYPE().size(); i++) {

            if (ctx.HEADER_TYPE(i) == null || ctx.STRING_VALUE(i) == null)
                throw new RuntimeException("Attribute Head in Error");

            Attribute_Header Temp_Name;
            Literal_Value<String> Temp_Value = new String_Value();

            switch (ctx.HEADER_TYPE(i).getText()) {
                case "pageTitle":
                    Temp_Name = new PageTitle_Attribute();
                    break;
                case "language":
                    Temp_Name = new Language_Attribute();
                    break;
                case "author":
                    Temp_Name = new Author_Attribute();
                    break;
                default:
                    throw new RuntimeException("Attribute Head in Error");
            }

            Temp_Name.setLine(ctx.HEADER_TYPE(i).getSymbol().getLine());
            Temp_Name.setLine(ctx.HEADER_TYPE(i).getSymbol().getCharPositionInLine());

            Temp_Value.setValue(ctx.STRING_VALUE(i).getText().replace("\"", ""));
            Temp_Value.setLine(ctx.STRING_VALUE(i).getSymbol().getLine());
            Temp_Value.setCol(ctx.STRING_VALUE(i).getSymbol().getCharPositionInLine());

            Temp_Name.setValue(Temp_Value);
            Attribute_H.add(Temp_Name);
        }

        return Attribute_H;
    }

    @Override
    public Commands visitPage_body(HTMLParser.Page_bodyContext ctx) {
        if (ctx.input_rules() != null)
            return visitInput_rules(ctx.input_rules());
        if (ctx.output_rules() != null)
            return visitOutput_rules(ctx.output_rules());
        else if (ctx.link() != null)
            return visitLink(ctx.link());
        return null;
    }

    @Override
    public Commands visitOutput_rules(HTMLParser.Output_rulesContext ctx) {

        Command_Out Out;

        switch (ctx.OUTPUT_TYPES().getText()) {
            case "Paragraph":
                Out = new Paragraph_Command();
                break;
            case "Image":
                Out = new Image_Command();
                break;
            case "Header":
                Out = new Header_Command();
                break;
            default:
                throw new RuntimeException("The Command is Unrecognized");
        }

        Out.setLine(ctx.OUT().getSymbol().getLine());
        Out.setCol(ctx.OUT().getSymbol().getCharPositionInLine());

        ctx.attribute().forEach(attr -> {
                    Out.getAll_Attribute().add(visitAttribute(attr));
                }
        );

        return Out;
    }

    @Override
    public Commands visitLink(HTMLParser.LinkContext ctx) {

        Command_Link link = new Link();

        link.setLine(ctx.LINK().getSymbol().getLine());
        link.setCol(ctx.LINK().getSymbol().getCharPositionInLine());

        ctx.attribute().forEach(attr -> {
            link.getAll_Attribute().add(visitAttribute(attr));
        });

        return link;
    }

    @Override
    public Command_In visitInput_rules(HTMLParser.Input_rulesContext ctx) {
        ArrayList<Commands> Temp = new ArrayList<>();
        Command_In typeInput = new Command_In();
        for (HTMLParser.Nested_inputContext Attr : ctx.nested_input()) {
            Temp.add(visitNested_input(Attr));
        }
        if (ctx.PAGE_ID() != null) {
            typeInput.setAction(ctx.PAGE_ID().getText());
        } else
            typeInput.setAction("");
        typeInput.setLine(ctx.IN().getSymbol().getLine());
        typeInput.setCol(ctx.IN().getSymbol().getCharPositionInLine());
        typeInput.setXXX(Temp);
        return typeInput;
    }

    @Override
    public Commands visitNested_input(HTMLParser.Nested_inputContext ctx) {
        Commands typeInput = null;
        switch (ctx.INPUT_TYPES().getText()) {
            case "CheckBox":
                typeInput = new CheckBox();
                break;
            case "EmailField":
                typeInput = new EmailField();
                break;
            case "TextField":
                typeInput = new TextField();
                break;
            case "SubmitButton":
                typeInput = new SubmitButton();
                break;
            case "RadioButton":
                typeInput = new RadioButton();
                break;
            case "PasswordField":
                typeInput = new PasswordField();
                break;
            case "NumberField":
                typeInput = new NumberField();
                break;
            default:
                throw new RuntimeException("The Type Input is Not Found :(");
        }
        for (HTMLParser.AttributeContext Attr : ctx.attribute()) {
            typeInput.getAll_Attribute().add(visitAttribute(Attr));
        }
        return typeInput;
    }

    @Override
    public Attribute_Command visitAttribute(HTMLParser.AttributeContext ctx) {

        Attribute_Command Attribute;
        Valuable Value_Attribute = null;

        switch (ctx.ATTRIBUTE().getText()) {
            case "title":
                Attribute = new Title_Attribute();
                break;
            case "value":
                Attribute = new Value_Attribute();
                break;
            case "width":
                Attribute = new Width_Attribute();
                break;
            case "height":
                Attribute = new Height_Attribute();
                break;
            case "source":
                Attribute = new Source_Attribute();
                break;
            default:
                throw new RuntimeException("The Attribute is Unrecognized");
        }

        Attribute.setLine(ctx.ATTRIBUTE().getSymbol().getLine());
        Attribute.setCol(ctx.ATTRIBUTE().getSymbol().getCharPositionInLine());

        if (ctx.NUMERIC_VALUE1() != null) {
            Numeric_Value Float_Value = new Numeric_Value();
            Float F = Float.parseFloat(ctx.NUMERIC_VALUE1().getText());
            Float_Value.setValue(F);
            Float_Value.setLine(ctx.NUMERIC_VALUE1().getSymbol().getLine());
            Float_Value.setCol(ctx.NUMERIC_VALUE1().getSymbol().getCharPositionInLine());
            Value_Attribute = Float_Value;
        } else if (ctx.STRING_VALUE() != null) {
            String_Value String_Value = new String_Value();
            String S = ctx.STRING_VALUE().getText().replace("\"", "");
            String_Value.setValue(S);
            String_Value.setLine(ctx.STRING_VALUE().getSymbol().getLine());
            String_Value.setCol(ctx.STRING_VALUE().getSymbol().getCharPositionInLine());
            Value_Attribute = String_Value;
        }

        // Numiric is Error
        if (Value_Attribute != null)
            Attribute.setValue(Value_Attribute);
        else {
            Numeric_Value Float_Value = new Numeric_Value();
            float Initial_Value = 0;
            Float_Value.setValue(Initial_Value);
            Float_Value.setLine(ctx.NUMERIC_VALUE1().getSymbol().getLine());
            Float_Value.setCol(ctx.NUMERIC_VALUE1().getSymbol().getCharPositionInLine());
            Value_Attribute = Float_Value;
        }

        return Attribute;
    }

    @Override
    public Controller visitController(HTMLParser.ControllerContext ctx) {
        Scope scope = new Scope();
        scope.setParent(null);
        scope.setID(1);
        scopes.push(scope);

        Controller controllerNode = new Controller();
        controllerNode.setControllerId(ctx.CONTROLLER_ID(0).getText());
        //controllerNode.setControlledPage(ctx.CONTROLLER_ID(1).getText());
        controllerNode.setLine(ctx.CONTROLLER_ID(0).getSymbol().getLine());
        controllerNode.setCol(ctx.CONTROLLER_ID(0).getSymbol().getCharPositionInLine());
        List<ControllerBody> statements = new ArrayList<ControllerBody>();
        for (int i = 0; i < ctx.code().size(); i++) {
            statements.add((ControllerBody) visitCode(ctx.code(i)));
        }
        controllerNode.setControllerStatments(statements);
        if (Main.symbolTable.getPage_controller().containsKey(controllerNode.getControllerId())) {
            System.out.println("error in line " + +controllerNode.getLine() + "..The controller name " + ctx.CONTROLLER_ID(0) + "  is already in use. ");
            throw new RuntimeException("error in line " + +controllerNode.getLine() + "..The controller name " + ctx.CONTROLLER_ID(0) + "  is already in use. ");
        } else
            Main.symbolTable.setPage_controller(controllerNode.getControllerId(), "");
        if (ctx.CONTROLLER_ID(1) != null) {
            if (Main.symbolTable.getPage_controller().containsKey(ctx.CONTROLLER_ID(1).toString())) {
                controllerNode.setControlledPage(ctx.CONTROLLER_ID(1).getText());
            } else {
                System.out.println("error in line " + controllerNode.getLine() + "..the page " + ctx.CONTROLLER_ID(1) + " is not declared ");
                throw new RuntimeException("error in line " + controllerNode.getLine() + "..the page " + ctx.CONTROLLER_ID(1) + " is not declared ");
            }
        }
        System.out.println("scope variables");
        for (int j = 0; j < scopes.peek().getScopeVariables().size(); j++) {
            System.out.println(scopes.peek().getID() + "  " + scopes.peek().getScopeVariables().keySet().toArray()[j] +
                    "   " + scopes.peek().getScopeVariables().get(scopes.peek().getScopeVariables().keySet().toArray()[j]));
        }
        if (!Main.symbolTable.getPageAndItsController().containsKey(controllerNode.getControllerId())) {
            Main.symbolTable.setPageAndItsController(controllerNode.getControlledPage(),controllerNode.getControllerId());
            System.out.println("page and its controller" + Main.symbolTable.getPageAndItsController());
        }
        Main.symbolTable.setScopes(scopes.peek());
        scopes.pop();
        return controllerNode;
    }

    @Override
    public ArrayList<Controller> visitControllers(HTMLParser.ControllersContext ctx) {

        if (ctx.controller() == null)
            throw new RuntimeException("Error in Controller");

        ArrayList<Controller> PHP_Blocks = new ArrayList<>();

        if (ctx.controller() == null)
            return null;

        for (HTMLParser.ControllerContext Block : ctx.controller())
            PHP_Blocks.add(visitController(Block));

        return PHP_Blocks;
    }

    @Override
    public Object visitCode(HTMLParser.CodeContext ctx) {
        ControllerBody node = new ControllerBody();
        FunctionDeclaration funNode = new FunctionDeclaration();
        For forNode = new For();
        If ifNode = new If();
        While whileNode = new While();
        if (ctx.children.get(0) instanceof HTMLParser.Variable_assignmentContext)
            return visitVariable_assignment(ctx.variable_assignment());
        /*if (ctx.children.get(0) instanceof HTMLParser.If_ruleContext) {
            System.out.println("if");
            return visitNested_code(ctx.nested_code());
        }*/
        if (ctx.children.get(0) instanceof HTMLParser.Variable_declarationContext)
            return visitVariable_declaration(ctx.variable_declaration());

        if (ctx.children.get(0) instanceof HTMLParser.PrintContext) {
            return visitPrint(ctx.print());
        }
        if (ctx.children.get(0) instanceof HTMLParser.ListContext) {
            return visitList(ctx.list());
        }
        if (ctx.children.get(0) instanceof HTMLParser.Function_callContext) {
            return visitFunction_call(ctx.function_call());
        }
        if (ctx.children.get(0) instanceof HTMLParser.List_operationsContext) {
            return visitList_operations(ctx.list_operations());
        }
        if (ctx.children.get(0) instanceof HTMLParser.FunctionContext) {
            Scope scope = new Scope();
            scope.setParent(scopes.peek());
            scope.setID(scopes.peek().getID() + 1);
            scopes.push(scope);
            //System.out.println("ameer");
            funNode = (FunctionDeclaration) visitFunction(ctx.function());
            if (ctx.nested_code() != null) {
                //System.out.println("am");
                NestedCode nestedCode = (NestedCode) visit(ctx.nested_code());
                funNode.setNestedCode(nestedCode);
            }
            Main.symbolTable.setScopes(scopes.peek());
            scopes.pop();
            return funNode;
        }
        if (ctx.children.get(0) instanceof HTMLParser.For_ruleContext) {
            Scope scope = new Scope();
            scope.setParent(scopes.peek());
            scope.setID(scopes.peek().getID() + 1);
            scopes.push(scope);
            forNode = (For) visitFor_rule(ctx.for_rule());
            if (ctx.nested_code() != null) {
                NestedCode nestedCode = (NestedCode) visit(ctx.nested_code());
                forNode.setNestedCode(nestedCode);
            }
            Main.symbolTable.setScopes(scopes.peek());
            scopes.pop();
            return forNode;
        }
        if (ctx.children.get(0) instanceof HTMLParser.If_ruleContext) {
            Scope scope = new Scope();
            scope.setParent(scopes.peek());
            scope.setID(scopes.peek().getID() + 1);
            scopes.push(scope);
            ifNode = (If) visitIf_rule(ctx.if_rule());
            if (ctx.nested_code() != null) {
                NestedCode nestedCode = (NestedCode) visit(ctx.nested_code());
                ifNode.setNestedCode(nestedCode);
            }
            Main.symbolTable.setScopes(scopes.peek());
            scopes.pop();
            return ifNode;
        }
        if (ctx.children.get(0) instanceof HTMLParser.While_ruleContext) {
            Scope scope = new Scope();
            scope.setParent(scopes.peek());
            scope.setID(scopes.peek().getID() + 1);
            scopes.push(scope);
            whileNode = (While) visitWhile_rule(ctx.while_rule());
            if (ctx.nested_code() != null) {
                NestedCode nestedCode = (NestedCode) visit(ctx.nested_code());
                whileNode.setNestedCode(nestedCode);
            }
            Main.symbolTable.setScopes(scopes.peek());
            scopes.pop();
            return whileNode;
        }
        if (ctx.nested_code() != null) {
            //System.out.println("             l                      l                  l");
            NestedCode nestedCode = (NestedCode) visit(ctx.nested_code());
            node.setNestedBlock(nestedCode);
        }
        return node;
    }

    @Override
    public Object visitVariable_declaration(HTMLParser.Variable_declarationContext ctx) {
        VariableDeclaration node = new VariableDeclaration();
        node.setVariableAssignment((VariableAssignment) visit(ctx.variable_assignment()));
        return node;
    }

    @Override
    public Object visitVariable_assignment(HTMLParser.Variable_assignmentContext ctx) {
        VariableAssignment node = new VariableAssignment();
        List<ValueNode> values = new ArrayList<>();
        List<String> operators = new ArrayList<>();
        for (int i = 0; i < ctx.value().size(); i++) {
            values.add((ValueNode) visit(ctx.value(i)));
            if (ctx.OPERAND(i) != null)
                operators.add(ctx.OPERAND(i).getText());
        }
        node.setVarName(ctx.VARIABLE_NAME().getText());
        scopes.peek().setScopeVariables(ctx.VARIABLE_NAME().getText(), "var");
        node.setValue(values);
        node.setOperators(operators);
        return node;
    }

    @Override
    public Object visitNested_code(HTMLParser.Nested_codeContext ctx) {
        NestedCode nestedCode = new NestedCode();
        List<ControllerBody> nestedStatements = new ArrayList<>();
        for (int i = 0; i < ctx.code().size(); i++) {
            nestedStatements.add((ControllerBody) visit(ctx.code(i)));
        }
        nestedCode.setNestedStatements(nestedStatements);
        return nestedCode;
    }

    @Override
    public Object visitValue(HTMLParser.ValueContext ctx) {
        ValueNode node = new ValueNode();
        //if(Integer.pars)

        if (ctx.children.get(0) instanceof HTMLParser.Session_ruleContext) {
            //System.out.println("gggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg");
            node.setValue(visitSession_rule(ctx.session_rule()));
        } else if (ctx.children.get(0) instanceof HTMLParser.Post_ruleContext) {
            //System.out.println("gggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg");
            node.setValue(visitPost_rule(ctx.post_rule()));
        } else {
            node.setValue(ctx.getText());
        }
        return node;
    }

    @Override
    public Object visitPrint(HTMLParser.PrintContext ctx) {
        Print node = new Print();
        List<ValueNode> valuesToPrint = new ArrayList<>();
        for (int i = 0; i < ctx.value().size(); i++) {
            valuesToPrint.add((ValueNode) visit(ctx.value(i)));
        }
        node.setValuesToPrint((ArrayList<ValueNode>) valuesToPrint);
        return node;
    }

    @Override
    public Object visitFunction_call(HTMLParser.Function_callContext ctx) {
        FunctionCall node = new FunctionCall();
        node.setLine(ctx.VARIABLE_NAME().getSymbol().getLine());
        node.setCol(ctx.VARIABLE_NAME().getSymbol().getCharPositionInLine());
        List<ValueNode> parameters = new ArrayList<>();
        boolean check = false;
        node.setFunctionName(ctx.VARIABLE_NAME().getText());
        for (int i = 0; i < Main.symbolTable.getScopes().size(); i++) {
            if (Main.symbolTable.getScopes().get(i) instanceof FunctionScope) {
                if (node.getFunctionName().equals(((FunctionScope) Main.symbolTable.getScopes().get(i)).getFunctionName())) {
                    check = true;
                }
            }
        }
        if (!check) {
            System.out.println("error in line " + node.getLine() + " the function is not declared");
            throw new RuntimeException("error in line " + node.getLine() + " the function is not declared");
        }
        for (int i = 0; i < ctx.value().size(); i++) {
            parameters.add((ValueNode) visit(ctx.value(i)));
        }
        node.setFunctionParams((ArrayList<ValueNode>) parameters);
        node.errorHandle(scopes.peek());
        return node;
    }

    @Override
    public Object visitFunction(HTMLParser.FunctionContext ctx) {
        FunctionScope functionScope = new FunctionScope();
        functionScope.setParent(scopes.peek());
        functionScope.setID(scopes.peek().getID() + 1);
        FunctionDeclaration node = new FunctionDeclaration();
        node.setLine(ctx.FUNCTION().getSymbol().getLine());
        List<String> params = new ArrayList<>();
        //NestedCode functionNestedCode = visitNested_code(ctx.);
        node.setFunctionName(ctx.VARIABLE_NAME(0).getText());
        functionScope.setFunctionName(ctx.VARIABLE_NAME(0).getText());
        scopes.push(functionScope);
        for (int i = 1; i < ctx.VARIABLE_NAME().size(); i++) {
            if(params.contains(ctx.VARIABLE_NAME(i).getText())){
                System.out.println("error in line " + node.getLine() + " ,"+ctx.VARIABLE_NAME(i).getText()+" is already exist");
                throw new RuntimeException("error in line " + node.getLine() + " ,"+ctx.VARIABLE_NAME(i).getText()+" is already exist");
            }
            params.add(ctx.VARIABLE_NAME(i).getText());
            ((FunctionScope) scopes.peek()).setParameters(ctx.VARIABLE_NAME(i).toString(), "parameter");
        }
        for (int j = 0; j < ((FunctionScope) scopes.peek()).getParameters().size(); j++) {
            System.out.println(((FunctionScope) scopes.peek()).getID() + "  " + ((FunctionScope) scopes.peek()).getFunctionName() +
                    "   " + ((FunctionScope) scopes.peek()).getParameters().keySet().toArray()[j] +
                    "   " + ((FunctionScope) scopes.peek()).getParameters().get(((FunctionScope) scopes.peek()).getParameters().keySet().toArray()[j]));
        }
        node.setParams((ArrayList<String>) params);
        Main.symbolTable.setParamsNumber(node.getFunctionName(), params.size());
        Main.symbolTable.setScopes(scopes.peek());
        scopes.pop();
        return node;
    }

    @Override
    public Object visitList(HTMLParser.ListContext ctx) {
        ListNode node = new ListNode();
        node.setCol(ctx.VARIABLE_NAME().getSymbol().getCharPositionInLine());
        node.setLine(ctx.VARIABLE_NAME().getSymbol().getLine());
        List<ValueNode> values = new ArrayList<>();
        node.setListName(ctx.VARIABLE_NAME().getText());
        for (int i = 0; i < ctx.value().size(); i++) {
            values.add((ValueNode) visitValue(ctx.value(i)));
        }
        node.setValues(values);
        Scope Parent = this.scopes.peek();
        while (Parent != null) {
            if (Parent.getScopeVariables().containsKey(node.getListName()) &&
                    Parent.getScopeVariables().get(node.getListName()).equals("list"))
                break;
            Parent = Parent.getParent();
        }
        if (Parent == null) {
            //System.out.println(node.getListName() + "is defined     !      !");
            this.scopes.peek().setScopeVariables(node.getListName(), "list");
            this.scopes.peek().setListValues(node.getListName(), node.getValues().size());
            //System.out.println(scopes.peek().getListValues());
        } else {
            System.out.println("error in line " + node.getLine() + ", the list name is already defined");
            throw new RuntimeException("error in line " + node.getLine() + ", the list name is already defined");
        }

        return node;
    }

    @Override
    public Object visitList_operations(HTMLParser.List_operationsContext ctx) {
        ListOperation node = new ListOperation();
        node.setLine(ctx.VARIABLE_NAME().getSymbol().getLine());
        node.setCol(ctx.VARIABLE_NAME().getSymbol().getCharPositionInLine());
        OperationType operationType = new OperationType();
        node.setListName(ctx.VARIABLE_NAME().getText());
        if (ctx.list_add() != null || ctx.list_remove() != null || ctx.list_get() != null ||
                ctx.list_length() != null) {
            Scope Parent = this.scopes.peek();
            while (Parent != null) {
                if (Parent.getScopeVariables().containsKey(node.getListName()) &&
                        Parent.getScopeVariables().get(node.getListName()).equals("list"))
                    break;
                Parent = Parent.getParent();
                if (Parent == null) {
                    System.out.println("error in line " + node.getLine() + " list " + ctx.VARIABLE_NAME().getText() + " is not declared ");
                    throw new RuntimeException("error in line " + node.getLine() + " list " + ctx.VARIABLE_NAME().getText() + " is not declared ");
                }
            }
        }
        if (ctx.list_add() != null) {
            operationType = (OperationType) visitList_add(ctx.list_add());
        }
        /*else if(ctx.list_length()!=null){
            operationType = (OperationType) visitList_remove(ctx.list_remove());
        }*/
        else if (ctx.list_remove() != null) {
            operationType = (OperationType) visitList_remove(ctx.list_remove());
            Scope Parent = this.scopes.peek();
            while (Parent != null) {
                if (Parent.getListValues().containsKey(node.getListName()) &&
                        Parent.getListValues().get(node.getListName()) <= ((ListRemove) operationType).getValue()) {
                    System.out.println("error in line " + node.getLine() + " in list " + node.getListName() + " index out of bounds");
                    throw new RuntimeException("error in line " + node.getLine() + " in list " + node.getListName() + " index out of bounds");
                }
                Parent = Parent.getParent();
            }
        } else if (ctx.list_get() != null) {
            operationType = (OperationType) visitList_get(ctx.list_get());
            Scope Parent = this.scopes.peek();
            while (Parent != null) {
                if (Parent.getListValues().containsKey(node.getListName()) &&
                        Parent.getListValues().get(node.getListName()) <= ((ListGet) operationType).getIndex()) {
                    System.out.println("error in line " + node.getLine() + " in list " + node.getListName() + " index out of bounds");
                    throw new RuntimeException("error in line " + node.getLine() + " in list " + node.getListName() + " index out of bounds");
                }

                Parent = Parent.getParent();
            }
        }
        else if(ctx.list_length() != null){
            operationType = (OperationType) visitList_length(ctx.list_length());
        }

        node.setOperation(operationType);
        return node;
    }

    @Override
    public Object visitList_add(HTMLParser.List_addContext ctx) {
        ListAdd node = new ListAdd();
        node.setValue((ValueNode) visitValue(ctx.value()));
        return node;
    }

    @Override
    public Object visitList_remove(HTMLParser.List_removeContext ctx) {
        ListRemove node = new ListRemove();
        node.setValue(Integer.parseInt(ctx.NUMERIC_VALUE().getText()));
        return node;
    }

    @Override
    public Object visitList_get(HTMLParser.List_getContext ctx) {
        ListGet node = new ListGet();
        node.setIndex(Integer.parseInt(ctx.NUMERIC_VALUE().getText()));
        return node;
    }

    @Override
    public Object visitList_length(HTMLParser.List_lengthContext ctx) {
        ListLength node = new ListLength();
        return node;
    }

    @Override
    public Object visitFor_rule(HTMLParser.For_ruleContext ctx) {
        For node = new For();
        node.setIteratorName(ctx.VARIABLE_NAME().getText());
        node.setInitialStep(Integer.parseInt(ctx.NUMERIC_VALUE(0).getText()));
        node.setFinalStep(Integer.parseInt(ctx.NUMERIC_VALUE(1).getText()));
        node.setStep(Integer.parseInt(ctx.NUMERIC_VALUE(2).getText()));
        return node;
    }

    @Override
    public Object visitIf_rule(HTMLParser.If_ruleContext ctx) {
        If node = new If();
        List<Condition> conditions = new ArrayList<>();
        List<String> operators = new ArrayList<>();
        for (int i = 0; i < ctx.if_while_condition().size(); i++) {
            conditions.add((Condition) visitIf_while_condition(ctx.if_while_condition(i)));
        }
        for (int i = 0; i < ctx.CONDITIONAL_OPERATORS_CONCAT().size(); i++) {
            operators.add(ctx.CONDITIONAL_OPERATORS_CONCAT(i).getText());
        }
        node.setConditions(conditions);
        node.setOperators(operators);
        return node;
    }

    @Override
    public Object visitWhile_rule(HTMLParser.While_ruleContext ctx) {
        While node = new While();
        List<Condition> conditions = new ArrayList<>();
        List<String> operators = new ArrayList<>();
        for (int i = 0; i < ctx.if_while_condition().size(); i++) {
            conditions.add((Condition) visitIf_while_condition(ctx.if_while_condition(i)));
        }
        for (int i = 0; i < ctx.CONDITIONAL_OPERATORS_CONCAT().size(); i++) {
            operators.add(ctx.CONDITIONAL_OPERATORS_CONCAT(i).getText());
        }
        node.setConditions(conditions);
        node.setOperators(operators);
        return node;
    }

    @Override
    public Object visitIf_while_condition(HTMLParser.If_while_conditionContext ctx) {
        Condition node = new Condition();
        boolean check = false;
        String left = "";
        Iterator value = scopes.iterator();
        node.setLine(ctx.CONDITIONAL_OPERATORS_TWO_OPERAND().getSymbol().getLine());
        node.setCol(ctx.CONDITIONAL_OPERATORS_TWO_OPERAND().getSymbol().getCharPositionInLine());
        ValueNode leftOperator = (ValueNode) visit(ctx.value(0));
        ValueNode rightOperator = (ValueNode) visit(ctx.value(1));
        node.setLeftOperand(leftOperator);
        node.setRightOperand(rightOperator);
        //.out.println(scopes.peek().getScopeVariables());
        node.errorHandle(scopes.peek());

        /*for(int i = 0 ; i < scopes.size() ; i++){
            left = node.getLeftOperand().getValue().toString();
            char firstChar = left.charAt(0);
            if(!left.startsWith("\"") && !left.startsWith("-") && !left.contains("true") && !left.contains("false") && !Character.isDigit(firstChar)) {
                System.out.println("siiiiiizeeeee : "+com.Main.symbolTable.getScopes().size());
                if (node.getLeftOperand().equals((scopes.get(i)).getScopeVariables().containsKey(left))) {
                    check = true;
                }
            }
        }*/
        /*List<Scope> newScopes = new ArrayList<>();
        while(value.hasNext()){
            newScopes.add((Scope)value.next());
        }
        for(int i = 0 ; i < newScopes.size() ; i++){
            left = node.getLeftOperand().getValue().toString();
            char firstChar = left.charAt(0);
            if(!left.startsWith("\"") && !left.startsWith("-") && !left.contains("true") && !left.contains("false") && !Character.isDigit(firstChar)) {
                //System.out.println("siiiiiizeeeee : "+ newScopes.get(i).getScopeVariables().size());
                //System.out.println("tttttttttttttttttt  " + newScopes.get(i).getScopeVariables());
                System.out.println(" keys are : " + newScopes.get(i).getScopeVariables().keySet());
                if ((newScopes.get(i).getScopeVariables().containsKey(left)) && !(newScopes.get(i) instanceof FunctionScope) ) {
                    check = true;
                }
            }
        }

        if(!check){
            System.out.println("error in line " + node.getLine() + " the variable "+ left +" is not declared");
        }*/
        node.setOperator(ctx.CONDITIONAL_OPERATORS_TWO_OPERAND().getText());
        return node;
    }

    @Override
    public Object visitSession_rule(HTMLParser.Session_ruleContext ctx) {
        //System.out.println("doneeeeeeeeeeeeeeeeeeeeeee");
        Session node = new Session();
        node.setValue(ctx.VARIABLE_NAME().getText());
        return node;
    }

    @Override
    public Object visitPost_rule(HTMLParser.Post_ruleContext ctx) {
        Post node = new Post();
        node.setValue(ctx.VARIABLE_NAME().getText());
        return node;
    }

    /*@Override
    public Object visitList_length(HTMLParser.List_lengthContext ctx) {
        return super.visitList_length(ctx);
    }*/
    /* @Override
    public Object visitOutput_rules(HTMLParser.Output_rulesContext ctx) {
        InputRule node = new InputRule();
        List<pageAttribute> attributes = new ArrayList<>();
        node.setInputType(ctx.OUTPUT_TYPES().getText());
        System.out.println(ctx.attribute().size());
        ctx.attribute().forEach(attr ->{
            attributes.add(visitAttribute(attr));
        });
        for(int i = 0 ; i < ctx.attribute().size() ; i++) {
            attributes.add((pageAttribute) visit(ctx.attribute(i)));
            System.out.println("l");
        }
        node.setAttributes(ctx.attribute().stream().map(this::visitAttribute).collect(Collectors.toList()));
        node.setAttributes(attributes);
        return node;
    }*/

    /*@Override
    public pageAttribute visitAttribute(HTMLParser.AttributeContext ctx) {
        pageAttribute attribute = new pageAttribute();
        attribute.setAttributeType(ctx.ATTRIBUTE().getText());
        attribute.setAttributeValue(ctx.STRING_VALUE(0).getText());
        return attribute;
    }*/
}
