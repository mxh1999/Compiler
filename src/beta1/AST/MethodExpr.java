package beta1.AST;

import java.util.LinkedList;
import java.util.List;

public class MethodExpr extends Expr {
    public Expr left;
    public String name;
    public List<Expr> para;

    public MethodExpr() {
        left = null;
        para = new LinkedList<>();
    }
    @Override
    public void accept(ASTVisitor visitor) throws Exception {
        visitor.visit(this);
    }
}
