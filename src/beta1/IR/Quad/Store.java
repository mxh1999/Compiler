package beta1.IR.Quad;

import beta1.IR.RegIR;
import beta1.IR.ValueIR;
import beta1.Trans.Translator;

import java.util.LinkedList;

public class Store extends Quad {
    public RegIR dest;
    public ValueIR val;

    public Store(RegIR _dest,ValueIR _val) {
        dest = _dest;
        val = _val;
    }

    @Override
    public void accept(Translator visitor) {
        visitor.visit(this);
    }

    @Override
    public LinkedList<RegIR> getDefRegs() {
        LinkedList<RegIR> ret = new LinkedList<>();
        ret.add(dest);
        return ret;
    }
}
