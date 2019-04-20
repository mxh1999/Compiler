package beta1.SymbolTable;


import beta1.AST.StateNode;

public class Forlist {
    public StateNode now;
    public Forlist father;

    public Forlist(){
        now = null;
        father = null;
    }
    public Forlist(Forlist fa) {
        now = null;
        father = fa;
    }
}
