package beta1.IR.Quad;

import beta1.IR.RegIR;
import beta1.Trans.Translator;

public class Alloc extends Quad{
    public RegIR addr;

    public Alloc(RegIR _addr) {
        addr = _addr;
    }

    @Override
    public void accept(Translator visitor) {
        visitor.visit(this);
    }
}
