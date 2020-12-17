// Generated from C:/Users/Ting/Documents/GDBViews/src\View.g4 by ANTLR 4.8
package gen;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ViewParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ViewVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ViewParser#root}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoot(ViewParser.RootContext ctx);
	/**
	 * Visit a parse tree produced by {@link ViewParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuery(ViewParser.QueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link ViewParser#changegraph}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChangegraph(ViewParser.ChangegraphContext ctx);
	/**
	 * Visit a parse tree produced by {@link ViewParser#viewuse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitViewuse(ViewParser.ViewuseContext ctx);
	/**
	 * Visit a parse tree produced by {@link ViewParser#usedviews}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsedviews(ViewParser.UsedviewsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ViewParser#viewatom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitViewatom(ViewParser.ViewatomContext ctx);
	/**
	 * Visit a parse tree produced by {@link ViewParser#returnstmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnstmt(ViewParser.ReturnstmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ViewParser#retval}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRetval(ViewParser.RetvalContext ctx);
	/**
	 * Visit a parse tree produced by {@link ViewParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(ViewParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ViewParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(ViewParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link ViewParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(ViewParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ViewParser#nodeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNodeName(ViewParser.NodeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ViewParser#relation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelation(ViewParser.RelationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ViewParser#relationValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationValue(ViewParser.RelationValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link ViewParser#path}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPath(ViewParser.PathContext ctx);
	/**
	 * Visit a parse tree produced by {@link ViewParser#conditions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditions(ViewParser.ConditionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ViewParser#boolexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolexpr(ViewParser.BoolexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ViewParser#attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute(ViewParser.AttributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ViewParser#val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVal(ViewParser.ValContext ctx);
	/**
	 * Visit a parse tree produced by {@link ViewParser#test}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTest(ViewParser.TestContext ctx);
}