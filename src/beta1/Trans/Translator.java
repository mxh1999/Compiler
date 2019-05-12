package beta1.Trans;

import beta1.AST.FuncNode;
import beta1.IR.*;
import beta1.IR.Quad.*;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Translator {
    private IRContext basic;

    private String fmt(String s) {
        return "          "+String.format("%-10s",s);
    }

    private StringBuilder text = new StringBuilder();
    private StringBuilder data = new StringBuilder();
    private StringBuilder bss = new StringBuilder();
    private int label_num;
    private Map<BlockIR,String> blocklabel= new LinkedHashMap<>();

    public Translator(IRContext _basic) {
        basic = _basic;
    }

    private void addGlobalVars() {
        for (Map.Entry<String, RegIR> i:basic.global.gvars.entrySet()) {
            GlobalVars.put(i.getValue(),i.getValue().name+"_var");
            bss.append(i.getValue().name+"_var");bss.append(":\n");
            bss.append(fmt("resb"));    bss.append("8");    bss.append("\n");
        }
    }
    private void visit(BlockIR node) {
        label_num++;
        text.append("Lab_"+((Integer)label_num).toString()+":\n");
        blocklabel.put(node,"Lab_"+((Integer)label_num).toString()+":\n");
        for (Quad i:node.quads) {
            i.accept(this);
        }
    }

    private void addConstString() {
        ConstStringReg = new LinkedHashMap<>();
        for (Map.Entry<RegIR,String> i:basic.csval.entrySet()) {
            ConstStringReg.put(i.getKey(),i.getKey().name+"_cs");
            data.append(i.getKey().name+"_cs:\n");
            data.append(fmt("db")); data.append("\""+i.getValue()+"\",0\n");
        }
    }

    public String IRtoNASM() {
        StringBuilder str = new StringBuilder();
        str.append("global main\n");
        preFuncTranslator.addpreFunc(str);
        addGlobalVars();
        addConstString();
        for (Map.Entry<String, FuncIR> i:basic.global.funcs.entrySet()) {
            addFunc(i.getKey(),i.getValue());
        }
        str.append("section .text\n");
        str.append(text.toString());
        str.append("\n");
        str.append("section .data\n");
        str.append(data.toString());
        str.append("section .bss\n");
        str.append(bss.toString());
        return str.toString();
    }

    private Map<RegIR,String> ConstStringReg = new LinkedHashMap<>();
    private Map<RegIR,String> GlobalVars = new LinkedHashMap<>();
    private Map<RegIR,Integer> RegIR_to_offset = new LinkedHashMap<>();
    private Set<RegIR> LocalVars = new LinkedHashSet<>();
    private int offset;
    private String getReg(RegIR reg) {
        if (GlobalVars.containsKey(reg)) return GlobalVars.get(reg);
        if (ConstStringReg.containsKey(reg)) return ConstStringReg.get(reg);
        if (RegIR_to_offset.containsKey(reg)) {
            if (LocalVars.contains(reg)) return "rbp-"+RegIR_to_offset.get(reg).toString();
            return "qword [rbp-"+RegIR_to_offset.get(reg).toString()+"]";
        }
        offset+=8;
        RegIR_to_offset.put(reg,offset);
        return "qword [rbp-"+((Integer)offset).toString()+"]";
    }
    private String getval(ValueIR val) {
        if (val instanceof ConstIR) {
            return ((Integer)(((ConstIR)val).val)).toString();
        }
        return getReg((RegIR)val);
    }
    private int get_size(FuncIR func) {
        RegIR_to_offset.clear();
        LocalVars.clear();
        offset = 0;
        for (BlockIR i:func.blks) {
            for (Quad j:i.quads) {
                if (j instanceof Alloc) {
                    offset += 8;
                    RegIR_to_offset.put(((Alloc) j).addr,offset);
                    LocalVars.add(((Alloc) j).addr);
                }
            }
        }
        return offset+8*func.tmpname;
    }
    private void addFunc(String name,FuncIR func) {
        int all_offset = get_size(func);
        if (name.equals("_init_")) {
            text.append("main:\n");
        }   else {
            text.append(name);text.append("_func:\n");
        }
        text.append(fmt("push"));text.append("rbp");text.append("\n");
        text.append(fmt("mov"));text.append("rbp, rsp");text.append("\n");
        if (all_offset!=0) {text.append(fmt("sub"));text.append("rsp, ");text.append(((Integer)all_offset).toString());text.append("\n");}
        if (func.para_reg != null && !func.para_reg.isEmpty()) {
            text.append(fmt("mov"));text.append(getReg(func.para_reg.get(0))+", rdi");text.append("\n");
            //RegIR_to_offset.put(func.para_reg.get(0),8);
            if (func.para_reg.size()>1) {
                text.append(fmt("mov"));text.append(getReg(func.para_reg.get(1))+", rsi");text.append("\n");
                //RegIR_to_offset.put(func.para_reg.get(1),16);
            }
            if (func.para_reg.size()>2) {
                text.append(fmt("mov"));text.append(getReg(func.para_reg.get(2))+", rdx");text.append("\n");
                //RegIR_to_offset.put(func.para_reg.get(2),3*8);
            }
            if (func.para_reg.size()>3) {
                text.append(fmt("mov"));text.append(getReg(func.para_reg.get(3))+", rcx");text.append("\n");
                //RegIR_to_offset.put(func.para_reg.get(3),4*8);
            }
            if (func.para_reg.size()>4) {
                text.append(fmt("mov"));text.append(getReg(func.para_reg.get(4))+", r8");text.append("\n");
                //RegIR_to_offset.put(func.para_reg.get(4),5*8);
            }
            if (func.para_reg.size()>5) {
                text.append(fmt("mov"));text.append(getReg(func.para_reg.get(5))+", r9");text.append("\n");
                //RegIR_to_offset.put(func.para_reg.get(5),6*8);
            }
            if (func.para_reg.size()>6) {
                for (int i=6;i<func.para_reg.size();i++) {
                    text.append(fmt("pop"));text.append(getReg(func.para_reg.get(6)));text.append("\n");
                    //RegIR_to_offset.put(func.para_reg.get(i),i*8+8);
                }
            }
        }
        for (BlockIR i:func.blks)   visit(i);
        if (name.equals("_init_")) {
            text.append(fmt("call"));text.append("main_func");text.append("\n");
        }
        text.append(fmt("leave"));text.append("\n");
        text.append(fmt("ret"));text.append("\n");
        text.append("\n");
    }

    public void visit(Alloc node) {
    }

    public void visit(Assign node) {
        if (node.val instanceof ConstIR){
            text.append(fmt("mov"));text.append(getReg(node.dest));text.append(", ");text.append(getval(node.val));text.append("\n");
        }   else {
            text.append(fmt("mov"));text.append("r10");text.append(", ");text.append(getReg((RegIR)node.val));text.append("\n");
            text.append(fmt("mov"));text.append(getReg(node.dest));text.append(", ");text.append("r9");text.append("\n");
        }
    }
    public void visit(Binary node) {
        if (node.op.equals(Binary.Opcode.ADD)) {
            text.append(fmt("mov"));text.append("r10");text.append(", ");text.append(getval(node.val1));text.append("\n");
            text.append(fmt("add"));text.append("r10");text.append(", ");text.append(getval(node.val2));text.append("\n");
            text.append(fmt("mov"));text.append(getReg(node.ans));text.append(", ");text.append("r10");text.append("\n");
        }   else if (node.op.equals(Binary.Opcode.SUB)) {
            text.append(fmt("mov"));text.append("r10");text.append(", ");text.append(getval(node.val1));text.append("\n");
            text.append(fmt("sub"));text.append("r10");text.append(", ");text.append(getval(node.val2));text.append("\n");
            text.append(fmt("mov"));text.append(getReg(node.ans));text.append(", ");text.append("r10");text.append("\n");
        }   else if (node.op.equals(Binary.Opcode.MUL)) {
            text.append(fmt("imul"));text.append("r10");text.append(", ");text.append(getval(node.val1));text.append(", ");text.append(getval(node.val2));text.append("\n");
            text.append(fmt("mov"));text.append(getReg(node.ans));text.append(", ");text.append("r10");text.append("\n");
        }   else if (node.op.equals(Binary.Opcode.DIV)) {
            text.append(fmt("xor"));text.append("rdx");text.append(", ");text.append("rdx");text.append("\n");
            text.append(fmt("mov"));text.append("rax");text.append(", ");text.append(getval(node.val1));text.append("\n");
            text.append(fmt("idiv"));text.append(getval(node.val2));text.append("\n");
            text.append(fmt("mov"));text.append(getReg(node.ans));text.append(", ");text.append("rax");text.append("\n");
        }   else if (node.op.equals(Binary.Opcode.MOD)) {
            text.append(fmt("xor"));text.append("rdx");text.append(", ");text.append("rdx");text.append("\n");
            text.append(fmt("mov"));text.append("rax");text.append(", ");text.append(getval(node.val1));text.append("\n");
            text.append(fmt("idiv"));text.append(getval(node.val2));text.append("\n");
            text.append(fmt("mov"));text.append(getReg(node.ans));text.append(", ");text.append("rdx");text.append("\n");
        }   else if (node.op.equals(Binary.Opcode.SHL)) {
            text.append(fmt("mov"));text.append("r10");text.append(", ");text.append(getval(node.val1));text.append("\n");
            text.append(fmt("sal"));text.append("r10");text.append(", ");text.append(getval(node.val2));text.append("\n");
            text.append(fmt("mov"));text.append(getReg(node.ans));text.append(", ");text.append("r10");text.append("\n");
        }   else if (node.op.equals(Binary.Opcode.SHR)) {
            text.append(fmt("mov"));text.append("r10");text.append(", ");text.append(getval(node.val1));text.append("\n");
            text.append(fmt("sar"));text.append("r10");text.append(", ");text.append(getval(node.val2));text.append("\n");
            text.append(fmt("mov"));text.append(getReg(node.ans));text.append(", ");text.append("r10");text.append("\n");
        }   else if (node.op.equals(Binary.Opcode.AND)) {
            text.append(fmt("mov"));text.append("r10");text.append(", ");text.append(getval(node.val1));text.append("\n");
            text.append(fmt("and"));text.append("r10");text.append(", ");text.append(getval(node.val2));text.append("\n");
            text.append(fmt("mov"));text.append(getReg(node.ans));text.append(", ");text.append("r10");text.append("\n");
        }   else if (node.op.equals(Binary.Opcode.OR)) {
            text.append(fmt("mov"));text.append("r10");text.append(", ");text.append(getval(node.val1));text.append("\n");
            text.append(fmt("or"));text.append("r10");text.append(", ");text.append(getval(node.val2));text.append("\n");
            text.append(fmt("mov"));text.append(getReg(node.ans));text.append(", ");text.append("r10");text.append("\n");
        }   else if (node.op.equals(Binary.Opcode.XOR)) {
            text.append(fmt("mov"));text.append("r10");text.append(", ");text.append(getval(node.val1));text.append("\n");
            text.append(fmt("xor"));text.append("r10");text.append(", ");text.append(getval(node.val2));text.append("\n");
            text.append(fmt("mov"));text.append(getReg(node.ans));text.append(", ");text.append("r10");text.append("\n");
        }   else if (node.op.equals(Binary.Opcode.GT)) {
            text.append(fmt("mov"));text.append("r10");text.append(", ");text.append(getval(node.val1));text.append("\n");
            text.append(fmt("cmp"));text.append("r10");text.append(", ");text.append(getval(node.val2));text.append("\n");
            text.append(fmt("xor"));text.append("rax");text.append(", ");text.append("rax");text.append("\n");
            text.append(fmt("setg"));text.append("al");text.append("\n");
            text.append(fmt("mov"));text.append(getReg(node.ans));text.append(", ");text.append("rax");text.append("\n");
        }   else if (node.op.equals(Binary.Opcode.GE)) {
            text.append(fmt("mov"));text.append("r10");text.append(", ");text.append(getval(node.val1));text.append("\n");
            text.append(fmt("cmp"));text.append("r10");text.append(", ");text.append(getval(node.val2));text.append("\n");
            text.append(fmt("xor"));text.append("rax");text.append(", ");text.append("rax");text.append("\n");
            text.append(fmt("setge"));text.append("al");text.append("\n");
            text.append(fmt("mov"));text.append(getReg(node.ans));text.append(", ");text.append("rax");text.append("\n");
        }   else if (node.op.equals(Binary.Opcode.LT)) {
            text.append(fmt("mov"));text.append("r10");text.append(", ");text.append(getval(node.val1));text.append("\n");
            text.append(fmt("cmp"));text.append("r10");text.append(", ");text.append(getval(node.val2));text.append("\n");
            text.append(fmt("xor"));text.append("rax");text.append(", ");text.append("rax");text.append("\n");
            text.append(fmt("setl"));text.append("al");text.append("\n");
            text.append(fmt("mov"));text.append(getReg(node.ans));text.append(", ");text.append("rax");text.append("\n");
        }   else if (node.op.equals(Binary.Opcode.LE)) {
            text.append(fmt("mov"));text.append("r10");text.append(", ");text.append(getval(node.val1));text.append("\n");
            text.append(fmt("cmp"));text.append("r10");text.append(", ");text.append(getval(node.val2));text.append("\n");
            text.append(fmt("xor"));text.append("rax");text.append(", ");text.append("rax");text.append("\n");
            text.append(fmt("setle"));text.append("al");text.append("\n");
            text.append(fmt("mov"));text.append(getReg(node.ans));text.append(", ");text.append("rax");text.append("\n");
        }   else if (node.op.equals(Binary.Opcode.EQ)) {
            text.append(fmt("mov"));text.append("r10");text.append(", ");text.append(getval(node.val1));text.append("\n");
            text.append(fmt("cmp"));text.append("r10");text.append(", ");text.append(getval(node.val2));text.append("\n");
            text.append(fmt("xor"));text.append("rax");text.append(", ");text.append("rax");text.append("\n");
            text.append(fmt("sete"));text.append("al");text.append("\n");
            text.append(fmt("mov"));text.append(getReg(node.ans));text.append(", ");text.append("rax");text.append("\n");
        }   else {
            text.append(fmt("mov"));text.append("r10");text.append(", ");text.append(getval(node.val1));text.append("\n");
            text.append(fmt("cmp"));text.append("r10");text.append(", ");text.append(getval(node.val2));text.append("\n");
            text.append(fmt("xor"));text.append("rax");text.append(", ");text.append("rax");text.append("\n");
            text.append(fmt("setne"));text.append("al");text.append("\n");
            text.append(fmt("mov"));text.append(getReg(node.ans));text.append(", ");text.append("rax");text.append("\n");
        }
    }
    public void visit(Call node) {
        if (node.para!=null && !node.para.isEmpty()) {
            text.append(fmt("mov"));text.append("rdi");text.append(", ");text.append(getval(node.para.get(0)));text.append("\n");
            if (node.para.size()>1) {
                text.append(fmt("mov"));text.append("rsi");text.append(", ");text.append(getval(node.para.get(1)));text.append("\n");
            }
            if (node.para.size()>2) {
                text.append(fmt("mov"));text.append("rdx");text.append(", ");text.append(getval(node.para.get(2)));text.append("\n");
            }
            if (node.para.size()>3) {
                text.append(fmt("mov"));text.append("rcx");text.append(", ");text.append(getval(node.para.get(3)));text.append("\n");
            }
            if (node.para.size()>4) {
                text.append(fmt("mov"));text.append("r8");text.append(", ");text.append(getval(node.para.get(4)));text.append("\n");
            }
            if (node.para.size()>5) {
                text.append(fmt("mov"));text.append("r9");text.append(", ");text.append(getval(node.para.get(5)));text.append("\n");
            }
            if (node.para.size()>6) {
                for (int i=node.para.size()-1;i>=6;i--) {
                    text.append(fmt("push"));text.append(getval(node.para.get(i)));text.append("\n");
                }
            }
        }
        text.append(fmt("call"));text.append(node.name);text.append("_func");text.append("\n");
        if (!node.ret.name.equals("@void")) {
            text.append(fmt("mov"));text.append(getReg(node.ret));text.append(", ");text.append("rax");text.append("\n");
        }
    }
    public void visit(Jump node) {
        text.append(fmt("jmp"));text.append(blocklabel.get(node.dest));text.append("\n");
    }
    public void visit(CondJump node) {
        text.append(fmt("cmp"));text.append(getval(node.cond));text.append(", ");text.append("0");text.append("\n");
        text.append(fmt("jnz"));text.append(blocklabel.get(node.dest));text.append("\n");
    }

    public void visit(Malloc node) {
        text.append(fmt("mov"));text.append("rdi");text.append(", ");text.append(getval(node.size));text.append("\n");
        text.append(fmt("call"));text.append("malloc");text.append("\n");
        text.append("mov");text.append(getReg(node.addr));text.append(", ");text.append("rax");text.append("\n");
    }

    public void visit(Single node) {
        text.append(fmt("mov"));text.append("r10");text.append(", ");text.append(getval(node.val));text.append("\n");
        if (node.op.equals(Single.Opcode.NOT)) {
            text.append(fmt("not"));text.append("r10");text.append("\n");
        }   else {
            text.append(fmt("neg"));text.append("r10");text.append("\n");
        }
        text.append(fmt("mov"));text.append(getReg(node.ans));text.append(", ");text.append("r10");text.append("\n");
    }
    public void visit(Ret node) {
        text.append(fmt("mov"));text.append("rax");text.append(", ");text.append(getval(node.val));text.append("\n");
        text.append(fmt("leave"));text.append("\n");
        text.append(fmt("ret"));text.append("\n");
    }

    public void visit(Load node) {
        if (LocalVars.contains(node.addr) || GlobalVars.containsKey(node.addr)){
            text.append(fmt("mov"));text.append("r10");text.append(", ");text.append("qword [");text.append(getReg(node.addr));text.append("]");text.append("\n");
        }   else {
            text.append(fmt("mov"));text.append("r11");text.append(", ");text.append(getReg(node.addr));text.append("\n");
            text.append(fmt("mov"));text.append("r10");text.append(", ");text.append("[r11]");text.append("\n");
        }
        text.append(fmt("mov"));text.append(getReg(node.val));text.append(", ");text.append("r10");text.append("\n");

    }

    public void visit(Store node) {
        text.append(fmt("mov"));text.append("r10");text.append(", ");text.append(getval(node.val));text.append("\n");
        if (LocalVars.contains(node.dest) || GlobalVars.containsKey(node.dest)){
            text.append(fmt("mov"));text.append("qword [");text.append(getReg(node.dest));text.append("], ");text.append("r10");text.append("\n");
        }   else {
            text.append(fmt("mov"));text.append("r11");text.append(", ");text.append(getReg(node.dest));text.append("\n");
            text.append(fmt("mov"));text.append("[r11]");text.append(", ");text.append("r10");text.append("\n");
        }
    }
}
