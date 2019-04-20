package beta1.AST;

public class EmptyState extends StateNode {

    @Override
    public void accept(ASTVisitor visitor) throws Exception {
        visitor.visit(this);
    }
}
