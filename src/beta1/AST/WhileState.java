package beta1.AST;

public class WhileState extends StateNode {
    public Expr isnot;
    public StateNode istrue;
    @Override
    public void accept(ASTVisitor visitor) throws Exception{
        visitor.visit(this);
    }
}
