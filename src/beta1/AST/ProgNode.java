package beta1.AST;

import java.util.LinkedList;
import java.util.List;

public class ProgNode extends Node {
    public List<ClassNode> classlist;
    public List<FuncNode> funclist;
    public List<VariableNode> variablelist;

    public ProgNode() {
        classlist = new LinkedList<>();
        funclist = new LinkedList<>();
        variablelist = new LinkedList<>();
    }
    public void add(ClassNode x){
        classlist.add(x);
    }
    public void add(FuncNode x){
        funclist.add(x);
    }
    public void add(VariableNode x){
        variablelist.add(x);
    }
    @Override
    public void accept(ASTVisitor visitor) throws Exception{
        visitor.visit(this);
    }
}
