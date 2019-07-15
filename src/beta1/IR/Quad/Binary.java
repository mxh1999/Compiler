package beta1.IR.Quad;

import beta1.IR.RegIR;
import beta1.IR.ValueIR;
import beta1.Trans.Translator;

import java.util.LinkedList;

public class Binary extends Quad{
    public enum Opcode {
        ADD, SUB, MUL, DIV, MOD,
        SHL, SHR,
        AND, XOR, OR,
        GT, GE, LT, LE,
        EQ, NE
    }
    /*
    lt <
    le <=
    gt >
    ge >=
    eq ==
    ne !=
     */
    public RegIR ans;
    public Opcode op;
    public ValueIR val1,val2;

    public Binary(RegIR _ans,Opcode _op,ValueIR _val1,ValueIR _val2) {
        ans=_ans;
        op=_op;
        val1=_val1;
        val2=_val2;
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
