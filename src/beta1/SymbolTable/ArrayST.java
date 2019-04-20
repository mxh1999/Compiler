package beta1.SymbolTable;

import beta1.AST.BasicType;

import java.util.LinkedList;

public class ArrayST extends SymbolTable {
    public ArrayST() {
        super();
        FuncSymbol siz =new FuncSymbol();
        siz.name = "size";
        siz.para = new LinkedList<>();
        siz.returnvalue = new BasicType("int");
        siz.define = null;
        addFunc("size",siz);
    }
}
