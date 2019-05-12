package beta1.AST;

import beta1.parser.mxParser;

public class VariableNode extends Node {
    public Type type = null;
    public String name = null;
    public Expr init = null;

    public VariableNode(){}
    public VariableNode(Type _type,String _name,Expr _init) {
        type=_type;
        name=_name;
        init=_init;
    }

    public boolean isglobal;
    public boolean ismember;

    public ClassNode belong;
    @Override
    public void accept(ASTVisitor visitor) throws Exception{
        visitor.visit(this);
    }
}
