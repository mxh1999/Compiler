package beta1.IR.Quad;

import beta1.IR.BlockIR;
import beta1.IR.ValueIR;
import beta1.Trans.Translator;

public class CondJump extends Quad {
    public ValueIR cond;
    public BlockIR dest;

    public CondJump(ValueIR _cond,BlockIR _dest) {
        cond = _cond;
        dest = _dest;
    }

    @Override
    public void accept(Translator visitor) {
        visitor.visit(this);
    }
}
