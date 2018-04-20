// Generated from /Users/andreasharmuth/Google Drive/private/General_Engineering/Semester_4/CSM/pls_work/GCL.g4 by ANTLR 4.7
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
	 * Visit a parse tree produced by the {@code CIf}
	 * labeled alternative in {@link GCLParser#exprC}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCIf(GCLParser.CIfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CAssign}
	 * labeled alternative in {@link GCLParser#exprC}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCAssign(GCLParser.CAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CSep}
	 * labeled alternative in {@link GCLParser#exprC}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCSep(GCLParser.CSepContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CSkip}
	 * labeled alternative in {@link GCLParser#exprC}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCSkip(GCLParser.CSkipContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CDo}
	 * labeled alternative in {@link GCLParser#exprC}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCDo(GCLParser.CDoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GCOnCondtion}
	 * labeled alternative in {@link GCLParser#exprGC}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGCOnCondtion(GCLParser.GCOnCondtionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GCOnCondition}
	 * labeled alternative in {@link GCLParser#exprGC}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGCOnCondition(GCLParser.GCOnConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AritVar}
	 * labeled alternative in {@link GCLParser#a}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAritVar(GCLParser.AritVarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AritDouble}
	 * labeled alternative in {@link GCLParser#a}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAritDouble(GCLParser.AritDoubleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AritParentheses}
	 * labeled alternative in {@link GCLParser#a}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAritParentheses(GCLParser.AritParenthesesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AritPower}
	 * labeled alternative in {@link GCLParser#a}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAritPower(GCLParser.AritPowerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AritDig}
	 * labeled alternative in {@link GCLParser#a}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAritDig(GCLParser.AritDigContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AritNeg}
	 * labeled alternative in {@link GCLParser#a}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAritNeg(GCLParser.AritNegContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AritDiv}
	 * labeled alternative in {@link GCLParser#a}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAritDiv(GCLParser.AritDivContext ctx);
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