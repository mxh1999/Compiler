package beta1.AST;

import beta1.IR.FuncIR;

import java.util.LinkedList;
import java.util.List;

public class FuncNode extends Node {
    public Type returnvalue = null;
    public String name = null;
    public List<VariableNode> para;
    public BlockNode body;

    public String global_name = null;
    public ClassNode belong;
    public boolean ismethod;

    public FuncNode() {
        returnvalue = new BasicType("void");
        name = "";
        para = new LinkedList<>();
        body = new BlockNode();
    }
    public FuncNode(String _name) {
        returnvalue = new BasicType("void");
        name = _name;
        para = new LinkedList<>();
        body = new BlockNode();
    }
    @Override
    public void accept(ASTVisitor visitor) throws Exception{
        visitor.visit(this);
    }
}
