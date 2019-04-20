package beta1.AST;

public class SufExpr extends Expr {
    public String op;
    public Expr a;

    @Override
    public void accept(ASTVisitor visitor) throws Exception{
        visitor.visit(this);
    }
}
