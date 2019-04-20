package beta1.AST;

public class ConstExpr extends Expr {
    public String value;

    @Override
    public void accept(ASTVisitor visitor) throws Exception{
        visitor.visit(this);
    }
}
