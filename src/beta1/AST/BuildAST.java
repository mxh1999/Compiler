package beta1.AST;
import java.util.*;
import beta1.parser.*;

public class BuildAST extends mxBaseVisitor<Object>{
    public ProgNode prog;

    public BuildAST() {
        this.prog = new ProgNode();
    }

    @Override
    public Object visitProgram(mxParser.ProgramContext ctx) {
        for (mxParser.DefinitionContext i:ctx.definition()) {
            Object ret = i.accept(this);
            if (ret instanceof ClassNode) prog.add((ClassNode)ret);
            if (ret instanceof VariableNode) prog.add((VariableNode)ret);
            if (ret instanceof FuncNode) prog.add((FuncNode)ret);
        }
        return null;
    }


    @Override
    public ClassNode visitClassdef(mxParser.ClassdefContext ctx) {
        return visitClassDefinition(ctx.classDefinition());
    }

    @Override
    public VariableNode visitVardef(mxParser.VardefContext ctx) {
        return visitVariableDefinition(ctx.variableDefinition());
    }

    @Override
    public FuncNode visitFuncdef(mxParser.FuncdefContext ctx) {
        return visitFunctionDefinition(ctx.functionDefinition());
    }

    @Override
    public VariableNode visitVariableDefinition(mxParser.VariableDefinitionContext ctx) {
        Type type = (Type)visit(ctx.type());
        String name = (String)visit(ctx.variableName());
        Expr init = null;
        if (ctx.expression()!=null) {
            init = (Expr) visit(ctx.expression());
        }
        return new VariableNode(type,name,init);
    }

    @Override
    public String visitVariableName(mxParser.VariableNameContext ctx) {
        return ctx.getText();
    }

    @Override
    public ClassNode visitClassDefinition(mxParser.ClassDefinitionContext ctx) {
        ClassNode tmp = new ClassNode();
        tmp.name = ctx.className().getText();
        tmp.member = new LinkedList<>();
        tmp.method = new LinkedList<>();
        tmp.construction = null;
        for (mxParser.VariableDefinitionContext i:ctx.classBody().variableDefinition())
            tmp.member.add((VariableNode)visit(i));
        for (mxParser.FunctionDefinitionContext i:ctx.classBody().functionDefinition())
            tmp.method.add((FuncNode)visit(i));
        for (mxParser.ConstructionDefinitionContext i:ctx.classBody().constructionDefinition())
            tmp.construction = (FuncNode)visit(i);
        return tmp;
    }

    @Override
    public FuncNode visitFunctionDefinition(mxParser.FunctionDefinitionContext ctx) {
        FuncNode tmp = new FuncNode();
        tmp.name = ctx.functionName().getText();
        tmp.para = visitList(ctx.list());
        tmp.returnvalue = (Type)visit(ctx.type());
        tmp.body = (BlockNode)visit(ctx.functionBody());
        return tmp;
    }

    @Override
    public FuncNode visitConstructionDefinition(mxParser.ConstructionDefinitionContext ctx) {
        FuncNode tmp = new FuncNode();
        tmp.name = ctx.functionName().getText();
        if (ctx.list() != null)
            tmp.para = visitList(ctx.list());
        else
            tmp.para = new LinkedList<>();
        tmp.returnvalue = new BasicType("void");
        tmp.body = (BlockNode)visit(ctx.functionBody());
        return tmp;
    }

    @Override
    public List<VariableNode> visitList(mxParser.ListContext ctx) {
        List<VariableNode> tmp = new LinkedList<>();
        if (ctx==null) return tmp;
        if (ctx.parameter()!=null) {
            for (mxParser.ParameterContext i : ctx.parameter()) {
                Type type = (Type) visit(i.type());
                String name = i.variableName().getText();
                Expr init = null;
                tmp.add(new VariableNode(type, name, init));
            }
        }
        return tmp;
    }

    @Override
    public Type visitType(mxParser.TypeContext ctx) {
        if (ctx.empty().isEmpty()){
            SingleType ret = (SingleType)visit(ctx.basicType());
            return ret;
        }   else {
            SingleType tmp = (SingleType)visit(ctx.basicType());
            ArrayType ret = new ArrayType(tmp,ctx.empty().size());
            return ret;
        }
    }

    @Override
    public BasicType visitBool(mxParser.BoolContext ctx) {
        return new BasicType("bool");
    }

    @Override
    public BasicType visitInt(mxParser.IntContext ctx) {
        return new BasicType("int");
    }

    @Override
    public ClassType visitString(mxParser.StringContext ctx) {
        return new ClassType("string");
    }

    @Override
    public BasicType visitVoid(mxParser.VoidContext ctx) {
        return new BasicType("void");
    }

    @Override
    public ClassType visitOthers(mxParser.OthersContext ctx) {
        return new ClassType(ctx.Identifier().getText());
    }

    @Override
    public NullType visitNull(mxParser.NullContext ctx) {
        return new NullType();
    }

    @Override
    public BlockNode visitFunctionBody(mxParser.FunctionBodyContext ctx) {
        BlockNode ret = new BlockNode();
        for (mxParser.StatementContext i:ctx.statement())
            ret.add((StateNode)visit(i));
        return ret;
    }

    @Override
    public BlockNode visitBlock(mxParser.BlockContext ctx) {
        return visitFunctionBody(ctx.functionBody());
    }

    @Override
    public DefState visitDef(mxParser.DefContext ctx) {
        DefState ret = new DefState();
        ret.var = (VariableNode)visit(ctx.variableDefinition());
        return ret;
    }

    @Override
    public ExprState visitExpr(mxParser.ExprContext ctx) {
        ExprState ret = new ExprState();
        ret.expression = (Expr)visit(ctx.expression());
        return ret;
    }

    @Override
    public IfState visitIfst(mxParser.IfstContext ctx) {
        IfState ret = new IfState();
        ret.isnot = (Expr)visit(ctx.ifStatement().expression());
        ret.istrue = (StateNode)visit(ctx.ifStatement().A);
        if (ctx.ifStatement().B != null) ret.isfalse = (StateNode)visit(ctx.ifStatement().B);else ret.isfalse = null;
        return ret;
    }

    @Override
    public WhileState visitWhilest(mxParser.WhilestContext ctx) {
        WhileState ret = new WhileState();
        ret.isnot = (Expr)visit(ctx.whileStatement().expression());
        ret.istrue = (StateNode)visit(ctx.whileStatement().statement());
        return ret;
    }

    @Override
    public ForState visitForst(mxParser.ForstContext ctx) {
        ForState ret = new ForState();
        if (ctx.forStatement().A != null) ret.init = (Expr)visit(ctx.forStatement().A);else ret.init = null;
        if (ctx.forStatement().B != null) ret.isnot = (Expr)visit(ctx.forStatement().B);else ret.isnot = null;
        if (ctx.forStatement().C != null) ret.update = (Expr)visit(ctx.forStatement().C);else ret.update = null;
        ret.doit = (StateNode)visit(ctx.forStatement().statement());
        return ret;
    }

    @Override
    public BreakState visitBreakst(mxParser.BreakstContext ctx) {
        return new BreakState();
    }

    @Override
    public ReturnState visitReturnst(mxParser.ReturnstContext ctx) {
        if (ctx.expression()!=null)
            return new ReturnState((Expr)visit(ctx.expression()));
        return new ReturnState();
    }

    @Override
    public ContinueState visitContinuest(mxParser.ContinuestContext ctx) {
        return new ContinueState();
    }

    @Override
    public ConstExpr visitConst(mxParser.ConstContext ctx) {
        return (ConstExpr)visit(ctx.constant());
    }

    @Override
    public ConstExpr visitNumberconst(mxParser.NumberconstContext ctx) {
        ConstExpr ret = new ConstExpr();
        ret.type = new BasicType("int");
        ret.value = ctx.getText();
        return ret;
    }

    @Override
    public ConstExpr visitStringconst(mxParser.StringconstContext ctx) {
        ConstExpr ret = new ConstExpr();
        ret.type = new ClassType("string");
        ret.value = ctx.getText();
        return ret;
    }

    @Override
    public ConstExpr visitTrueconst(mxParser.TrueconstContext ctx) {
        ConstExpr ret = new ConstExpr();
        ret.type = new BasicType("bool");
        ret.value = ctx.getText();
        return ret;
    }

    @Override
    public ConstExpr visitFalseconst(mxParser.FalseconstContext ctx) {
        ConstExpr ret = new ConstExpr();
        ret.type = new BasicType("bool");
        ret.value = ctx.getText();
        return ret;
    }

    @Override
    public ConstExpr visitNullconst(mxParser.NullconstContext ctx) {
        ConstExpr ret = new ConstExpr();
        ret.type = new NullType();
        ret.value = ctx.getText();
        return ret;
    }

    @Override
    public LeftValueExpr visitVar(mxParser.VarContext ctx) {
        LeftValueExpr ret = new LeftValueExpr();
        ret.add((Expr)visit(ctx.unknown()));
        return ret;
    }

    @Override
    public LeftValueExpr visitLeftValue(mxParser.LeftValueContext ctx) {
        LeftValueExpr ret = new LeftValueExpr();
        Expr tmp = (Expr)visit(ctx.expression());
        if (tmp instanceof LeftValueExpr) {
            ret = (LeftValueExpr)tmp;
        }   else ret.add(tmp);
        ret.add((Expr)visit(ctx.unknown()));
        return ret;
    }

    @Override
    public VarExpr visitVariable(mxParser.VariableContext ctx) {
        VarExpr ret = new VarExpr();
        ret.name = ctx.variableName().getText();
        ret.index = new LinkedList<>();
        for (mxParser.ExpressionContext i : ctx.expression()) {
            ret.index.add((Expr)visit(i));
        }
        return ret;
    }

    @Override
    public Expr visitParentheses(mxParser.ParenthesesContext ctx) {
        return (Expr)visit(ctx.expression());
    }

    @Override
    public PreExpr visitPrefix(mxParser.PrefixContext ctx) {
        PreExpr ret = new PreExpr();
        ret.op = ctx.op.getText();
        ret.a = (Expr)visit(ctx.expression());
        return ret;
    }

    @Override
    public SufExpr visitSuffix(mxParser.SuffixContext ctx) {
        SufExpr ret = new SufExpr();
        ret.op = ctx.op.getText();
        ret.a = (Expr)visit(ctx.expression());
        return ret;
    }

    @Override
    public BinaryExpr visitMul(mxParser.MulContext ctx) {
        BinaryExpr ret = new BinaryExpr();
        ret.a=(Expr)visit(ctx.A);
        ret.op=ctx.op.getText();
        ret.b=(Expr)visit(ctx.B);
        return ret;
    }

    @Override
    public BinaryExpr visitAdd(mxParser.AddContext ctx) {
        BinaryExpr ret = new BinaryExpr();
        ret.a=(Expr)visit(ctx.A);
        ret.op=ctx.op.getText();
        ret.b=(Expr)visit(ctx.B);
        return ret;
    }

    @Override
    public BinaryExpr visitShift(mxParser.ShiftContext ctx) {
        BinaryExpr ret = new BinaryExpr();
        ret.a=(Expr)visit(ctx.A);
        ret.op=ctx.op.getText();
        ret.b=(Expr)visit(ctx.B);
        return ret;
    }

    @Override
    public BinaryExpr visitRelation(mxParser.RelationContext ctx) {
        BinaryExpr ret = new BinaryExpr();
        ret.a=(Expr)visit(ctx.A);
        ret.op=ctx.op.getText();
        ret.b=(Expr)visit(ctx.B);
        return ret;
    }

    @Override
    public BinaryExpr visitEqual(mxParser.EqualContext ctx) {
        BinaryExpr ret = new BinaryExpr();
        ret.a=(Expr)visit(ctx.A);
        ret.op=ctx.op.getText();
        ret.b=(Expr)visit(ctx.B);
        return ret;
    }

    @Override
    public BinaryExpr visitAnd(mxParser.AndContext ctx) {
        BinaryExpr ret = new BinaryExpr();
        ret.a=(Expr)visit(ctx.A);
        ret.op="&";
        ret.b=(Expr)visit(ctx.B);
        return ret;
    }

    @Override
    public BinaryExpr visitOr(mxParser.OrContext ctx) {
        BinaryExpr ret = new BinaryExpr();
        ret.a=(Expr)visit(ctx.A);
        ret.op="|";
        ret.b=(Expr)visit(ctx.B);
        return ret;
    }

    @Override
    public BinaryExpr visitXor(mxParser.XorContext ctx) {
        BinaryExpr ret = new BinaryExpr();
        ret.a=(Expr)visit(ctx.A);
        ret.op="^";
        ret.b=(Expr)visit(ctx.B);
        return ret;
    }

    @Override
    public BinaryExpr visitAnd2(mxParser.And2Context ctx) {
        BinaryExpr ret = new BinaryExpr();
        ret.a=(Expr)visit(ctx.A);
        ret.op="&&";
        ret.b=(Expr)visit(ctx.B);
        return ret;
    }

    @Override
    public BinaryExpr visitOr2(mxParser.Or2Context ctx) {
        BinaryExpr ret = new BinaryExpr();
        ret.a=(Expr)visit(ctx.A);
        ret.op="||";
        ret.b=(Expr)visit(ctx.B);
        return ret;
    }

    @Override
    public AssignExpr visitAssign(mxParser.AssignContext ctx) {
        AssignExpr ret = new AssignExpr();
        ret.l = (LeftValueExpr)visit(ctx.left);
        ret.r = (Expr)visit(ctx.right);
        return ret;
    }

    @Override
    public MallocExpr visitNew(mxParser.NewContext ctx) {
        return (MallocExpr)visit(ctx.malloc());
    }

    @Override
    public MallocExpr visitMalloc(mxParser.MallocContext ctx) {
        return (MallocExpr)visit(ctx.creator());
    }

    @Override
    public MallocExpr visitNewarray(mxParser.NewarrayContext ctx) {
        MallocExpr ret = new MallocExpr();
        ret.stype = (SingleType)visit(ctx.basicType());
        ret.has = new LinkedList<>();
        for (mxParser.ExpressionContext i:ctx.expression()) {
            ret.has.add((Expr)visit(i));
        }
        ret.remain = ctx.empty().size();
        return ret;
    }

    @Override
    public MallocExpr visitNewvarhas(mxParser.NewvarhasContext ctx) {
        MallocExpr ret = new MallocExpr();
        ret.stype = (SingleType)visit(ctx.basicType());
        ret.has = new LinkedList<>();
        ret.remain = 0;
        return ret;
    }

    @Override
    public MallocExpr visitNewvar(mxParser.NewvarContext ctx) {
        MallocExpr ret = new MallocExpr();
        ret.stype = (SingleType)visit(ctx.basicType());
        ret.has = new LinkedList<>();
        ret.remain = 0;
        return ret;
    }

    @Override
    public Expr visitUnknown(mxParser.UnknownContext ctx) {
        if (ctx.variable()!=null)   return visitVariable(ctx.variable());
        if (ctx.function() != null) return visitFunction(ctx.function());
        return null;
    }

    @Override
    public FuncExpr visitFunction(mxParser.FunctionContext ctx) {
        FuncExpr ret = new FuncExpr();
        ret.name = ctx.variableName().getText();
        ret.para = new LinkedList<>();;
        if (ctx.expressionList()!=null) {
            for (mxParser.ExpressionContext i:ctx.expressionList().expression()) {
                ret.para.add((Expr)visit(i));
            }
        }
        return ret;
    }

    @Override
    public EmptyState visitEmptyst(mxParser.EmptystContext ctx) {
        return new EmptyState();
    }
}