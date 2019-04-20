package beta1.AST;

public class IndexExpr extends Expr {
    public Expr left;
    public Expr index;

    @Override
    public void accept(ASTVisitor visitor) throws Exception {
        visitor.visit(this);
    }
}
