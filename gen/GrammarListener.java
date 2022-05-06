// Generated from C:/Users/Андрей/Documents/Япис/Lab_work_1/src/main/java\Grammar.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarParser}.
 */
public interface GrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(GrammarParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(GrammarParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#functionDeclare}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclare(GrammarParser.FunctionDeclareContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#functionDeclare}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclare(GrammarParser.FunctionDeclareContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(GrammarParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(GrammarParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(GrammarParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(GrammarParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#variableDeclare}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclare(GrammarParser.VariableDeclareContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#variableDeclare}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclare(GrammarParser.VariableDeclareContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(GrammarParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(GrammarParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(GrammarParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(GrammarParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#ifBlock}.
	 * @param ctx the parse tree
	 */
	void enterIfBlock(GrammarParser.IfBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#ifBlock}.
	 * @param ctx the parse tree
	 */
	void exitIfBlock(GrammarParser.IfBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#forCycle}.
	 * @param ctx the parse tree
	 */
	void enterForCycle(GrammarParser.ForCycleContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#forCycle}.
	 * @param ctx the parse tree
	 */
	void exitForCycle(GrammarParser.ForCycleContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(GrammarParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(GrammarParser.ArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(GrammarParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(GrammarParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(GrammarParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(GrammarParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#addNode}.
	 * @param ctx the parse tree
	 */
	void enterAddNode(GrammarParser.AddNodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#addNode}.
	 * @param ctx the parse tree
	 */
	void exitAddNode(GrammarParser.AddNodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#addArc}.
	 * @param ctx the parse tree
	 */
	void enterAddArc(GrammarParser.AddArcContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#addArc}.
	 * @param ctx the parse tree
	 */
	void exitAddArc(GrammarParser.AddArcContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#remoteNode}.
	 * @param ctx the parse tree
	 */
	void enterRemoteNode(GrammarParser.RemoteNodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#remoteNode}.
	 * @param ctx the parse tree
	 */
	void exitRemoteNode(GrammarParser.RemoteNodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#remoteArc}.
	 * @param ctx the parse tree
	 */
	void enterRemoteArc(GrammarParser.RemoteArcContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#remoteArc}.
	 * @param ctx the parse tree
	 */
	void exitRemoteArc(GrammarParser.RemoteArcContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#getNode}.
	 * @param ctx the parse tree
	 */
	void enterGetNode(GrammarParser.GetNodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#getNode}.
	 * @param ctx the parse tree
	 */
	void exitGetNode(GrammarParser.GetNodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#getArc}.
	 * @param ctx the parse tree
	 */
	void enterGetArc(GrammarParser.GetArcContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#getArc}.
	 * @param ctx the parse tree
	 */
	void exitGetArc(GrammarParser.GetArcContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#size}.
	 * @param ctx the parse tree
	 */
	void enterSize(GrammarParser.SizeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#size}.
	 * @param ctx the parse tree
	 */
	void exitSize(GrammarParser.SizeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#checkIsEmpty}.
	 * @param ctx the parse tree
	 */
	void enterCheckIsEmpty(GrammarParser.CheckIsEmptyContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#checkIsEmpty}.
	 * @param ctx the parse tree
	 */
	void exitCheckIsEmpty(GrammarParser.CheckIsEmptyContext ctx);
}