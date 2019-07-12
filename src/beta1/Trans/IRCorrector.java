package beta1.Trans;

import beta1.AST.FuncNode;
import beta1.IR.*;
import beta1.IR.Quad.*;

import java.util.*;

public class IRCorrector {
    ProgramIR irProgram;
    public void visit(IRContext program) {
        this.irProgram = program.global;
        for(FuncIR i : program.global.funcs.values())
            visit(i);
    }

    public void visit(FuncIR function) {
        for(BlockIR i : function.blks) {
            visit(i);
        }
    }

    public void visit(BlockIR block) {
        for(Quad i : block.quads)
            visit(i);
    }

    public void visit(Quad operand) {
        if (operand instanceof Alloc) {
            visit((Alloc) operand);
        }
        if (operand instanceof Assign) {
            visit((Assign) operand);
        }
        if (operand instanceof Binary) {
            visit((Binary) operand);
        }
        if (operand instanceof Call) {
            visit((Call) operand);
        }
        if (operand instanceof CondJump) {
            visit((CondJump) operand);
        }
        if (operand instanceof Jump) {
            visit((Jump) operand);
        }
        if (operand instanceof Load) {
            visit((Load) operand);
        }
        if (operand instanceof Malloc) {
            visit((Malloc) operand);
        }
        if (operand instanceof Ret) {
            visit((Ret) operand);
        }
        if (operand instanceof Single) {
            visit((Single) operand);
        }
        if (operand instanceof Store) {
            visit((Store) operand);
        }
    }

    public void visit(Alloc operand) {

    }

    public void visit(Assign operand) {

    }

    public void visit(Binary operand) {
        if (operand.op.equals(Binary.Opcode.MUL)) {
            if (operand.val1 instanceof ConstIR && !(operand.val2 instanceof ConstIR)) {
                ValueIR tmp = operand.val1;
                operand.val1 = operand.val2;
                operand.val2 = tmp;
            }
            if (operand.val2 instanceof ConstIR) {
                int tmp = ((ConstIR) operand.val2).val;
                int ha = 0;
                while (tmp>1) {
                    if ((tmp&1) == 1) {ha = -1;break;}
                    tmp >>=1;
                    ha ++;
                }
                if (ha != -1) {
                    operand.op = Binary.Opcode.SHL;
                    operand.val2 = new ConstIR(ha);
                }
            }
        }   else
        if (operand.op.equals(Binary.Opcode.DIV)) {
            if (operand.val1 instanceof ConstIR && !(operand.val2 instanceof ConstIR)) {
                ValueIR tmp = operand.val1;
                operand.val1 = operand.val2;
                operand.val2 = tmp;
            }
            if (operand.val2 instanceof ConstIR) {
                int tmp = ((ConstIR) operand.val2).val;
                int ha = 0;
                while (tmp>1) {
                    if ((tmp&1) == 1) {ha = -1;break;}
                    tmp >>=1;
                    ha ++;
                }
                if (ha != -1) {
                    operand.op = Binary.Opcode.SHR;
                    operand.val2 = new ConstIR(ha);
                }
            }
        }   else
        if (operand.op.equals(Binary.Opcode.MOD)) {
            if (operand.val1 instanceof ConstIR && !(operand.val2 instanceof ConstIR)) {
                ValueIR tmp = operand.val1;
                operand.val1 = operand.val2;
                operand.val2 = tmp;
            }
            if (operand.val2 instanceof ConstIR) {
                int tmp = ((ConstIR) operand.val2).val;
                int ha = 0;
                while (tmp>1) {
                    if ((tmp&1) == 1) {ha = -1;break;}
                    tmp >>=1;
                    ha ++;
                }
                if (ha != -1) {
                    operand.op = Binary.Opcode.SHL;
                    operand.val2 = new ConstIR((1<<ha)-1);
                }
            }
        }
    }

    public void visit(Call operand) {

    }

    public void visit(CondJump operand) {

    }

    public void visit(Jump operand) {

    }
    public void visit(Load operand) {

    }
    public void visit(Malloc operand) {

    }
    public void visit(Ret operand) {

    }
    public void visit(Single operand) {

    }
    public void visit(Store operand) {

    }
}
