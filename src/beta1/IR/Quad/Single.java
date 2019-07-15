package beta1.IR.Quad;

import beta1.IR.RegIR;
import beta1.IR.ValueIR;
import beta1.Trans.Translator;

import java.util.LinkedList;

public class Single extends Quad {
    public enum Opcode {
        NOT,NEGA
    }

    public RegIR ans;
    public Opcode op;
    public ValueIR val;

    public Single(RegIR _ans,Opcode _op,ValueIR _val) {
        ans=_ans;
        op=_op;
        val=_val;
    }

    @Override
    public void accept(Translator visitor) {
        visitor.visit(this);
    }

    @Override
    public LinkedList<RegIR> getDefRegs() {
        LinkedList<RegIR> ret = new LinkedList<>();
        ret.add(ans);
        return ret;
    }
}
