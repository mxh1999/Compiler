package beta1.SymbolTable;

import beta1.AST.BasicType;
import beta1.AST.Location;

import java.util.LinkedList;

public class ArrayST extends SymbolTable {
    public ArrayST() {
        super();
        FuncSymbol siz =new FuncSymbol();
        siz.name = "size";
        siz.para = new LinkedList<>();
        siz.returnvalue = new BasicType("int");
        siz.define = null;
        siz.pos = new Location(0,0);
        addFunc("size",siz);
    }
}
