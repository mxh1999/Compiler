package beta1.IR.Quad;

import beta1.IR.ValueIR;
import beta1.Trans.Translator;

public class Ret extends Quad{
    public ValueIR val;

    public Ret(ValueIR _val) {
        val = _val;
    }

    @Override
    public void accept(Translator visitor) {
        visitor.visit(this);
    }
}
