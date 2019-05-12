package beta1.AST;

import java.util.List;

public class VarExpr extends Expr {
    public String name;
    public VariableNode define;
    @Override
    public void accept(ASTVisitor visitor) throws Exception{
        visitor.visit(this);
    }
}
