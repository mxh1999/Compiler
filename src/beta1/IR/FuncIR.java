package beta1.IR;

import java.util.*;

public class FuncIR {
    public String name;
    public List<BlockIR> blks;
    public BlockIR now;

    public List<String> para_name = new LinkedList<>();
    public List<RegIR> para_reg = new LinkedList<>();
    public RegIR _this;

    public FuncIR(String _name) {
        name =_name;
        now = new BlockIR();
        blks=new LinkedList<>();
        blks.add(now);
    }

    public int tmpname = 0;
    public RegIR getTmpReg() {
        tmpname++;
        return new RegIR("%"+((Integer)tmpname).toString());
    }
    static Map<String,Integer> cishu  = new LinkedHashMap<>();
    public String Rename(String name) {
        if (!cishu.containsKey(name)) {
            cishu.put(name,0);
        }
        int t=cishu.get(name);
        int i=t+1;
        cishu.put(name,i);
        return '$'+name+'('+((Integer)i).toString()+')';
    }

    public BlockIR newBlock() {
        BlockIR ret = new BlockIR();
        ret.father = this;
        blks.add(ret);
        return ret;
    }

    public List<RegIR> funcvar = new LinkedList<>();
    public void addVar(RegIR reg) {
        funcvar.add(reg);
    }
}
