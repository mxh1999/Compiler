package beta1.SymbolTable;

import beta1.AST.*;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class ProgramST extends SymbolTable {
    Map<String, Type> type;
    Map<String, ClassNode> classes;

    private FuncSymbol StrLength() {
        FuncSymbol ret = new FuncSymbol();
        ret.returnvalue = new BasicType("int");
        ret.define = null;
        ret.pos = new Location(0,0);
        ret.name = "length";
        ret.para = new LinkedList<>();
        return ret;
    }
    private FuncSymbol StrSubstring() {
        FuncSymbol ret = new FuncSymbol();
        ret.returnvalue = new ClassType("string");
        ret.define = null;
        ret.pos = new Location(0,0);
        ret.pos = new Location(0,0);
        ret.name = "substring";
        ret.para = new LinkedList<>();
        ret.para.add(new BasicType("int"));
        ret.para.add(new BasicType("int"));
        return ret;
    }
    private FuncSymbol StrParseInt() {
        FuncSymbol ret = new FuncSymbol();
        ret.returnvalue = new BasicType("int");
        ret.define = null;
        ret.pos = new Location(0,0);
        ret.name = "parseInt";
        ret.para = new LinkedList<>();
        return ret;
    }
    private FuncSymbol StrOrd() {
        FuncSymbol ret = new FuncSymbol();
        ret.returnvalue = new BasicType("int");
        ret.define = null;
        ret.pos = new Location(0,0);
        ret.name = "ord";
        ret.para = new LinkedList<>();
        ret.para.add(new BasicType("int"));
        return ret;
    }
    private FuncSymbol ProgPrint() {
        FuncSymbol ret = new FuncSymbol();
        ret.returnvalue = new BasicType("void");
        ret.define = null;
        ret.pos = new Location(0,0);
        ret.name = "print";
        ret.para = new LinkedList<>();
        ret.para.add(new ClassType("string"));
        return ret;
    }
    private FuncSymbol ProgPrintln() {
        FuncSymbol ret = new FuncSymbol();
        ret.returnvalue = new BasicType("void");
        ret.define = null;
        ret.pos = new Location(0,0);
        ret.name = "println";
        ret.para = new LinkedList<>();
        ret.para.add(new ClassType("string"));
        return ret;
    }
    private FuncSymbol ProgGetString() {
        FuncSymbol ret = new FuncSymbol();
        ret.returnvalue = new ClassType("string");
        ret.define = null;
        ret.pos = new Location(0,0);
        ret.name = "getstring";
        ret.para = new LinkedList<>();
        return ret;
    }
    private FuncSymbol ProgGetInt() {
        FuncSymbol ret = new FuncSymbol();
        ret.returnvalue = new BasicType("int");
        ret.define = null;
        ret.pos = new Location(0,0);
        ret.name = "getInt";
        ret.para = new LinkedList<>();
        return ret;
    }
    private FuncSymbol ProgToString() {
        FuncSymbol ret = new FuncSymbol();
        ret.returnvalue = new ClassType("string");
        ret.define = null;
        ret.pos = new Location(0,0);
        ret.name = "toString";
        ret.para = new LinkedList<>();
        ret.para.add(new BasicType("int"));
        return ret;
    }
    public ProgramST() throws Exception {
        super();
        classes = new LinkedHashMap<>();
        type  = new LinkedHashMap<>();
        type.put("int", new BasicType("int"));
        type.put("bool",new BasicType("bool"));
        type.put("void",new BasicType("void"));
        type.put("null",new NullType());
        type.put("string",new ClassType("string"));
        ClassNode str = new ClassNode();
        str.st = new ClassST(this);
        str.st.addVar("this",new ClassType("string"));
        str.construction = null;
        str.st.addFunc("length",StrLength());
        str.st.addFunc("substring",StrSubstring());
        str.st.addFunc("parseInt",StrParseInt());
        str.st.addFunc("ord",StrOrd());
        classes.put("string",str);
        addFunc("print",ProgPrint());
        addFunc("println",ProgPrintln());
        addFunc("getString",ProgGetString());
        addFunc("getInt",ProgGetInt());
        addFunc("toString",ProgToString());
        //todo
    }
    public void addClass(String name, ClassNode node) throws Exception{
        if (funcs.containsKey(name) || vars.containsKey(name) || classes.containsKey(name)) throw new Exception("the same name");
        type.put(name,new ClassType(name));
        classes.put(name,node);
    }
    public ClassNode findClass(String name) throws Exception{
        if (!classes.containsKey(name)) throw new Exception("no such class");
        return classes.get(name);
    }
    public boolean haveClass(String name) {
        return classes.containsKey(name);
    }
    public void addFunc(String name, FuncSymbol fun) throws Exception {
        if (classes.containsKey(name)) throw new Exception("the same name");
        super.addFunc(name,fun);
    }
    public void addVar(String name, Type type) throws Exception {
        if (classes.containsKey(name)) throw new Exception("the same name");
        super.addVar(name,type);
    }
}
