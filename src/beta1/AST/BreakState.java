package beta1.AST;

public class BreakState extends StateNode {
    @Override
    public void accept(ASTVisitor visitor) throws Exception{
        visitor.visit(this);
    }
}
