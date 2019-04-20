package beta1.AST;

import java.util.List;

public class FuncExpr extends Expr{
    public String name;
    public List<Expr> para;
    @Override
    public void accept(ASTVisitor visitor) throws Exception{
        visitor.visit(this);
    }
}
