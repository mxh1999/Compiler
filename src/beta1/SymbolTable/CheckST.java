package beta1.SymbolTable;

import beta1.AST.*;

import java.util.LinkedHashSet;
import java.util.Set;

public class CheckST implements ASTVisitor {
    public ProgramST global;
    public SymbolTable local;
    public SymbolTable arrayst;

    private Set<String> reserved;

    private Funclist lastfunc;
    private Forlist lastfor;

    public CheckST(BuildST tmp) {
        global = tmp.global;
        local = global;
        lastfunc = null;
        lastfor = null;
        arrayst = tmp.arrayst;
        reserved = new LinkedHashSet<>();
        reserved.add("bool");
        reserved.add("int");
        reserved.add("string");
        reserved.add("null");
        reserved.add("void");
        reserved.add("true");
        reserved.add("false");
        reserved.add("if");
        reserved.add("for");
        reserved.add("while");
        reserved.add("break");
        reserved.add("continue");
        reserved.add("return");
        reserved.add("new");
        reserved.add("class");
        reserved.add("this");
    }

    @Override
    public void visit(ProgNode node) throws Exception {
        for (Node i : node.all) {
            i.accept(this);
        }
    }

    @Override
    public void visit(ClassNode node) throws Exception {
        if (reserved.contains(node.name)) throw new Exception("reserved word can't be name");
        local = node.st;
        if (node.construction != null) {
            visit(node.construction);
            if (!node.construction.name.equals(node.name)) throw new Exception("Construction name error");
        }
        for (FuncNode i:node.method) {
            visit(i);
        }
        local=local.father;
    }

    public boolean checkType(Type type) {
        if (type instanceof ClassType) {
            return global.haveClass(((ClassType) type).name);
        }
        return true;
    }

    @Override
    public void visit(FuncNode node) throws Exception {
        if (reserved.contains(node.name)) throw new Exception("reserved word can't be name");
        lastfunc = new Funclist(lastfunc);
        lastfor = new Forlist(lastfor);
        lastfunc.now=node;
        if (node.body.st == null) {
            node.body.st = new SymbolTable(local);
        }
        if (!checkType(node.returnvalue))   throw new Exception("no such type");
        local = node.body.st;
        for (VariableNode i:node.para) {
            visit(i);
        }
        local = local.father;
        visit(node.body);
        lastfunc = lastfunc.father;
        lastfor = lastfor.father;
    }

    @Override
    public void visit(VariableNode node) throws Exception {
        if (reserved.contains(node.name)) throw new Exception("reserved word can't be name");
        if (node.type.ac(new BasicType("void")) || node.type instanceof NullType) throw new Exception("Variable can't be void");
        if (node.init != null) {
            node.init.accept(this);
            if (!node.type.ac(node.init.type))  throw new Exception("Type not match");
        }
        if (!checkType(node.type)) throw new Exception("no such type");
        local.addVar(node.name,node.type);
        local.addVardef(node.name,node);
    }

    @Override
    public void visit(BlockNode node) throws Exception{
        if (node.st == null) {
            node.st = new SymbolTable(local);
        }
        local = node.st;
        for (StateNode i:node.statement) {
            i.accept(this);
        }
        local = local.father;
    }

    @Override
    public void visit(DefState node) throws Exception {
        if (node.var != null) visit(node.var);
    }

    @Override
    public void visit(ExprState node) throws Exception{
        if (node.expression!=null)  node.expression.accept(this);
    }

    @Override
    public void visit(IfState node) throws Exception {
        if (node.isnot != null) {
            node.isnot.accept(this);
        }   else throw new Exception("If expression is empty");
        if (!node.isnot.type.ac(new BasicType("bool"))) throw new Exception("If expression should be bool");
        if (node.istrue != null) {
            node.istrue.accept(this);
        }
        if (node.isfalse != null) {
            node.isfalse.accept(this);
        }
    }

    @Override
    public void visit(WhileState node) throws Exception{
        lastfor = new Forlist(lastfor);
        lastfor.now = node;
        if (node.isnot != null) {
            node.isnot.accept(this);
        }   else throw new Exception("While expression is empty");
        if (!node.isnot.type.ac(new BasicType("bool"))) throw new Exception("Type not match");
        if (node.istrue!=null) {
            node.istrue.accept(this);
        }
        lastfor = lastfor.father;
    }

    @Override
    public void visit(ForState node) throws Exception{
        lastfor = new Forlist(lastfor);
        lastfor.now = node;
        if (node.init != null) node.init.accept(this);
        if (node.isnot != null) {
            node.isnot.accept(this);
            if (!node.isnot.type.ac(new BasicType("bool"))) throw new Exception("Conditional is not bool");
        }
        if (node.update != null) {
            node.update.accept(this);
        }
        if (node.doit != null) node.doit.accept(this);
        lastfor = lastfor.father;
    }

    @Override
    public void visit(BreakState node) throws Exception{
        if (lastfor.now==null)  throw new Exception("no loop to break");
    }

    @Override
    public void visit(ContinueState node) throws Exception{
        if (lastfor.now == null) throw new Exception("no loop to continue");
    }

    @Override
    public void visit(ReturnState node) throws Exception{
        if (lastfunc.now == null) throw new Exception("no function to return");
        if (node.ret != null) {
            node.ret.accept(this);
            if (!lastfunc.now.returnvalue.ac(node.ret.type)) throw new Exception("Type not match");
        }   else {
            if (!lastfunc.now.returnvalue.ac(new BasicType("void"))) throw new Exception("Type not match");
        }
    }

    @Override
    public void visit(BinaryExpr node) throws Exception{
        node.a.accept(this);
        node.b.accept(this);
        node.isleft = false;
        if (!node.a.type.ac(node.b.type)) throw new Exception("Type not match");
        if (node.op.equals("+")) {
            if (!node.a.type.ac(new BasicType("int")) && !node.a.type.ac(new ClassType("string"))) throw new Exception("Type not match");
            node.type = node.a.type;
        }
        if (node.op.equals("-") || node.op.equals("*") || node.op.equals("/") || node.op.equals("%") || node.op.equals("<<") || node.op.equals(">>") || node.op.equals("&") || node.op.equals("|")) {
            if (!node.a.type.ac(new BasicType("int"))) throw new Exception("Type not match");
            node.type = node.a.type;
        }
        if (node.op.equals(">") || node.op.equals(">=") || node.op.equals("<") || node.op.equals("<=")) {
            if (!node.a.type.ac(new BasicType("int")) && !node.a.type.ac(new BasicType("bool")) && !node.a.type.ac(new ClassType("string"))) throw new Exception("Type not match");
            node.type = new BasicType("bool");
        }
        if (node.op.equals("!=") || node.op.equals("==")) {
            node.type = new BasicType("bool");
        }
        if (node.op.equals("&&") || node.op.equals("||")) {
            if (!node.a.type.ac(new BasicType("bool"))) throw new Exception("Type not match");
            node.type = new BasicType("bool");
        }
        if (node.op.equals("^")) {
            if (!node.a.type.ac(new BasicType("bool")) && !node.a.type.ac(new BasicType("int"))) throw new Exception("Type not match");
            node.type = node.a.type;
        }
        /*there're lots of errors to set*/
    }

    @Override
    public void visit(ConstExpr node) {
        node.isleft = false;
    }

    @Override
    public void visit(SufExpr node) throws Exception{
        if (node.a!=null)   node.a.accept(this);else throw new Exception("no object to operate");
        if (!node.a.type.ac(new BasicType("int"))) throw new Exception("Type not match");
        if (!node.a.isleft) throw new Exception("RightValue can't have suffix operator");
        node.type = node.a.type;
        node.isleft = false;
    }

    @Override
    public void visit(PreExpr node) throws Exception{
        if (node.a!=null)   node.a.accept(this);else throw new Exception("no object to operate");
        if (node.op.equals("--") || node.op.equals("++")) {
            if (!node.a.isleft) throw new Exception("RightValue can't -- or ++");
            if (!node.a.type.ac(new BasicType("int"))) throw new Exception("Type not match");
            node.isleft = node.a.isleft;
        }
        if (node.op.equals("-") || node.op.equals("~")) {
            if (!node.a.type.ac(new BasicType("int"))) throw new Exception("Type not match");
            node.isleft = false;
        }
        if (node.op.equals("!")) {
            if (!node.a.type.ac(new BasicType("bool"))) throw new Exception("Type not match");
            node.isleft = false;
        }
        node.type=node.a.type;
    }

    @Override
    public void visit(VarExpr node) throws Exception{
        SymbolTable now = local;
        while (!now.haveVar(node.name)) {
            if (now.father == null) throw new Exception("no such variable");
            now = now.father;
        }
        node.type = now.getVar(node.name);
        node.define = now.getVardef(node.name);
        node.isleft = true;
        if (node.name.equals("this")) node.isleft = false;
    }

    @Override
    public void visit(AssignExpr node) throws Exception{
        node.l.accept(this);
        if (!node.l.isleft) throw new Exception("RightValue cannot assign");
        node.r.accept(this);
        if (!node.l.type.ac(node.r.type)) throw new Exception("Type not match");
        node.type = node.l.type;
        node.isleft = false;
    }

    @Override
    public void visit(MallocExpr node) throws Exception{
        node.isleft = false;//?????
        if (!checkType(node.stype)) throw new Exception("no such type");
        if (node.stype.ac(new BasicType("void")))   throw new Exception("void can't new");
        for (Expr i:node.has) {
            i.accept(this);
            if (!i.type.ac(new BasicType("int"))) throw new Exception("Index should be a int");
        }
        if (node.has.size()+node.remain == 0) {
            node.type = node.stype;
        }   else {
            node.type = new ArrayType(node.stype,node.has.size()+node.remain);
        }
    }

    @Override
    public void visit(FuncExpr node) throws Exception{
        node.isleft = false;
        SymbolTable now = local;
        while (!now.haveFunc(node.name)) {
            if (now.father == null) throw new Exception("no such function");
            now = now.father;
        }
        FuncSymbol ret= now.getFunc(node.name);
        for (Expr i:node.para) {
            i.accept(this);
        }
        if (ret.para.size() != node.para.size()) throw new Exception("parameter number error");
        for (int i=0;i<node.para.size();i++) {
            node.para.get(i).accept(this);
            if (!ret.para.get(i).ac(node.para.get(i).type)) throw new Exception("parameter type error");
        }
        node.type = ret.returnvalue;
    }

    @Override
    public void visit(EmptyState node) throws Exception {

    }

    @Override
    public void visit(IndexExpr node) throws Exception {
        node.left.accept(this);
        node.index.accept(this);
        if (!(node.left.type instanceof ArrayType)) throw new Exception("Can't have index");
        if (!node.index.type.ac(new BasicType("int"))) throw new Exception("Index shoule be a int");
        node.type = new ArrayType((ArrayType)node.left.type);
        ((ArrayType) node.type).dimension--;
        if (((ArrayType) node.type).dimension==0) node.type = ((ArrayType) node.type).base;
        node.isleft = node.left.isleft;
    }

    @Override
    public void visit(MemberExpr node) throws Exception {
        node.left.accept(this);
        if (!(node.left.type instanceof ClassType)) throw new Exception("no such member");
        SymbolTable now = global.getClass(((ClassType) node.left.type).name).st;
        node.type = now.getVar(node.name);
        node.define = now.getVardef(node.name);
        node.isleft = true;//node.left.isleft;
    }

    @Override
    public void visit(MethodExpr node) throws Exception {
        node.left.accept(this);
        SymbolTable now;
        if (node.left.type instanceof ArrayType) now = arrayst; else {
            if (!(node.left.type instanceof ClassType)) throw new Exception("no such method");
            now = global.getClass(((ClassType) node.left.type).name).st;
        }
        FuncSymbol ret = now.getFunc(node.name);
        node.type = ret.returnvalue;
        node.isleft = false;
        for (Expr i:node.para) {
            i.accept(this);
        }
        if (ret.para.size() != node.para.size()) throw new Exception("parameter number error");
        for (int i=0;i<node.para.size();i++) {
            node.para.get(i).accept(this);
            if (!ret.para.get(i).ac(node.para.get(i).type)) throw new Exception("parameter type error");
        }
    }
}