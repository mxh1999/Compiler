package beta1.AST;

import beta1.IR.BuildIR;

public abstract class Node {
    public abstract void accept(ASTVisitor visitor) throws Exception;
}
