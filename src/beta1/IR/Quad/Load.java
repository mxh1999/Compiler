package beta1.IR.Quad;

import beta1.IR.RegIR;
import beta1.Trans.Translator;

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
}
