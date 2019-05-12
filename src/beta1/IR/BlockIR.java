package beta1.IR;

import beta1.IR.Quad.Quad;

import java.util.LinkedList;
import java.util.List;

public class BlockIR {
    //public String name;
    public List<Quad> quads = new LinkedList<>();
    public FuncIR father;
}
