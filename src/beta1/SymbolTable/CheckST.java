package beta1.SymbolTable;

import beta1.AST.*;

public class CheckST implements ASTVisitor {
    public ProgramST global;
    public SymbolTable local;
    public SymbolTable arrayst;

    private Funclist lastfunc;
    private Forlist lastfor;

    public CheckST(BuildST tmp) {
        global = tmp.global;
        local = global;
        lastfunc = null;
        lastfor = null;
        arrayst = tmp.arrayst;
    }

    @Override
    public void visit(ProgNode node) throws Exception {
        for (Node i : node.all) {
            i.accept(this);
        }
    }

    @Override
    public void visit(ClassNode node) throws Exception {
        local = node.st;
        if (node.construction != null) {
            visit(node.construction);
        }
        for (FuncNode i:node.method) {
            visit(i);
        }
        local=local.father;
    }

    @Override
    public void visit(FuncNode node) throws Exception {
        lastfunc = new Funclist(lastfunc);
        lastfor = new Forlist(lastfor);
        lastfunc.now=node;
        if (node.body.st == null) {
            node.body.st = new SymbolTable(local);
        }
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
        if (node.type.ac(new BasicType("void")) || node.type instanceof NullType) throw new Exception("Variable can't be void");
        if (node.init != null) {
            node.init.accept(this);
            if (!node.type.ac(node.init.type))  throw new Exception("Type not match");
        }
        local.addVar(node.name,node.type);
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
        node.isleft = node.a.isleft;
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

    public void getGlobalVar(VarExpr node) throws Exception{
        SymbolTable now = local;
        while (!now.haveVar(node.name)) {
            if (now.father == null) throw new Exception("no such variable");
            now = now.father;
        }
        node.type = now.getVar(node.name);
        node.isleft = true;
        if (!node.index.isEmpty()) {
            if (!(node.type instanceof ArrayType))  throw new Exception("BasicType can't have index");
            if (((ArrayType) node.type).dimension < node.index.size()) throw new Exception("Too many index");
            for (Expr i:node.index) {
                i.accept(this);
                if (!i.type.ac(new BasicType("int"))) throw new Exception("Index should be a int");
            }
            node.type = new ArrayType((ArrayType)node.type);
            ((ArrayType) node.type).dimension -= node.index.size();
            if (((ArrayType) node.type).dimension == 0) {
                node.type = ((ArrayType) node.type).base;
            }
        }
    }

    public void getGlobalFunc(FuncExpr node) throws Exception{
        SymbolTable now = local;
        node.isleft =false;
        while (!now.haveFunc(node.name)) {
            if (now.father == null) throw new Exception("no such function");
            now = now.father;
        }
        FuncSymbol ret= now.getFunc(node.name);
        if (ret.para.size() != node.para.size()) throw new Exception("parameter number error");
        for (int i=0;i<node.para.size();i++) {
            node.para.get(i).accept(this);
            if (!ret.para.get(i).ac(node.para.get(i).type)) throw new Exception("parameter type error");
        }
        node.type=ret.returnvalue;
    }

    @Override
    public void visit(LeftValueExpr node) throws Exception{
        if (node.name.isEmpty()) throw new Exception("no variable name");
        SymbolTable now = local;
        node.isleft =true;
        for (int i=0;i<node.name.size()-1;i++) {
            if (i>0){
                if (node.name.get(i) instanceof VarExpr) {
                    visit((VarExpr)node.name.get(i),now);
                } else {
                    visit((FuncExpr)node.name.get(i),now);
                }
            }else {
                if (node.name.get(i) instanceof VarExpr) getGlobalVar((VarExpr)node.name.get(i));else getGlobalFunc((FuncExpr)node.name.get(i));
            }
            node.isleft &= node.name.get(i).isleft;
            Type tp = node.name.get(i).type;
            if (tp instanceof ArrayType) {
                now = arrayst;
            }   else {
                if (!(tp instanceof ClassType)) throw new Exception("No such member");
                now = global.findClass(((ClassType) tp).name).st;
            }
        }
        if (node.name.size()==1) {
            if (node.name.get(0) instanceof VarExpr) getGlobalVar((VarExpr)node.name.get(0));else getGlobalFunc((FuncExpr)node.name.get(0));
            node.type = node.name.get(0).type;
            node.isleft &= node.name.get(0).isleft;
        }   else {
            if (node.name.get(node.name.size()-1) instanceof VarExpr) visit((VarExpr)node.name.get(node.name.size()-1),now);else visit((FuncExpr)node.name.get(node.name.size()-1),now);
            node.type = node.name.get(node.name.size()-1).type;
            node.isleft &= node.name.get(node.name.size()-1).isleft;
        }
    }

    public void visit(VarExpr node,SymbolTable now) throws Exception{
        node.type = now.getVar(node.name);
        node.isleft = true;
        if (!node.index.isEmpty()) {
            if (!(node.type instanceof ArrayType))  throw new Exception("BasicType can't have index");
            if (((ArrayType) node.type).dimension < node.index.size()) throw new Exception("Too many index");
            for (Expr i:node.index) {
                i.accept(this);
                if (!i.type.ac(new BasicType("int"))) throw new Exception("Index should be a int");
            }
            node.type = new ArrayType((ArrayType)node.type);
            ((ArrayType) node.type).dimension -= node.index.size();
            if (((ArrayType) node.type).dimension == 0) {
                node.type = ((ArrayType) node.type).base;
            }
        }
    }

    @Override
    public void visit(VarExpr node) throws Exception{
        node.type = local.getVar(node.name);
        node.isleft = true;
        if (!node.index.isEmpty()) {
            if (!(node.type instanceof ArrayType))  throw new Exception("BasicType can't have index");
            if (((ArrayType) node.type).dimension < node.index.size()) throw new Exception("Too many index");
            for (Expr i:node.index) {
                i.accept(this);
                if (!i.type.ac(new BasicType("int"))) throw new Exception("Index should be a int");
            }
            node.type = new ArrayType((ArrayType)node.type);
            ((ArrayType) node.type).dimension -= node.index.size();
            if (((ArrayType) node.type).dimension == 0) {
                node.type = ((ArrayType) node.type).base;
            }
        }
    }

    @Override
    public void visit(AssignExpr node) throws Exception{
        visit(node.l);
        if (!node.l.isleft) throw new Exception("RightValue cannot assign");
        node.r.accept(this);
        if (!node.l.type.ac(node.r.type)) throw new Exception("Type not match");
        node.type = node.l.type;
        node.isleft = false;
    }

    @Override
    public void visit(MallocExpr node) throws Exception{
        node.isleft = false;//?????
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

    public void visit(FuncExpr node,SymbolTable now) throws Exception{
        node.isleft = false;
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
    public void visit(FuncExpr node) throws Exception{
        node.isleft = false;
        FuncSymbol ret= local.getFunc(node.name);
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
}