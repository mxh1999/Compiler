package beta1.AST;

public class AssignExpr extends Expr {
    public Expr l;
    public Expr r;
    @Override
    public void accept(ASTVisitor visitor) throws Exception{
        visitor.visit(this);
    }
}
