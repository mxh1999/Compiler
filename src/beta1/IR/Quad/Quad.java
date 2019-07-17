package beta1.IR.Quad;

import beta1.IR.BlockIR;
import beta1.IR.RegIR;
import beta1.Trans.Translator;

import java.util.HashMap;
import java.util.LinkedList;

abstract public class Quad {
    public BlockIR blk;

    public abstract void accept(Translator visitor);
    public abstract LinkedList<RegIR> getDefRegs();

    public void rename(HashMap<RegIR,String> rename) {}
}
