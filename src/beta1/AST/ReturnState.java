package beta1.AST;

public class ReturnState extends StateNode {
    public Expr ret;
    public ReturnState() {
        ret = null;
    }
    public ReturnState(Expr _ret) {
        ret = _ret;
    }
    @Override
    public void accept(ASTVisitor visitor) throws Exception{
        visitor.visit(this);
    }
}
