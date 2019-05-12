package beta1.AST;

import beta1.SymbolTable.ClassST;

import java.util.LinkedList;
import java.util.List;

public class ClassNode extends Node{
    public String name;
    public List<VariableNode> member;
    public List<FuncNode> method;
    public FuncNode construction;

    public ClassST st;

    public ClassNode() {
        name = null;
        member = new LinkedList<>();
        method = new LinkedList<>();
        construction = null;
        st = null;
    }
    @Override
    public void accept(ASTVisitor visitor) throws Exception{
        visitor.visit(this);
    }

    public int getoffset(String name) {
        int ret = 0;
        for (VariableNode i:member) {
            ret += 8;
            if (i.name.equals(name)) return ret;
        }
        return 0;
    }
}
