package beta1.AST;

public class DefState extends StateNode {
    public VariableNode var=null;
    @Override
    public void accept(ASTVisitor visitor) throws Exception{
        visitor.visit(this);
    }
}
