// Generated from D:/compiler/mxh/Compiler/src/beta1\mx.g4 by ANTLR 4.7.2
package beta1.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link mxParser}.
 */
public interface mxListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link mxParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(mxParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(mxParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#classDefinition}.
	 * @param ctx the parse tree
	 */
	void enterClassDefinition(mxParser.ClassDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#classDefinition}.
	 * @param ctx the parse tree
	 */
	void exitClassDefinition(mxParser.ClassDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#className}.
	 * @param ctx the parse tree
	 */
	void enterClassName(mxParser.ClassNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#className}.
	 * @param ctx the parse tree
	 */
	void exitClassName(mxParser.ClassNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(mxParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(mxParser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#variableDefinition}.
	 * @param ctx the parse tree
	 */
	void enterVariableDefinition(mxParser.VariableDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#variableDefinition}.
	 * @param ctx the parse tree
	 */
	void exitVariableDefinition(mxParser.VariableDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(mxParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(mxParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#empty}.
	 * @param ctx the parse tree
	 */
	void enterEmpty(mxParser.EmptyContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#empty}.
	 * @param ctx the parse tree
	 */
	void exitEmpty(mxParser.EmptyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bool}
	 * labeled alternative in {@link mxParser#basicType}.
	 * @param ctx the parse tree
	 */
	void enterBool(mxParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bool}
	 * labeled alternative in {@link mxParser#basicType}.
	 * @param ctx the parse tree
	 */
	void exitBool(mxParser.BoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code int}
	 * labeled alternative in {@link mxParser#basicType}.
	 * @param ctx the parse tree
	 */
	void enterInt(mxParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code int}
	 * labeled alternative in {@link mxParser#basicType}.
	 * @param ctx the parse tree
	 */
	void exitInt(mxParser.IntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code string}
	 * labeled alternative in {@link mxParser#basicType}.
	 * @param ctx the parse tree
	 */
	void enterString(mxParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code string}
	 * labeled alternative in {@link mxParser#basicType}.
	 * @param ctx the parse tree
	 */
	void exitString(mxParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code void}
	 * labeled alternative in {@link mxParser#basicType}.
	 * @param ctx the parse tree
	 */
	void enterVoid(mxParser.VoidContext ctx);
	/**
	 * Exit a parse tree produced by the {@code void}
	 * labeled alternative in {@link mxParser#basicType}.
	 * @param ctx the parse tree
	 */
	void exitVoid(mxParser.VoidContext ctx);
	/**
	 * Enter a parse tree produced by the {@code null}
	 * labeled alternative in {@link mxParser#basicType}.
	 * @param ctx the parse tree
	 */
	void enterNull(mxParser.NullContext ctx);
	/**
	 * Exit a parse tree produced by the {@code null}
	 * labeled alternative in {@link mxParser#basicType}.
	 * @param ctx the parse tree
	 */
	void exitNull(mxParser.NullContext ctx);
	/**
	 * Enter a parse tree produced by the {@code others}
	 * labeled alternative in {@link mxParser#basicType}.
	 * @param ctx the parse tree
	 */
	void enterOthers(mxParser.OthersContext ctx);
	/**
	 * Exit a parse tree produced by the {@code others}
	 * labeled alternative in {@link mxParser#basicType}.
	 * @param ctx the parse tree
	 */
	void exitOthers(mxParser.OthersContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#constructionDefinition}.
	 * @param ctx the parse tree
	 */
	void enterConstructionDefinition(mxParser.ConstructionDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#constructionDefinition}.
	 * @param ctx the parse tree
	 */
	void exitConstructionDefinition(mxParser.ConstructionDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDefinition(mxParser.FunctionDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDefinition(mxParser.FunctionDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#functionName}.
	 * @param ctx the parse tree
	 */
	void enterFunctionName(mxParser.FunctionNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#functionName}.
	 * @param ctx the parse tree
	 */
	void exitFunctionName(mxParser.FunctionNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#list}.
	 * @param ctx the parse tree
	 */
	void enterList(mxParser.ListContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#list}.
	 * @param ctx the parse tree
	 */
	void exitList(mxParser.ListContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(mxParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(mxParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#variableName}.
	 * @param ctx the parse tree
	 */
	void enterVariableName(mxParser.VariableNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#variableName}.
	 * @param ctx the parse tree
	 */
	void exitVariableName(mxParser.VariableNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#functionBody}.
	 * @param ctx the parse tree
	 */
	void enterFunctionBody(mxParser.FunctionBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#functionBody}.
	 * @param ctx the parse tree
	 */
	void exitFunctionBody(mxParser.FunctionBodyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code block}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBlock(mxParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code block}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBlock(mxParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code def}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterDef(mxParser.DefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code def}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitDef(mxParser.DefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterExpr(mxParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitExpr(mxParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifst}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIfst(mxParser.IfstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifst}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIfst(mxParser.IfstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whilest}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterWhilest(mxParser.WhilestContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whilest}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitWhilest(mxParser.WhilestContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forst}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterForst(mxParser.ForstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forst}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitForst(mxParser.ForstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code breakst}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBreakst(mxParser.BreakstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code breakst}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBreakst(mxParser.BreakstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code returnst}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterReturnst(mxParser.ReturnstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code returnst}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitReturnst(mxParser.ReturnstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code continuest}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterContinuest(mxParser.ContinuestContext ctx);
	/**
	 * Exit a parse tree produced by the {@code continuest}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitContinuest(mxParser.ContinuestContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(mxParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(mxParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(mxParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(mxParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(mxParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(mxParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code add}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAdd(mxParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by the {@code add}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAdd(mxParser.AddContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parentheses}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParentheses(mxParser.ParenthesesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parentheses}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParentheses(mxParser.ParenthesesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code new}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNew(mxParser.NewContext ctx);
	/**
	 * Exit a parse tree produced by the {@code new}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNew(mxParser.NewContext ctx);
	/**
	 * Enter a parse tree produced by the {@code or}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOr(mxParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code or}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOr(mxParser.OrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code const}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterConst(mxParser.ConstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code const}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitConst(mxParser.ConstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mul}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMul(mxParser.MulContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mul}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMul(mxParser.MulContext ctx);
	/**
	 * Enter a parse tree produced by the {@code var}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterVar(mxParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code var}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitVar(mxParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code prefix}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPrefix(mxParser.PrefixContext ctx);
	/**
	 * Exit a parse tree produced by the {@code prefix}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPrefix(mxParser.PrefixContext ctx);
	/**
	 * Enter a parse tree produced by the {@code shift}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterShift(mxParser.ShiftContext ctx);
	/**
	 * Exit a parse tree produced by the {@code shift}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitShift(mxParser.ShiftContext ctx);
	/**
	 * Enter a parse tree produced by the {@code suffix}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSuffix(mxParser.SuffixContext ctx);
	/**
	 * Exit a parse tree produced by the {@code suffix}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSuffix(mxParser.SuffixContext ctx);
	/**
	 * Enter a parse tree produced by the {@code or2}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOr2(mxParser.Or2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code or2}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOr2(mxParser.Or2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code relation}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterRelation(mxParser.RelationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relation}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitRelation(mxParser.RelationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equal}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEqual(mxParser.EqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equal}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEqual(mxParser.EqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code and}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAnd(mxParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code and}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAnd(mxParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code and2}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAnd2(mxParser.And2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code and2}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAnd2(mxParser.And2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code xor}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterXor(mxParser.XorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xor}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitXor(mxParser.XorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assign}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAssign(mxParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAssign(mxParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#malloc}.
	 * @param ctx the parse tree
	 */
	void enterMalloc(mxParser.MallocContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#malloc}.
	 * @param ctx the parse tree
	 */
	void exitMalloc(mxParser.MallocContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newarray}
	 * labeled alternative in {@link mxParser#creator}.
	 * @param ctx the parse tree
	 */
	void enterNewarray(mxParser.NewarrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newarray}
	 * labeled alternative in {@link mxParser#creator}.
	 * @param ctx the parse tree
	 */
	void exitNewarray(mxParser.NewarrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newvarhas}
	 * labeled alternative in {@link mxParser#creator}.
	 * @param ctx the parse tree
	 */
	void enterNewvarhas(mxParser.NewvarhasContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newvarhas}
	 * labeled alternative in {@link mxParser#creator}.
	 * @param ctx the parse tree
	 */
	void exitNewvarhas(mxParser.NewvarhasContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newvar}
	 * labeled alternative in {@link mxParser#creator}.
	 * @param ctx the parse tree
	 */
	void enterNewvar(mxParser.NewvarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newvar}
	 * labeled alternative in {@link mxParser#creator}.
	 * @param ctx the parse tree
	 */
	void exitNewvar(mxParser.NewvarContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(mxParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(mxParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(mxParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(mxParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#unknown}.
	 * @param ctx the parse tree
	 */
	void enterUnknown(mxParser.UnknownContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#unknown}.
	 * @param ctx the parse tree
	 */
	void exitUnknown(mxParser.UnknownContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#leftValue}.
	 * @param ctx the parse tree
	 */
	void enterLeftValue(mxParser.LeftValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#leftValue}.
	 * @param ctx the parse tree
	 */
	void exitLeftValue(mxParser.LeftValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(mxParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(mxParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberconst}
	 * labeled alternative in {@link mxParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterNumberconst(mxParser.NumberconstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberconst}
	 * labeled alternative in {@link mxParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitNumberconst(mxParser.NumberconstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringconst}
	 * labeled alternative in {@link mxParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterStringconst(mxParser.StringconstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringconst}
	 * labeled alternative in {@link mxParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitStringconst(mxParser.StringconstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code trueconst}
	 * labeled alternative in {@link mxParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterTrueconst(mxParser.TrueconstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code trueconst}
	 * labeled alternative in {@link mxParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitTrueconst(mxParser.TrueconstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code falseconst}
	 * labeled alternative in {@link mxParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterFalseconst(mxParser.FalseconstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code falseconst}
	 * labeled alternative in {@link mxParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitFalseconst(mxParser.FalseconstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nullconst}
	 * labeled alternative in {@link mxParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterNullconst(mxParser.NullconstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nullconst}
	 * labeled alternative in {@link mxParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitNullconst(mxParser.NullconstContext ctx);
}