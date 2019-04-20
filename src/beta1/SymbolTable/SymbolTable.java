package beta1.SymbolTable;

import beta1.AST.Type;
import beta1.AST.VariableNode;

import java.util.LinkedHashMap;
import java.util.Map;

public class SymbolTable {
    public Map<String, FuncSymbol> funcs;
    public Map<String, Type> vars;
    SymbolTable father;

    public SymbolTable() {
        funcs = new LinkedHashMap<>();
        vars = new LinkedHashMap<>();
        father = null;
    }
    public SymbolTable(SymbolTable fa) {
        funcs = new LinkedHashMap<>();
        vars = new LinkedHashMap<>();
        father = fa;
    }

    public void addFunc(String name, FuncSymbol fun) {
        funcs.put(name,fun);
    }
    public FuncSymbol getFunc(String name) {
        return funcs.get(name);
    }
    public void addVar(String name, Type type) {
        vars.put(name,type);
    }
    public Type getVar(String name) {
        return vars.get(name);
    }
    public boolean haveVar(String name) {
        return vars.containsKey(name);
    }
    public boolean haveFunc(String name) {
        return funcs.containsKey(name);
    }
}
