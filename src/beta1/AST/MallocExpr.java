package beta1.AST;

import java.util.LinkedList;
import java.util.List;

public class MallocExpr extends Expr {
    public SingleType stype;
    public List<Expr> has;
    public int remain;

    public MallocExpr() {
        stype = null;
        has = new LinkedList<>();
        remain = 0;
    }
    @Override
    public void accept(ASTVisitor visitor) throws Exception{
        visitor.visit(this);
    }
}
