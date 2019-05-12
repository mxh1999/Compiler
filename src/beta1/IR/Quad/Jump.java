package beta1.IR.Quad;

import beta1.IR.BlockIR;
import beta1.Trans.Translator;

public class Jump extends Quad {
    public BlockIR dest;

    public Jump(BlockIR _dest) {
        dest = _dest;
    }

    @Override
    public void accept(Translator visitor) {
        visitor.visit(this);
    }
}
