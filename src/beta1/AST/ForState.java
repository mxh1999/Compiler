package beta1.AST;

public class ForState extends StateNode {
    public Expr init,isnot,update;
    public BlockNode doit;
    @Override
    public void accept(ASTVisitor visitor) throws Exception{
        visitor.visit(this);
    }
}
