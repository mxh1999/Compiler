package beta1.IR.Quad;

import beta1.IR.BlockIR;
import beta1.IR.RegIR;
import beta1.Trans.Translator;

import java.util.LinkedList;

public class Jump extends Quad {
    public BlockIR dest;

    public Jump(BlockIR _dest) {
        dest = _dest;
    }

    @Override
    public void accept(Translator visitor) {
        visitor.visit(this);
    }

    @Override
    public LinkedList<RegIR> getDefRegs() {
        LinkedList<RegIR> ret = new LinkedList<>();
        return ret;
    }
}
