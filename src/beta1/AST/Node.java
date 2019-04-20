package beta1.AST;

public abstract class Node {
    public abstract void accept(ASTVisitor visitor) throws Exception;
}
