package beta1.AST;

import beta1.IR.BlockIR;
import beta1.IR.RegIR;
import beta1.IR.ValueIR;

public abstract class Expr extends Node{
    public Type type;
    public boolean isleft;

    public RegIR iraddr = null;
    public ValueIR irvalue = null;
}
