package beta1.SymbolTable;

import beta1.AST.FuncNode;
import beta1.AST.Location;
import beta1.AST.Type;

import java.util.List;

public class FuncSymbol {
    public String name;
    public FuncNode define;
    public Location pos;
    public Type returnvalue;
    public List<Type> para;
}
