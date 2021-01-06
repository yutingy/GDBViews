// Generated from C:/Users/Ting/Documents/GDBViews/src\View.g4 by ANTLR 4.8
package gen;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ViewParser}.
 */
public interface ViewListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ViewParser#root}.
	 * @param ctx the parse tree
	 */
	void enterRoot(ViewParser.RootContext ctx);
	/**
	 * Exit a parse tree produced by {@link ViewParser#root}.
	 * @param ctx the parse tree
	 */
	void exitRoot(ViewParser.RootContext ctx);
	/**
	 * Enter a parse tree produced by {@link ViewParser#query}.
	 * @param ctx the parse tree
	 */
	void enterQuery(ViewParser.QueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link ViewParser#query}.
	 * @param ctx the parse tree
	 */
	void exitQuery(ViewParser.QueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link ViewParser#changegraph}.
	 * @param ctx the parse tree
	 */
	void enterChangegraph(ViewParser.ChangegraphContext ctx);
	/**
	 * Exit a parse tree produced by {@link ViewParser#changegraph}.
	 * @param ctx the parse tree
	 */
	void exitChangegraph(ViewParser.ChangegraphContext ctx);
	/**
	 * Enter a parse tree produced by {@link ViewParser#viewuse}.
	 * @param ctx the parse tree
	 */
	void enterViewuse(ViewParser.ViewuseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ViewParser#viewuse}.
	 * @param ctx the parse tree
	 */
	void exitViewuse(ViewParser.ViewuseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ViewParser#usedviews}.
	 * @param ctx the parse tree
	 */
	void enterUsedviews(ViewParser.UsedviewsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ViewParser#usedviews}.
	 * @param ctx the parse tree
	 */
	void exitUsedviews(ViewParser.UsedviewsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ViewParser#viewatom}.
	 * @param ctx the parse tree
	 */
	void enterViewatom(ViewParser.ViewatomContext ctx);
	/**
	 * Exit a parse tree produced by {@link ViewParser#viewatom}.
	 * @param ctx the parse tree
	 */
	void exitViewatom(ViewParser.ViewatomContext ctx);
	/**
	 * Enter a parse tree produced by {@link ViewParser#returnstmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnstmt(ViewParser.ReturnstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ViewParser#returnstmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnstmt(ViewParser.ReturnstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ViewParser#retval}.
	 * @param ctx the parse tree
	 */
	void enterRetval(ViewParser.RetvalContext ctx);
	/**
	 * Exit a parse tree produced by {@link ViewParser#retval}.
	 * @param ctx the parse tree
	 */
	void exitRetval(ViewParser.RetvalContext ctx);
	/**
	 * Enter a parse tree produced by {@link ViewParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(ViewParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ViewParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(ViewParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ViewParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(ViewParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link ViewParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(ViewParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link ViewParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(ViewParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ViewParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(ViewParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ViewParser#nodeName}.
	 * @param ctx the parse tree
	 */
	void enterNodeName(ViewParser.NodeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ViewParser#nodeName}.
	 * @param ctx the parse tree
	 */
	void exitNodeName(ViewParser.NodeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ViewParser#relation}.
	 * @param ctx the parse tree
	 */
	void enterRelation(ViewParser.RelationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ViewParser#relation}.
	 * @param ctx the parse tree
	 */
	void exitRelation(ViewParser.RelationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ViewParser#relationValue}.
	 * @param ctx the parse tree
	 */
	void enterRelationValue(ViewParser.RelationValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ViewParser#relationValue}.
	 * @param ctx the parse tree
	 */
	void exitRelationValue(ViewParser.RelationValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link ViewParser#path}.
	 * @param ctx the parse tree
	 */
	void enterPath(ViewParser.PathContext ctx);
	/**
	 * Exit a parse tree produced by {@link ViewParser#path}.
	 * @param ctx the parse tree
	 */
	void exitPath(ViewParser.PathContext ctx);
	/**
	 * Enter a parse tree produced by {@link ViewParser#conditions}.
	 * @param ctx the parse tree
	 */
	void enterConditions(ViewParser.ConditionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ViewParser#conditions}.
	 * @param ctx the parse tree
	 */
	void exitConditions(ViewParser.ConditionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ViewParser#boolexpr}.
	 * @param ctx the parse tree
	 */
	void enterBoolexpr(ViewParser.BoolexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ViewParser#boolexpr}.
	 * @param ctx the parse tree
	 */
	void exitBoolexpr(ViewParser.BoolexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ViewParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(ViewParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ViewParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(ViewParser.AttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ViewParser#val}.
	 * @param ctx the parse tree
	 */
	void enterVal(ViewParser.ValContext ctx);
	/**
	 * Exit a parse tree produced by {@link ViewParser#val}.
	 * @param ctx the parse tree
	 */
	void exitVal(ViewParser.ValContext ctx);
	/**
	 * Enter a parse tree produced by {@link ViewParser#test}.
	 * @param ctx the parse tree
	 */
	void enterTest(ViewParser.TestContext ctx);
	/**
	 * Exit a parse tree produced by {@link ViewParser#test}.
	 * @param ctx the parse tree
	 */
	void exitTest(ViewParser.TestContext ctx);
	/**
	 * Enter a parse tree produced by {@link ViewParser#setattr}.
	 * @param ctx the parse tree
	 */
	void enterSetattr(ViewParser.SetattrContext ctx);
	/**
	 * Exit a parse tree produced by {@link ViewParser#setattr}.
	 * @param ctx the parse tree
	 */
	void exitSetattr(ViewParser.SetattrContext ctx);
}