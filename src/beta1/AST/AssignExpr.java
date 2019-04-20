package beta1.AST;

public class AssignExpr extends Expr {
    public LeftValueExpr l;
    public Expr r;
    @Override
    public void accept(ASTVisitor visitor) throws Exception{
        visitor.visit(this);
    }
}
