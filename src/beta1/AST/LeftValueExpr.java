package beta1.AST;

import java.util.LinkedList;
import java.util.List;

public class LeftValueExpr extends Expr{
    public List<Expr> name; //varexpr | funcexpr

    boolean isleft;

    public LeftValueExpr(){
        name = new LinkedList<>();
    }
    public void add(Expr var) {
        name.add(var);
    }
    @Override
    public void accept(ASTVisitor visitor) throws Exception{
        visitor.visit(this);
    }
}
