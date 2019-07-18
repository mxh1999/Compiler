package beta1.Trans;

import beta1.IR.BlockIR;
import beta1.IR.FuncIR;
import beta1.IR.IRContext;
import beta1.IR.Quad.Quad;
import beta1.IR.RegIR;
import beta1.Trans.LiveAnalyser.Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class GraphAllocator {
    private IRContext ir;

    private LinkedList<String> allreg = new LinkedList<>();
    private static LiveAnalyser analyser =new LiveAnalyser();
    private int K;

    FuncIR function;
    Graph origin,graph;
    LinkedHashMap<RegIR,String> answer;

    HashSet<RegIR> simplifylist;
    HashSet<RegIR> spilllist;
    HashSet<RegIR> spilledRegisters;
    HashMap<RegIR,String> colors;
    LinkedList<RegIR> stack;

    public GraphAllocator(IRContext _ir) {
        ir=_ir;
        allreg.add( "rax");
        allreg.add( "rcx");
        allreg.add( "rdx");
        allreg.add( "rbx");
        allreg.add( "rsi");
        allreg.add( "rdi");
        allreg.add( "r8");
        allreg.add( "r9");
        allreg.add( "r10");
        allreg.add( "r11");
        allreg.add( "r12");
        allreg.add( "r13");
        allreg.add( "r14");
        allreg.add( "r15");
        K =allreg.size();
    }

    public void init() {
        simplifylist = new HashSet<>();
        spilllist = new HashSet<>();
        spilledRegisters = new HashSet<>();
        stack = new LinkedList<>();
        colors = new HashMap<>();
        for (RegIR reg : graph.getAllRegisters()) {
            if (graph.getDegree(reg) < K) {
                simplifylist.add(reg);
            }   else {
                spilllist.add(reg);
            }
        }
    }
    public void doit() {
        for (FuncIR fun:ir.global.func.values()) {
            function = fun;
            processFunction();
        }
    }

    private void simplify() {
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
        stack.addFirst(reg);
    }
    private void spill() {
        RegIR reg = null;
        int rank=-2;
        for (RegIR reg2 : spilllist) {
            int now = graph.getDegree(reg2);
            if (now > rank) {
                reg = reg2;
                rank = now;
            }
        }
        graph.delRegister(reg);
        spilllist.remove(reg);
        stack.addFirst(reg);
    }
    private void getColor() {
        for (RegIR reg : stack) {
            HashSet<String> okColors = new HashSet<>(allreg);
            for (RegIR neighbor : origin.getAdjacents(reg)) {
                if (colors.containsKey(neighbor))
                    okColors.remove(colors.get(neighbor));
            }
            if (okColors.isEmpty()) {
                spilllist.add(reg);
            }   else {
                String tmp = null;
                for (String reg2: allreg)
                    if (okColors.contains(reg2)) {
                        tmp = reg2;
                        break;
                    }
                if (tmp == null)
                    tmp = okColors.iterator().next();
                colors.put(reg,tmp);
            }
        }
    }
    private void replaceRegisters() {
        HashMap<RegIR,String> rename = new HashMap<>();
        for (HashMap.Entry<RegIR,String> i:colors.entrySet()) {
            rename.put(i.getKey(),i.getValue());
        }
        for (BlockIR i:function.blks)
            for (Quad j : i.quads) {
                j.rename(rename);
            }
    }
    private void processFunction() {
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
