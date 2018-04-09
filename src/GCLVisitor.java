// Generated from /Users/christianpetersen/Sweg/GCL.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GCLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GCLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GCLParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(GCLParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCLParser#exprC}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprC(GCLParser.ExprCContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCLParser#exprGC}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprGC(GCLParser.ExprGCContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCLParser#a}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitA(GCLParser.AContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolDouble}
	 * labeled alternative in {@link GCLParser#b}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolDouble(GCLParser.BoolDoubleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolCompare}
	 * labeled alternative in {@link GCLParser#b}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolCompare(GCLParser.BoolCompareContext ctx);
	/**
	 * Visit a parse tree produced by the {@code True}
	 * labeled alternative in {@link GCLParser#b}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrue(GCLParser.TrueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolNot}
	 * labeled alternative in {@link GCLParser#b}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolNot(GCLParser.BoolNotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code False}
	 * labeled alternative in {@link GCLParser#b}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalse(GCLParser.FalseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolBracket}
	 * labeled alternative in {@link GCLParser#b}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolBracket(GCLParser.BoolBracketContext ctx);
}