// Generated from C:/Users/hp/Desktop/final compiler generate/in/in2/src/generated/gen\HTMLParser.g4 by ANTLR 4.9.1
package gen.generated;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HTMLParser}.
 */
public interface HTMLParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link HTMLParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(HTMLParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(HTMLParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#program_structure}.
	 * @param ctx the parse tree
	 */
	void enterProgram_structure(HTMLParser.Program_structureContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#program_structure}.
	 * @param ctx the parse tree
	 */
	void exitProgram_structure(HTMLParser.Program_structureContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#pages}.
	 * @param ctx the parse tree
	 */
	void enterPages(HTMLParser.PagesContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#pages}.
	 * @param ctx the parse tree
	 */
	void exitPages(HTMLParser.PagesContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#controllers}.
	 * @param ctx the parse tree
	 */
	void enterControllers(HTMLParser.ControllersContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#controllers}.
	 * @param ctx the parse tree
	 */
	void exitControllers(HTMLParser.ControllersContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#page}.
	 * @param ctx the parse tree
	 */
	void enterPage(HTMLParser.PageContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#page}.
	 * @param ctx the parse tree
	 */
	void exitPage(HTMLParser.PageContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#page_header}.
	 * @param ctx the parse tree
	 */
	void enterPage_header(HTMLParser.Page_headerContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#page_header}.
	 * @param ctx the parse tree
	 */
	void exitPage_header(HTMLParser.Page_headerContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#page_body}.
	 * @param ctx the parse tree
	 */
	void enterPage_body(HTMLParser.Page_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#page_body}.
	 * @param ctx the parse tree
	 */
	void exitPage_body(HTMLParser.Page_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#input_rules}.
	 * @param ctx the parse tree
	 */
	void enterInput_rules(HTMLParser.Input_rulesContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#input_rules}.
	 * @param ctx the parse tree
	 */
	void exitInput_rules(HTMLParser.Input_rulesContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#nested_input}.
	 * @param ctx the parse tree
	 */
	void enterNested_input(HTMLParser.Nested_inputContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#nested_input}.
	 * @param ctx the parse tree
	 */
	void exitNested_input(HTMLParser.Nested_inputContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#output_rules}.
	 * @param ctx the parse tree
	 */
	void enterOutput_rules(HTMLParser.Output_rulesContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#output_rules}.
	 * @param ctx the parse tree
	 */
	void exitOutput_rules(HTMLParser.Output_rulesContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#link}.
	 * @param ctx the parse tree
	 */
	void enterLink(HTMLParser.LinkContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#link}.
	 * @param ctx the parse tree
	 */
	void exitLink(HTMLParser.LinkContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(HTMLParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(HTMLParser.AttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#controller}.
	 * @param ctx the parse tree
	 */
	void enterController(HTMLParser.ControllerContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#controller}.
	 * @param ctx the parse tree
	 */
	void exitController(HTMLParser.ControllerContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#code}.
	 * @param ctx the parse tree
	 */
	void enterCode(HTMLParser.CodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#code}.
	 * @param ctx the parse tree
	 */
	void exitCode(HTMLParser.CodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#if_rule}.
	 * @param ctx the parse tree
	 */
	void enterIf_rule(HTMLParser.If_ruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#if_rule}.
	 * @param ctx the parse tree
	 */
	void exitIf_rule(HTMLParser.If_ruleContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#if_while_condition}.
	 * @param ctx the parse tree
	 */
	void enterIf_while_condition(HTMLParser.If_while_conditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#if_while_condition}.
	 * @param ctx the parse tree
	 */
	void exitIf_while_condition(HTMLParser.If_while_conditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#for_rule}.
	 * @param ctx the parse tree
	 */
	void enterFor_rule(HTMLParser.For_ruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#for_rule}.
	 * @param ctx the parse tree
	 */
	void exitFor_rule(HTMLParser.For_ruleContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#while_rule}.
	 * @param ctx the parse tree
	 */
	void enterWhile_rule(HTMLParser.While_ruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#while_rule}.
	 * @param ctx the parse tree
	 */
	void exitWhile_rule(HTMLParser.While_ruleContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(HTMLParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(HTMLParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#variable_declaration}.
	 * @param ctx the parse tree
	 */
	void enterVariable_declaration(HTMLParser.Variable_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#variable_declaration}.
	 * @param ctx the parse tree
	 */
	void exitVariable_declaration(HTMLParser.Variable_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#variable_assignment}.
	 * @param ctx the parse tree
	 */
	void enterVariable_assignment(HTMLParser.Variable_assignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#variable_assignment}.
	 * @param ctx the parse tree
	 */
	void exitVariable_assignment(HTMLParser.Variable_assignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(HTMLParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(HTMLParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterFunction_call(HTMLParser.Function_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitFunction_call(HTMLParser.Function_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#list}.
	 * @param ctx the parse tree
	 */
	void enterList(HTMLParser.ListContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#list}.
	 * @param ctx the parse tree
	 */
	void exitList(HTMLParser.ListContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#list_operations}.
	 * @param ctx the parse tree
	 */
	void enterList_operations(HTMLParser.List_operationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#list_operations}.
	 * @param ctx the parse tree
	 */
	void exitList_operations(HTMLParser.List_operationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#list_add}.
	 * @param ctx the parse tree
	 */
	void enterList_add(HTMLParser.List_addContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#list_add}.
	 * @param ctx the parse tree
	 */
	void exitList_add(HTMLParser.List_addContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#list_remove}.
	 * @param ctx the parse tree
	 */
	void enterList_remove(HTMLParser.List_removeContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#list_remove}.
	 * @param ctx the parse tree
	 */
	void exitList_remove(HTMLParser.List_removeContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#list_length}.
	 * @param ctx the parse tree
	 */
	void enterList_length(HTMLParser.List_lengthContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#list_length}.
	 * @param ctx the parse tree
	 */
	void exitList_length(HTMLParser.List_lengthContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#list_get}.
	 * @param ctx the parse tree
	 */
	void enterList_get(HTMLParser.List_getContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#list_get}.
	 * @param ctx the parse tree
	 */
	void exitList_get(HTMLParser.List_getContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#post_rule}.
	 * @param ctx the parse tree
	 */
	void enterPost_rule(HTMLParser.Post_ruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#post_rule}.
	 * @param ctx the parse tree
	 */
	void exitPost_rule(HTMLParser.Post_ruleContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#session_rule}.
	 * @param ctx the parse tree
	 */
	void enterSession_rule(HTMLParser.Session_ruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#session_rule}.
	 * @param ctx the parse tree
	 */
	void exitSession_rule(HTMLParser.Session_ruleContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(HTMLParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(HTMLParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#nested_code}.
	 * @param ctx the parse tree
	 */
	void enterNested_code(HTMLParser.Nested_codeContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#nested_code}.
	 * @param ctx the parse tree
	 */
	void exitNested_code(HTMLParser.Nested_codeContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#lang_Misc}.
	 * @param ctx the parse tree
	 */
	void enterLang_Misc(HTMLParser.Lang_MiscContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#lang_Misc}.
	 * @param ctx the parse tree
	 */
	void exitLang_Misc(HTMLParser.Lang_MiscContext ctx);
}