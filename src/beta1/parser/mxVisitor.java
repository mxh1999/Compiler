// Generated from D:/compiler/mxh/Compiler/src/beta1\mx.g4 by ANTLR 4.7.2
package beta1.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link mxParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface mxVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link mxParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(mxParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#classDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDefinition(mxParser.ClassDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#className}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassName(mxParser.ClassNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(mxParser.ClassBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#variableDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDefinition(mxParser.VariableDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(mxParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#empty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmpty(mxParser.EmptyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bool}
	 * labeled alternative in {@link mxParser#basicType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(mxParser.BoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code int}
	 * labeled alternative in {@link mxParser#basicType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(mxParser.IntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code string}
	 * labeled alternative in {@link mxParser#basicType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(mxParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code void}
	 * labeled alternative in {@link mxParser#basicType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVoid(mxParser.VoidContext ctx);
	/**
	 * Visit a parse tree produced by the {@code null}
	 * labeled alternative in {@link mxParser#basicType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNull(mxParser.NullContext ctx);
	/**
	 * Visit a parse tree produced by the {@code others}
	 * labeled alternative in {@link mxParser#basicType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOthers(mxParser.OthersContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#constructionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructionDefinition(mxParser.ConstructionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#functionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDefinition(mxParser.FunctionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#functionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionName(mxParser.FunctionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(mxParser.ListContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(mxParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#variableName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableName(mxParser.VariableNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#functionBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionBody(mxParser.FunctionBodyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code block}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(mxParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code def}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDef(mxParser.DefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(mxParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifst}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfst(mxParser.IfstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whilest}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhilest(mxParser.WhilestContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forst}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForst(mxParser.ForstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code breakst}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakst(mxParser.BreakstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code returnst}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnst(mxParser.ReturnstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code continuest}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinuest(mxParser.ContinuestContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(mxParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(mxParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(mxParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code add}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd(mxParser.AddContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parentheses}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParentheses(mxParser.ParenthesesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code new}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNew(mxParser.NewContext ctx);
	/**
	 * Visit a parse tree produced by the {@code or}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(mxParser.OrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code const}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConst(mxParser.ConstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mul}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMul(mxParser.MulContext ctx);
	/**
	 * Visit a parse tree produced by the {@code var}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(mxParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code prefix}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefix(mxParser.PrefixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code shift}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShift(mxParser.ShiftContext ctx);
	/**
	 * Visit a parse tree produced by the {@code suffix}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuffix(mxParser.SuffixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code or2}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr2(mxParser.Or2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code relation}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelation(mxParser.RelationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equal}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqual(mxParser.EqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code and}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(mxParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code and2}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd2(mxParser.And2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code xor}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXor(mxParser.XorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(mxParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#malloc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMalloc(mxParser.MallocContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newarray}
	 * labeled alternative in {@link mxParser#creator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewarray(mxParser.NewarrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newvarhas}
	 * labeled alternative in {@link mxParser#creator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewvarhas(mxParser.NewvarhasContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newvar}
	 * labeled alternative in {@link mxParser#creator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewvar(mxParser.NewvarContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(mxParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(mxParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#unknown}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnknown(mxParser.UnknownContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#leftValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeftValue(mxParser.LeftValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(mxParser.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberconst}
	 * labeled alternative in {@link mxParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberconst(mxParser.NumberconstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringconst}
	 * labeled alternative in {@link mxParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringconst(mxParser.StringconstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code trueconst}
	 * labeled alternative in {@link mxParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueconst(mxParser.TrueconstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code falseconst}
	 * labeled alternative in {@link mxParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseconst(mxParser.FalseconstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nullconst}
	 * labeled alternative in {@link mxParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullconst(mxParser.NullconstContext ctx);
}