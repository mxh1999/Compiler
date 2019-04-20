package beta1.AST;

public abstract class Node {
    public Location pos = null;
    public abstract void accept(ASTVisitor visitor) throws Exception;
}
