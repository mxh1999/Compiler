package beta1.Trans;

import beta1.IR.BlockIR;
import beta1.IR.FuncIR;
import beta1.IR.Quad.Assign;
import beta1.IR.Quad.Call;
import beta1.IR.Quad.Quad;
import beta1.IR.RegIR;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.function.BiConsumer;

public class LiveAnalyser {

    public static class Graph {
        public HashMap<RegIR, HashSet<RegIR>> edge;

        Graph() {
            edge = new HashMap<>();
        }
        Graph(Graph g) {
            edge = new HashMap<>();
            for(RegIR reg : g.getAllRegisters())
                edge.put(reg, new HashSet<>(g.getAdjacents(reg)));
        }
        void addRegiser(RegIR vr) {
            if(edge.containsKey(vr)) return;
            edge.put(vr, new HashSet<>());
        }
        void addRegisers(Collection<RegIR> vrs) {
            for(RegIR reg : vrs)
                addRegiser(reg);
        }
        void addEdge(RegIR a, RegIR b) {
            if(a == b) return;
            edge.get(a).add(b);
            edge.get(b).add(a);
        }
        void delEdge(RegIR a, RegIR b) {
            if(edge.containsKey(a) && edge.get(a).contains(b)) {
                edge.get(a).remove(b);
                edge.get(b).remove(a);
            }
        }
        void delRegister(RegIR vr) {
            for(RegIR reg : getAdjacents(vr))
                edge.get(reg).remove(vr);
            edge.remove(vr);
        }
        int getDegree(RegIR a) {
            return edge.containsKey(a) ? edge.get(a).size() : 0;
        }
        boolean isLinked(RegIR a, RegIR b) {
            return edge.containsKey(a) && edge.get(a).contains(b);
        }
        void clear() {
            edge.clear();
        }
        void forEach(BiConsumer<RegIR,RegIR> consumer) {
            for(RegIR reg1 : edge.keySet())
                for(RegIR reg2 : edge.get(reg1))
                    consumer.accept(reg1, reg2);
        }
        Collection<RegIR> getAdjacents(RegIR a) {
            return edge.getOrDefault(a, new HashSet<>());
        }
        Collection<RegIR> getAllRegisters() {
            return edge.keySet();
        }

    }
    public HashMap<BlockIR, HashSet<RegIR>> liveOut;
    public HashMap<BlockIR, HashSet<RegIR>> usedRegisters;
    public HashMap<BlockIR, HashSet<RegIR>> definedRegisters;

    private void init(FuncIR function) {
        liveOut = new HashMap<>();
        usedRegisters = new HashMap<>();
        definedRegisters = new HashMap<>();
        for(BlockIR bb : function.blks) {
            liveOut.put(bb, new HashSet<>());
            usedRegisters.put(bb, new HashSet<>());
            definedRegisters.put(bb, new HashSet<>());
        }
    }
    private void initUsedAndDefinedRegisters(BlockIR bb, boolean nowAfterAllocate) {
        HashSet<RegIR> bbUsedRegisters = new HashSet<>();
        HashSet<RegIR> bbDefinedRegisters = new HashSet<>();
        definedRegisters.put(bb, bbDefinedRegisters);
        usedRegisters.put(bb, bbUsedRegisters);
    }

    public LinkedList<RegIR> trans(Collection<RegIR> registers) {
        LinkedList<RegIR> RegIRs = new LinkedList<>();
        for(RegIR reg : registers) {
            RegIRs.add(reg);
        }
        return RegIRs;
    }

    private void calcLiveOut(FuncIR function, boolean nowAfterAllocate) {
        init(function);

        for(BlockIR bb : function.blks)
            initUsedAndDefinedRegisters(bb, nowAfterAllocate);

        boolean changed = true;
        while (changed) {
            changed = false;
            LinkedList<BlockIR> basicBlocks = function.reverseCFG();
            for(BlockIR bb : basicBlocks) {
                int oldSize = liveOut.get(bb).size();
                for(BlockIR succ : bb.father.blks) {
                    HashSet<RegIR> regs = new HashSet<>(liveOut.get(succ));
                    regs.removeAll(definedRegisters.get(succ));
                    regs.addAll(usedRegisters.get(succ));
                    liveOut.get(bb).addAll(regs);
                }
                changed = changed || liveOut.get(bb).size() != oldSize;
            }
        }
    }

    public HashMap<BlockIR,HashSet<RegIR>> getLiveOut(FuncIR function) {
        calcLiveOut(function, false);
        return liveOut;
    }

    public void getInferenceGraph(FuncIR function,Graph inferenceGraph,Graph moveGraph) {
        calcLiveOut(function, true);

        inferenceGraph.clear();
        if(moveGraph != null)
            moveGraph.clear();

        for(BlockIR bb : function.blks) {
            HashSet<RegIR> liveNow = new HashSet<>(liveOut.get(bb));
            for(Quad inst : bb.quads) {
                boolean isMBR = false;
                for(RegIR reg1 : trans(inst.getDefRegs())) {
                    for(RegIR reg2 : liveNow) {
                        if(isMBR && moveGraph != null && ((Assign)inst).dest == reg1) {
                            moveGraph.addEdge(reg1, reg2);
                            continue;
                        }
                        inferenceGraph.addEdge(reg1, reg2);
                    }
                }
            }
        }

        /* remove some invalid <reg,reg> in move graph */
        if(moveGraph != null) {
            inferenceGraph.forEach(moveGraph::delEdge);
        }
    }
}
