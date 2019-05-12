package beta1.IR;

import beta1.AST.ClassNode;
import beta1.AST.FuncNode;
import beta1.AST.VariableNode;
import beta1.IR.Quad.Alloc;
import beta1.IR.Quad.Quad;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class IRContext {
    public ProgramIR global = new ProgramIR();
    public Map<VariableNode,RegIR> vars=new LinkedHashMap<>();
    public Map<String, ClassNode> classes= new LinkedHashMap<>();
    public Map<String, FuncNode> func = new LinkedHashMap<>();
    public FuncIR local = null;

    public FuncIR newFunc(String name) {
        FuncIR func =new FuncIR(name);
        global.funcs.put(name,func);
        return func;
    }

    public Set<BlockIR> stop = new LinkedHashSet<>();
    public void addQuad(Quad tmp) {
        tmp.blk = local.now;
        if (stop.contains(tmp.blk)) return;
        if (tmp instanceof Alloc) {
            local.addVar(((Alloc)tmp).addr);
            tmp.blk = local.blks.get(0);
            tmp.blk.quads.add(0,tmp);
        }   else {
            local.now.quads.add(tmp);
        }
    }

    public Map<RegIR,String> csval = new LinkedHashMap<>();
    public Map<String,RegIR> csdef = new LinkedHashMap<>();
    static private int cs_num;
    RegIR getConstString(String val1) {
        String val = val1.substring(1,val1.length()-1);
        if (csdef.containsKey(val)) return csdef.get(val);
        RegIR tmp = new RegIR("const_"+((Integer)(++cs_num)).toString());
        csval.put(tmp,val);
        csdef.put(val,tmp);
        return tmp;
    }
}
