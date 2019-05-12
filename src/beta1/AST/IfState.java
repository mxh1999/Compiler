package beta1.AST;

public class IfState extends StateNode {
    public Expr isnot;
    public BlockNode istrue;
    public BlockNode isfalse;
    @Override
    public void accept(ASTVisitor visitor) throws Exception{
        visitor.visit(this);
    }
}
