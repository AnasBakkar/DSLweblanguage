// Generated from C:/Users/hp/Desktop/final compiler generate/in/in2/src/generated/gen\HTMLParser.g4 by ANTLR 4.9.1
package gen.generated;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link HTMLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface HTMLParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link HTMLParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(HTMLParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#program_structure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram_structure(HTMLParser.Program_structureContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#pages}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPages(HTMLParser.PagesContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#controllers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitControllers(HTMLParser.ControllersContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#page}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPage(HTMLParser.PageContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#page_header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPage_header(HTMLParser.Page_headerContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#page_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPage_body(HTMLParser.Page_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#input_rules}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInput_rules(HTMLParser.Input_rulesContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#nested_input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNested_input(HTMLParser.Nested_inputContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#output_rules}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutput_rules(HTMLParser.Output_rulesContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#link}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLink(HTMLParser.LinkContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute(HTMLParser.AttributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#controller}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitController(HTMLParser.ControllerContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#code}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCode(HTMLParser.CodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#if_rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_rule(HTMLParser.If_ruleContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#if_while_condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_while_condition(HTMLParser.If_while_conditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#for_rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_rule(HTMLParser.For_ruleContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#while_rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_rule(HTMLParser.While_ruleContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(HTMLParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#variable_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable_declaration(HTMLParser.Variable_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#variable_assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable_assignment(HTMLParser.Variable_assignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(HTMLParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_call(HTMLParser.Function_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(HTMLParser.ListContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#list_operations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_operations(HTMLParser.List_operationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#list_add}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_add(HTMLParser.List_addContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#list_remove}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_remove(HTMLParser.List_removeContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#list_length}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_length(HTMLParser.List_lengthContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#list_get}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_get(HTMLParser.List_getContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#post_rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPost_rule(HTMLParser.Post_ruleContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#session_rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSession_rule(HTMLParser.Session_ruleContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(HTMLParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#nested_code}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNested_code(HTMLParser.Nested_codeContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#lang_Misc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLang_Misc(HTMLParser.Lang_MiscContext ctx);
}