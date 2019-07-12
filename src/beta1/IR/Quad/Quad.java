package beta1.IR.Quad;

import beta1.IR.BlockIR;
import beta1.Trans.Translator;

abstract public class Quad {
    public BlockIR blk;

    public abstract void accept(Translator visitor);

}
