package beta1.SymbolTable;

import beta1.AST.FuncNode;

public class Funclist {
    public FuncNode now;
    public Funclist father;

    public Funclist() {
        now = null;
        father = null;
    }
    public Funclist(Funclist fa) {
        now = null;
        father = fa;
    }
}
