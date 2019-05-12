package beta1.IR.Quad;

import beta1.IR.RegIR;
import beta1.IR.ValueIR;
import beta1.Trans.Translator;

import java.util.List;

public class Call extends Quad {
    public String name;
    public RegIR ret;
    public List<ValueIR> para;

    public Call(String _name,RegIR _ret,List<ValueIR> _para) {
        name = _name;
        ret = _ret;
        para = _para;
    }

    @Override
    public void accept(Translator visitor) {
        visitor.visit(this);
    }
}
