// Generated from C:/Users/Андрей/Documents/Япис/Lab_work_1/src/main/java\Grammar.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GrammarParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(GrammarParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#functionDeclare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclare(GrammarParser.FunctionDeclareContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(GrammarParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(GrammarParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#variableDeclare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclare(GrammarParser.VariableDeclareContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(GrammarParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(GrammarParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#ifBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfBlock(GrammarParser.IfBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#forCycle}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForCycle(GrammarParser.ForCycleContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentList(GrammarParser.ArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(GrammarParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(GrammarParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#addNode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddNode(GrammarParser.AddNodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#addArc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddArc(GrammarParser.AddArcContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#remoteNode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRemoteNode(GrammarParser.RemoteNodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#remoteArc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRemoteArc(GrammarParser.RemoteArcContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#getNode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetNode(GrammarParser.GetNodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#getArc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetArc(GrammarParser.GetArcContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#size}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSize(GrammarParser.SizeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#checkIsEmpty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckIsEmpty(GrammarParser.CheckIsEmptyContext ctx);
}