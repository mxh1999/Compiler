package beta1.IR.Quad;

import beta1.IR.RegIR;
import beta1.IR.ValueIR;
import beta1.Trans.Translator;

import java.util.LinkedList;

public class Malloc extends Quad {
    public RegIR addr;
    public ValueIR size;
    public Malloc(RegIR _addr,ValueIR _size) {
        addr= _addr;
        size = _size;
    }

    @Override
    public void accept(Translator visitor) {
        visitor.visit(this);
    }

    @Override
    public LinkedList<RegIR> getDefRegs() {
        LinkedList<RegIR> ret = new LinkedList<>();
        ret.add(addr);
        return ret;
    }
}
