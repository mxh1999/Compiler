package beta1.SymbolTable;

import beta1.AST.Type;
import beta1.AST.VariableNode;

import java.util.LinkedHashMap;
import java.util.Map;

public class SymbolTable {
    public Map<String, VariableNode> vardef;
    public Map<String, FuncSymbol> funcs;
    public Map<String, Type> vars;
    SymbolTable father;

    public SymbolTable() {
        vardef = new LinkedHashMap<>();
        funcs = new LinkedHashMap<>();
        vars = new LinkedHashMap<>();
        father = null;
    }
    public SymbolTable(SymbolTable fa) {
        vardef = new LinkedHashMap<>();
        funcs = new LinkedHashMap<>();
        vars = new LinkedHashMap<>();
        father = fa;
    }

    public void addFunc(String name, FuncSymbol fun) throws Exception{
        if (funcs.containsKey(name) || vars.containsKey(name)) throw new Exception("the same name");
        funcs.put(name,fun);
    }
    public FuncSymbol getFunc(String name) throws Exception{
        if (!funcs.containsKey(name)) throw new Exception("no such function");
        return funcs.get(name);
    }
    public void addVar(String name, Type type) throws Exception {
        if (funcs.containsKey(name) || vars.containsKey(name)) throw new Exception("the same name");
        vars.put(name,type);
    }
    public Type getVar(String name) throws Exception{
        if (!vars.containsKey(name)) throw new Exception("no such variable");
        return vars.get(name);
    }
    public boolean haveVar(String name) {
        return vars.containsKey(name);
    }
    public boolean haveFunc(String name) {
        return funcs.containsKey(name);
    }
    public void addVardef(String name, VariableNode def) {
        vardef.put(name,def);
    }
    public VariableNode getVardef(String name) {
        return vardef.get(name);
    }
}
