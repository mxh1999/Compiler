package beta1.AST;

public class BinaryExpr extends Expr {
    public Expr a,b;
    public String op;

    @Override
    public void accept(ASTVisitor visitor) throws Exception{
        visitor.visit(this);
    }
}
