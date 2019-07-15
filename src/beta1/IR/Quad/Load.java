package beta1.IR.Quad;

import beta1.IR.RegIR;
import beta1.Trans.Translator;

import java.util.LinkedList;

public class Load extends Quad {
    public RegIR val;
    public RegIR addr;

    public Load(RegIR _val,RegIR _addr) {
        val = _val;
        addr = _addr;
    }

    @Override
    public void accept(Translator visitor) {
        visitor.visit(this);
    }

    @Override
    public LinkedList<RegIR> getDefRegs() {
        LinkedList<RegIR> ret = new LinkedList<>();
        ret.add(addr);
        ret.add(val);
        return ret;
    }
}
