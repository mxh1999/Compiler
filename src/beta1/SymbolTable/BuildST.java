package beta1.SymbolTable;

import beta1.AST.*;

import java.util.LinkedList;

public class BuildST implements ASTVisitor {
    public ProgramST global;
    public SymbolTable local;
    public ArrayST arrayst;

    public BuildST() throws Exception {
        global = new ProgramST();
        local = global;
        arrayst = new ArrayST();
    }

    public void checkmain() throws Exception {

    }

    private FuncSymbol ConstructionToST(FuncNode node) {
        FuncSymbol ret = new FuncSymbol();
        ret.name=node.name;
        ret.returnvalue = new BasicType("void");
        ret.define = node;
        ret.para = new LinkedList<>();
        for (VariableNode i:node.para) {
            ret.para.add(i.type);
        }
        return ret;
    }
    @Override
    public void visit(ProgNode node) throws Exception {
        for (ClassNode i : node.classlist) {
            visit(i);
        }
        for (FuncNode i : node.funclist) {
            visit(i);
        }
    }

    @Override
    public void visit(ClassNode node) throws Exception {
        global.addClass(node.name,node);
        node.st = new ClassST(local);
        node.st.addVar("this",new ClassType(node.name));
        local = node.st;
        for (VariableNode i:node.member) {
            visit(i);
        }
        if (node.construction != null) {
            node.st.construction = ConstructionToST(node.construction);
        }
        for (FuncNode i : node.method) {
            visit(i);
        }
        local = local.father;
    }

    @Override
    public void visit(VariableNode node) throws Exception {
        local.addVar(node.name,node.type);
    }

    @Override
    public void visit(FuncNode node) throws Exception {
        FuncSymbol ret = new FuncSymbol();
        ret.name = node.name;
        ret.returnvalue = node.returnvalue;
        ret.define = node;
        ret.para = new LinkedList<>();
        for (VariableNode i:node.para) {
            ret.para.add(i.type);
        }
        local.addFunc(node.name,ret);
    }

    //============empty line==========================
    @Override
    public void visit(IfState node) {

    }

    @Override
    public void visit(PreExpr node) {

    }

    @Override
    public void visit(SufExpr node) {

    }

    @Override
    public void visit(VarExpr node) {

    }

    @Override
    public void visit(DefState node) {

    }

    @Override
    public void visit(ForState node) {

    }

    @Override
    public void visit(FuncExpr node) {

    }

    @Override
    public void visit(BlockNode node) {

    }

    @Override
    public void visit(ConstExpr node) {

    }

    @Override
    public void visit(ExprState node) {

    }

    @Override
    public void visit(AssignExpr node) {

    }

    @Override
    public void visit(BinaryExpr node) {

    }

    @Override
    public void visit(BreakState node) {

    }

    @Override
    public void visit(MallocExpr node) {

    }

    @Override
    public void visit(WhileState node) {

    }

    @Override
    public void visit(ReturnState node) {

    }

    @Override
    public void visit(ContinueState node) {

    }

    @Override
    public void visit(LeftValueExpr node) {

    }

    @Override
    public void visit(EmptyState node) {

    }
}
