package beta1.AST;

public class IfState extends StateNode {
    public Expr isnot;
    public StateNode istrue;
    public StateNode isfalse;
    @Override
    public void accept(ASTVisitor visitor) throws Exception{
        visitor.visit(this);
    }
}
