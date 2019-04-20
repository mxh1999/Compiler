package beta1.AST;

public class ContinueState extends StateNode {
    @Override
    public void accept(ASTVisitor visitor) throws Exception{
        visitor.visit(this);
    }
}
