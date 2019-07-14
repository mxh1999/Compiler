package beta1.Trans;

import beta1.IR.FuncIR;
import beta1.IR.IRContext;

import java.util.LinkedList;

public class GraphAllocator {
    private IRContext ir;

    private LinkedList<String> generalRegisters = new LinkedList<>();
    private int K;

    FuncIR function;

    public GraphAllocator(IRContext _ir) {
        ir=_ir;
        generalRegisters.add( "rax");
        generalRegisters.add( "rcx");
        generalRegisters.add( "rdx");
        generalRegisters.add( "rbx");
        generalRegisters.add( "rsi");
        generalRegisters.add( "rdi");
        generalRegisters.add( "r8");
        generalRegisters.add( "r9");
        generalRegisters.add( "r10");
        generalRegisters.add( "r11");
        generalRegisters.add( "r12");
        generalRegisters.add( "r13");
        generalRegisters.add( "r14");
        generalRegisters.add( "r15");
        K =generalRegisters.size();
    }
    public void doit() {
        for (FuncIR fun:ir.global.funcs.values()) {
            function = fun;
            processFunction();
        }
    }


}
