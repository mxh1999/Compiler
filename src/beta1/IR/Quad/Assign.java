package beta1.IR.Quad;

import beta1.IR.RegIR;
import beta1.IR.ValueIR;
import beta1.Trans.Translator;

public class Assign extends Quad {
    public RegIR dest;
    public ValueIR val;

    public Assign(RegIR _dest,ValueIR _val) {
        dest = _dest;
        val = _val;
    }

    @Override
    public void accept(Translator visitor) {
        visitor.visit(this);
    }
}
