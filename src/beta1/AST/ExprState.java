package beta1.AST;

public class ExprState extends StateNode{
    public Expr expression = null;
    @Override
    public void accept(ASTVisitor visitor) throws Exception{
        visitor.visit(this);
    }
}
