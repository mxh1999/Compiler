package beta1.Trans;

import beta1.IR.FuncIR;
import beta1.IR.IRContext;
import beta1.IR.RegIR;
import beta1.Trans.LiveAnalyser.Graph;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class GraphAllocator {
    private IRContext ir;

    private LinkedList<String> generalRegisters = new LinkedList<>();
    private static LiveAnalyser analyser =new LiveAnalyser();
    private int K;

    FuncIR function;
    Graph origin,graph;
    LinkedHashMap<RegIR,String> answer;

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

    void processFunction() {
        origin= new Graph();
        while (true) {
            analyser.getInferenceGraph(function,origin,null);
            graph = new Graph(origin);
            do {

            } while (!worklist.isempty())
            getColor();

        }
    }
}
