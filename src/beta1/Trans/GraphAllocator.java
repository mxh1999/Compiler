package beta1.Trans;

import beta1.IR.FuncIR;
import beta1.IR.IRContext;
import beta1.IR.RegIR;
import beta1.Trans.LiveAnalyser.Graph;

import java.util.HashMap;
import java.util.HashSet;
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

    HashSet<RegIR> simplifylist;
    HashSet<RegIR> spilllist;
    HashSet<RegIR> spilledRegisters;
    HashMap<RegIR,String> colors;

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

    public void init() {
        simplifylist = new HashSet<>();
        spilllist = new HashSet<>();
        spilledRegisters = new HashSet<>();
        colors = new HashMap<>();
        for (RegIR reg : graph.getAdjacents()) {
            if (graph.getDegree(reg) < K) {
                simplifylist.add(reg);
            }   else {
                spilllist.add(reg);
            }
        }
    }
    public void doit() {
        for (FuncIR fun:ir.global.funcs.values()) {
            function = fun;
            processFunction();
        }
    }

    void simplify() {
        RegIR reg = simplifylist.iterator().next();
        LinkedList<RegIR> neighbor = new LinkedList<>(graph.getAdjacents(reg));
        graph.delRegister(reg);
        for (RegIR reg2 : neighbor) {
            if (graph.getDegree(reg2) < K  && spilllist.contains(reg2)) {
                spilllist.remove(reg2);
                simplifylist.add(reg2);
            }
        }
        simplifylist.remove(reg);
    }

    void processFunction() {
        origin= new Graph();
        while (true) {
            analyser.getInferenceGraph(function,origin,null);
            graph = new Graph(origin);
            do {
                if (!simplifylist.isEmpty()) simplify();
                if (!spilllist.isEmpty()) spill();
            } while (!simplifylist.isEmpty());
            getColor();
            if (spilledRegisters.isEmpty()) {
                replaceRegisters();
                break;
            }
        }
    }
}
