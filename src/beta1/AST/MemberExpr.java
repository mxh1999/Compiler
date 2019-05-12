package beta1.AST;

import java.util.LinkedList;
import java.util.List;

public class MemberExpr extends Expr {
    public Expr left;
    public String name;
    public VariableNode define;

    public MemberExpr() {
        left = null;
        define = null;
    }

    @Override
    public void accept(ASTVisitor visitor) throws Exception {
        visitor.visit(this);
    }
}
