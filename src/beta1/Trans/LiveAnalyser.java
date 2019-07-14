package beta1.Trans;

import beta1.IR.BlockIR;
import beta1.IR.FuncIR;
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
        for(Quad inst : bb.quads) {
            LinkedList<Register> usedRegs;
            usedRegs = inst.getUseRegs();
            for(RegIR reg : trans(usedRegs))
                if(!bbDefinedRegisters.contains(reg))
                    bbUsedRegisters.add(reg);
            bbDefinedRegisters.addAll(trans(inst.getDefRegs()));
        }
        definedRegisters.put(bb, bbDefinedRegisters);
        usedRegisters.put(bb, bbUsedRegisters);
    }

    private boolean isMoveBetweenRegisters(IRInstruction inst) {
        if(inst instanceof Move) {
            Move move = (Move)inst;
            return move.dest instanceof RegIR && move.src instanceof RegIR;
        } else {
            return false;
        }
    }

    public LinkedList<RegIR> trans(Collection<Register> registers) {
        LinkedList<RegIR> RegIRs = new LinkedList<>();
        for(Register reg : registers) {
            RegIRs.add((RegIR) reg);
        }
        return RegIRs;
    }

    private void calcLiveOut(Function function, boolean nowAfterAllocate) {
        init(function);

        for(BlockIR bb : function.basicblocks)
            initUsedAndDefinedRegisters(bb, nowAfterAllocate);

        /* calculate the liveOut set of each BlockIR */
        boolean changed = true;
        while(changed) {
            changed = false;
            LinkedList<BlockIR> basicBlocks = function.reversePostOrderOnReverseCFG;
            for(BlockIR bb : basicBlocks) {
                int oldSize = liveOut.get(bb).size();
                for(BlockIR succ : bb.successors) {
                    HashSet<RegIR> regs = new HashSet<>(liveOut.get(succ));
                    regs.removeAll(definedRegisters.get(succ));
                    regs.addAll(usedRegisters.get(succ));
                    liveOut.get(bb).addAll(regs);
                }
                changed = changed || liveOut.get(bb).size() != oldSize;
            }
        }
    }

    public HashMap<BlockIR,HashSet<RegIR>> getLiveOut(Function function) {
        calcLiveOut(function, false);
        return liveOut;
    }

    public void getInferenceGraph(Function function,
                                  Graph inferenceGraph,
                                  Graph moveGraph
    ) {
        calcLiveOut(function, true);

        inferenceGraph.clear();
        if(moveGraph != null)
            moveGraph.clear();

        for(BlockIR bb : function.basicblocks) {
            for(IRInstruction inst = bb.head; inst != null; inst = inst.next) {
                inferenceGraph.addRegisers(trans(inst.getDefRegs()));
                inferenceGraph.addRegisers(trans(inst.getUseRegs()));
            }
        }

        /* calculate the inference graph and move graph when needed */
        for(BlockIR bb : function.basicblocks) {
            HashSet<RegIR> liveNow = new HashSet<>(liveOut.get(bb));
            for(IRInstruction inst = bb.tail; inst != null; inst = inst.prev) {
                boolean isMBR = isMoveBetweenRegisters(inst);
                for(RegIR reg1 : trans(inst.getDefRegs())) {
                    for(RegIR reg2 : liveNow) {
                        if(isMBR && moveGraph != null && ((Move)inst).src == reg1) {
                            moveGraph.addEdge(reg1, reg2);
                            continue;
                        }
                        inferenceGraph.addEdge(reg1, reg2);
                    }
                }
                liveNow.removeAll(trans(inst.getDefRegs()));
                liveNow.addAll(trans(inst.getUseRegs()));
            }
        }

        /* remove some invalid <reg,reg> in move graph */
        if(moveGraph != null) {
            inferenceGraph.forEach(moveGraph::delEdge);
        }
    }
}
