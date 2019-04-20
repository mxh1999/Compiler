package beta1.AST;

public class ReturnState extends StateNode {
    public Expr ret;
    public Type returnvalue;
    public ReturnState() {
        ret = null;
        returnvalue = null;
    }
    public ReturnState(Expr _ret) {
        ret = _ret;
    }
    @Override
    public void accept(ASTVisitor visitor) throws Exception{
        visitor.visit(this);
    }
}
