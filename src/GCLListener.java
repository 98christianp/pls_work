// Generated from GCL.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GCLParser}.
 */
public interface GCLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GCLParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(GCLParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCLParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(GCLParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CIf}
	 * labeled alternative in {@link GCLParser#exprC}.
	 * @param ctx the parse tree
	 */
	void enterCIf(GCLParser.CIfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CIf}
	 * labeled alternative in {@link GCLParser#exprC}.
	 * @param ctx the parse tree
	 */
	void exitCIf(GCLParser.CIfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CAssign}
	 * labeled alternative in {@link GCLParser#exprC}.
	 * @param ctx the parse tree
	 */
	void enterCAssign(GCLParser.CAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CAssign}
	 * labeled alternative in {@link GCLParser#exprC}.
	 * @param ctx the parse tree
	 */
	void exitCAssign(GCLParser.CAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CSep}
	 * labeled alternative in {@link GCLParser#exprC}.
	 * @param ctx the parse tree
	 */
	void enterCSep(GCLParser.CSepContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CSep}
	 * labeled alternative in {@link GCLParser#exprC}.
	 * @param ctx the parse tree
	 */
	void exitCSep(GCLParser.CSepContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CSkip}
	 * labeled alternative in {@link GCLParser#exprC}.
	 * @param ctx the parse tree
	 */
	void enterCSkip(GCLParser.CSkipContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CSkip}
	 * labeled alternative in {@link GCLParser#exprC}.
	 * @param ctx the parse tree
	 */
	void exitCSkip(GCLParser.CSkipContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CDo}
	 * labeled alternative in {@link GCLParser#exprC}.
	 * @param ctx the parse tree
	 */
	void enterCDo(GCLParser.CDoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CDo}
	 * labeled alternative in {@link GCLParser#exprC}.
	 * @param ctx the parse tree
	 */
	void exitCDo(GCLParser.CDoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GCOnCondtion}
	 * labeled alternative in {@link GCLParser#exprGC}.
	 * @param ctx the parse tree
	 */
	void enterGCOnCondtion(GCLParser.GCOnCondtionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GCOnCondtion}
	 * labeled alternative in {@link GCLParser#exprGC}.
	 * @param ctx the parse tree
	 */
	void exitGCOnCondtion(GCLParser.GCOnCondtionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GCOnCondition}
	 * labeled alternative in {@link GCLParser#exprGC}.
	 * @param ctx the parse tree
	 */
	void enterGCOnCondition(GCLParser.GCOnConditionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GCOnCondition}
	 * labeled alternative in {@link GCLParser#exprGC}.
	 * @param ctx the parse tree
	 */
	void exitGCOnCondition(GCLParser.GCOnConditionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AritVar}
	 * labeled alternative in {@link GCLParser#a}.
	 * @param ctx the parse tree
	 */
	void enterAritVar(GCLParser.AritVarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AritVar}
	 * labeled alternative in {@link GCLParser#a}.
	 * @param ctx the parse tree
	 */
	void exitAritVar(GCLParser.AritVarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AritDouble}
	 * labeled alternative in {@link GCLParser#a}.
	 * @param ctx the parse tree
	 */
	void enterAritDouble(GCLParser.AritDoubleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AritDouble}
	 * labeled alternative in {@link GCLParser#a}.
	 * @param ctx the parse tree
	 */
	void exitAritDouble(GCLParser.AritDoubleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AritParentheses}
	 * labeled alternative in {@link GCLParser#a}.
	 * @param ctx the parse tree
	 */
	void enterAritParentheses(GCLParser.AritParenthesesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AritParentheses}
	 * labeled alternative in {@link GCLParser#a}.
	 * @param ctx the parse tree
	 */
	void exitAritParentheses(GCLParser.AritParenthesesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AritPower}
	 * labeled alternative in {@link GCLParser#a}.
	 * @param ctx the parse tree
	 */
	void enterAritPower(GCLParser.AritPowerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AritPower}
	 * labeled alternative in {@link GCLParser#a}.
	 * @param ctx the parse tree
	 */
	void exitAritPower(GCLParser.AritPowerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AritDig}
	 * labeled alternative in {@link GCLParser#a}.
	 * @param ctx the parse tree
	 */
	void enterAritDig(GCLParser.AritDigContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AritDig}
	 * labeled alternative in {@link GCLParser#a}.
	 * @param ctx the parse tree
	 */
	void exitAritDig(GCLParser.AritDigContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AritNeg}
	 * labeled alternative in {@link GCLParser#a}.
	 * @param ctx the parse tree
	 */
	void enterAritNeg(GCLParser.AritNegContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AritNeg}
	 * labeled alternative in {@link GCLParser#a}.
	 * @param ctx the parse tree
	 */
	void exitAritNeg(GCLParser.AritNegContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolDouble}
	 * labeled alternative in {@link GCLParser#b}.
	 * @param ctx the parse tree
	 */
	void enterBoolDouble(GCLParser.BoolDoubleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolDouble}
	 * labeled alternative in {@link GCLParser#b}.
	 * @param ctx the parse tree
	 */
	void exitBoolDouble(GCLParser.BoolDoubleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolCompare}
	 * labeled alternative in {@link GCLParser#b}.
	 * @param ctx the parse tree
	 */
	void enterBoolCompare(GCLParser.BoolCompareContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolCompare}
	 * labeled alternative in {@link GCLParser#b}.
	 * @param ctx the parse tree
	 */
	void exitBoolCompare(GCLParser.BoolCompareContext ctx);
	/**
	 * Enter a parse tree produced by the {@code True}
	 * labeled alternative in {@link GCLParser#b}.
	 * @param ctx the parse tree
	 */
	void enterTrue(GCLParser.TrueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code True}
	 * labeled alternative in {@link GCLParser#b}.
	 * @param ctx the parse tree
	 */
	void exitTrue(GCLParser.TrueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolNot}
	 * labeled alternative in {@link GCLParser#b}.
	 * @param ctx the parse tree
	 */
	void enterBoolNot(GCLParser.BoolNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolNot}
	 * labeled alternative in {@link GCLParser#b}.
	 * @param ctx the parse tree
	 */
	void exitBoolNot(GCLParser.BoolNotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code False}
	 * labeled alternative in {@link GCLParser#b}.
	 * @param ctx the parse tree
	 */
	void enterFalse(GCLParser.FalseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code False}
	 * labeled alternative in {@link GCLParser#b}.
	 * @param ctx the parse tree
	 */
	void exitFalse(GCLParser.FalseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolBracket}
	 * labeled alternative in {@link GCLParser#b}.
	 * @param ctx the parse tree
	 */
	void enterBoolBracket(GCLParser.BoolBracketContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolBracket}
	 * labeled alternative in {@link GCLParser#b}.
	 * @param ctx the parse tree
	 */
	void exitBoolBracket(GCLParser.BoolBracketContext ctx);
}