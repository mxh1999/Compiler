package beta1.AST;

public interface ASTVisitor {
    void visit(ProgNode node) throws Exception;

    void visit(ClassNode node) throws Exception;
    void visit(VariableNode node) throws Exception;
    void visit(FuncNode node) throws Exception;

    void visit(BlockNode node) throws Exception;
    void visit(DefState node) throws Exception;
    void visit(ExprState node) throws Exception;
    void visit(IfState node) throws Exception;
    void visit(WhileState node) throws Exception;
    void visit(ForState node) throws Exception;
    void visit(BreakState node) throws Exception;
    void visit(ReturnState node) throws Exception;
    void visit(ContinueState node) throws Exception;
    void visit(EmptyState node) throws Exception;

    void visit(BinaryExpr node) throws Exception;
    void visit(ConstExpr node) throws Exception;
    void visit(FuncExpr node) throws Exception;
    void visit(VarExpr node) throws Exception;
    void visit(LeftValueExpr node) throws Exception;
    void visit(PreExpr node) throws Exception;
    void visit(SufExpr node) throws Exception;
    void visit(AssignExpr node) throws Exception;
    void visit(MallocExpr node) throws Exception;
}
