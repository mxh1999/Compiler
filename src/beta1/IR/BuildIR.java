package beta1.IR;

import beta1.AST.*;
import beta1.IR.Quad.*;

import java.util.LinkedList;
import java.util.List;


import static beta1.IR.Quad.Binary.Opcode.*;
import static beta1.IR.Quad.Single.Opcode.*;

public class BuildIR implements ASTVisitor{

    public IRContext ctx;
    private BlockIR _forbegin= null;
    private BlockIR _forend =null;

    public BuildIR(IRContext _ctx) {
        ctx= _ctx;
    }
    private void preClass(ClassNode node) {
        ctx.classes.put(node.name,node);
        for (FuncNode i:node.method) {
            i.ismethod = true;
            i.belong = node;
            i.global_name ='_'+ node.name+'_'+i.name;
            ctx.func.put(i.global_name,i);
        }
        if (node.construction != null) {
            node.construction.ismethod=true;
            node.construction.belong = node;
            node.construction.global_name = '_'+node.name+'_' + node.name;
            ctx.func.put(node.construction.global_name,node.construction);
        }
        for (VariableNode i:node.member) {
            i.ismember =true;
            i.belong = node;
        }
    }

    private int getsize(Type type) {
        if (type instanceof BasicType) return 8;
        ClassNode def=ctx.classes.get(((ClassType)type).name);
        return def.member.size()*8;
    }

    private ValueIR GetArithResult(Expr node) {
        if (node.irvalue == null) {
            RegIR addr = node.iraddr;

            RegIR val = ctx.local.getTmpReg();
            ctx.addQuad(new Load(val,addr));
            node.irvalue = val;
        }
        return node.irvalue;
    }

    private Binary.Opcode getop(String op) {
        if (op.equals("+")) return ADD;
        if (op.equals("-")) return SUB;
        if (op.equals("*")) return MUL;
        if (op.equals("/")) return DIV;
        if (op.equals("%")) return MOD;
        if (op.equals("<<")) return SHL;
        if (op.equals(">>")) return SHR;
        if (op.equals("&")) return AND;
        if (op.equals("^")) return XOR;
        if (op.equals("|")) return OR;
        if (op.equals(">")) return GT;
        if (op.equals(">=")) return GE;
        if (op.equals("<")) return LT;
        if (op.equals("<=")) return LE;
        if (op.equals("==")) return EQ;
        if (op.equals("!=")) return NE;
        return null;
    }

    private RegIR newArray(List<Expr> node,int dep) throws Exception{
        RegIR ans = ctx.local.getTmpReg();
        ValueIR tmp = GetArithResult(node.get(dep));
        RegIR tmp2 = ctx.local.getTmpReg();
        RegIR siz = ctx.local.getTmpReg();
        ctx.addQuad(new Binary(tmp2,MUL,tmp,new ConstIR(8)));
        ctx.addQuad(new Binary(siz,ADD,tmp2,new ConstIR(8)));
        ctx.addQuad(new Malloc(ans,siz));
        ctx.addQuad(new Store(ans,tmp));
        if (dep<node.size()-1) {
            RegIR i = ctx.local.getTmpReg();
            RegIR addr = ctx.local.getTmpReg();
            ctx.addQuad(new Assign(i,new ConstIR(0)));
            ctx.addQuad(new Binary(addr,ADD,ans,new ConstIR(8)));
            BlockIR begin = ctx.local.newBlock();
            BlockIR end = ctx.local.newBlock();
            ctx.addQuad(new Jump(begin));
            ctx.local.now=begin;
            RegIR cond = ctx.local.getTmpReg();
            ctx.addQuad(new Binary(cond,GE,i,tmp));
            ctx.addQuad(new CondJump(cond,end));
            RegIR nxt = newArray(node,dep+1);
            ctx.addQuad(new Store(addr,nxt));
            ctx.addQuad(new Binary(addr,ADD,addr,new ConstIR(8)));
            ctx.addQuad(new Jump(begin));
            ctx.local.now=end;
        }
        return ans;
    }
    @Override
    public void visit(ProgNode node) throws Exception {
        for (ClassNode i:node.classlist) {
            preClass(i);
        }
        for (FuncNode i:node.funclist) {
            i.belong = null;
            i.global_name=i.name;
            ctx.func.put(i.global_name,i);
        }
        for (VariableNode i:node.variablelist) {
            i.isglobal = true;
        }
        FuncIR init = ctx.newFunc("_init_");
        ctx.global.funcs.put("_init_",init);
        ctx.local = init;
        for (VariableNode i:node.variablelist) {
            i.accept(this);
        }
        for (Node i :node.all) {
            if (!(i instanceof VariableNode)) {
                i.accept(this);
            }
        }
    }

    @Override
    public void visit(VariableNode node) throws Exception {
        if (node.ismember) return;
        if (node.isglobal) {
            RegIR var = new RegIR('@' + node.name);
            ctx.vars.put(node, var);
            ctx.global.gvars.put(var.name, var);
            if (node.init != null && !(node.init.type instanceof NullType)) {
                node.init.accept(this);
                ValueIR _init = GetArithResult(node.init);
                ctx.addQuad(new Store(var, _init));
            }
        }   else {
            node.name = ctx.local.Rename(node.name);
			RegIR var = new RegIR(node.name);
            ctx.addQuad(new Alloc(var));
			if (node.init != null) {
			    if (!(node.init.type instanceof NullType)) {
                    node.init.accept(this);
                    ValueIR _init = GetArithResult(node.init);
                    ctx.addQuad(new Store(var, _init));
                }   else {
			        ValueIR _init = new ConstIR(0);
			        ctx.addQuad(new Store(var, _init));
                }
			}
			ctx.vars.put(node,var);
        }
    }

    @Override
    public void visit(FuncNode node) throws Exception {
        FuncIR fun = ctx.newFunc(node.global_name);
        ctx.global.funcs.put(node.global_name,fun);
        ctx.local = fun;
        for (VariableNode i:node.para) {
            i.name = fun.Rename(i.name);
        }
        if (node.ismethod) {
            node.para.add(0,new VariableNode(new ClassType(node.belong.name),"this",null));
        }
        for (VariableNode i:node.para) {
            fun.para_name.add(i.name);
        }
        for (int i=0;i<fun.para_name.size();i++) {
            RegIR var = new RegIR(fun.para_name.get(i));
            //RegIR reg = ctx.local.getTmpReg();
            fun.para_reg.add(var);//fun.para_reg.add(reg);
            ctx.addQuad(new Alloc(var));
            //ctx.addQuad(new Store(var,reg));
            if (fun.para_name.get(i).equals("this")) fun._this=var;
            ctx.vars.put(node.para.get(i),var);
        }
        for (StateNode i:node.body.statement) {
            i.accept(this);
        }
        ValueIR tmp = new RegIR("@void");
        ctx.addQuad(new Ret(tmp));
    }

    @Override
    public void visit(DefState node) throws Exception {
        visit(node.var);
    }

    @Override
    public void visit(ClassNode node) throws Exception {
        for (FuncNode i:node.method) {
            i.accept(this);
        }
        if (node.construction != null) node.construction.accept(this);
    }

    @Override
    public void visit(VarExpr node) throws Exception {
        VariableNode def = node.define;
        if (def.ismember) {
            RegIR _this = ctx.local._this;
            RegIR headPtr = ctx.local.getTmpReg();
            ctx.addQuad(new Load(headPtr,_this));
            ClassNode belong = def.belong;
            ConstIR offset = new ConstIR(belong.getoffset(node.name));
            RegIR memPtr = ctx.local.getTmpReg();
            ctx.addQuad(new Binary(memPtr,ADD,headPtr,offset));
            node.iraddr = memPtr;
        }   else {
            RegIR var = ctx.vars.get(def);
            node.iraddr = var;
        }
    }

    @Override
    public void visit(SufExpr node) throws Exception {
        node.a.accept(this);
        RegIR var = node.a.iraddr;

        ValueIR val = GetArithResult(node.a);
        RegIR newval = ctx.local.getTmpReg();

        Binary.Opcode op = (node.op.equals("++")) ? ADD :SUB;
        ctx.addQuad(new Binary(newval,op,val,new ConstIR(1)));
        ctx.addQuad(new Store(var,newval));

        node.iraddr=null;
        node.irvalue=val;
    }

    @Override
    public void visit(PreExpr node) throws Exception {
        node.a.accept(this);

        ValueIR val = GetArithResult(node.a);
        if (node.op.equals("++") || node.op.equals("--")) {
            RegIR var = node.a.iraddr;
            RegIR newval = ctx.local.getTmpReg();
            Binary.Opcode op = (node.op.equals("++")) ? ADD :SUB;
            ctx.addQuad(new Binary(newval,op,val,new ConstIR(1)));
            ctx.addQuad(new Store(var,newval));
            node.iraddr=var;
            node.irvalue = newval;
        }   else if (node.op.equals("-") || node.op.equals("~")) {
            RegIR newval = ctx.local.getTmpReg();
            Single.Opcode op = (node.op.equals("-")) ? NEGA : NOT;
            ctx.addQuad(new Single(newval,op,val));

            node.iraddr=null;
            node.irvalue=newval;
        }   else if (node.op.equals("!")) {
            RegIR newval = ctx.local.getTmpReg();
            ctx.addQuad(new Binary(newval, XOR, val, new ConstIR(1)));
            node.iraddr = null;
            node.irvalue = newval;
        }
    }

    @Override
    public void visit(BinaryExpr node) throws Exception {
        if (node.op.equals("&&")) {
            node.a.accept(this);
            BlockIR end = ctx.local.newBlock();
            BlockIR doit = ctx.local.newBlock();
            RegIR ans = ctx.local.getTmpReg();
            RegIR tmp  = ctx.local.getTmpReg();
            ctx.addQuad(new Single(tmp,NOT,GetArithResult(node.a)));
            ctx.addQuad(new CondJump(tmp,doit));
            BlockIR pre = ctx.local.now;
            ctx.local.now = doit;
            ctx.addQuad(new Assign(ans,new ConstIR(0)));
            ctx.addQuad(new Jump(end));
            ctx.local.now = pre;
            node.b.accept(this);
            ctx.addQuad(new Assign(ans,GetArithResult(node.b)));
            ctx.addQuad(new Jump(end));
            ctx.local.now = end;
            node.irvalue = ans;
        }   else if (node.op.equals("||")) {
            node.a.accept(this);
            BlockIR end = ctx.local.newBlock();
            BlockIR doit = ctx.local.newBlock();
            RegIR ans = ctx.local.getTmpReg();
            ctx.addQuad(new CondJump(GetArithResult(node.a),doit));
            BlockIR pre = ctx.local.now;
            ctx.local.now = doit;
            ctx.addQuad(new Assign(ans,new ConstIR(1)));
            ctx.addQuad(new Jump(end));
            ctx.local.now = pre;
            node.b.accept(this);
            ctx.addQuad(new Assign(ans,GetArithResult(node.b)));
            ctx.addQuad(new Jump(end));
            ctx.local.now = end;
            node.irvalue = ans;
        } else {
            node.a.accept(this);
            node.b.accept(this);

            RegIR ans = ctx.local.getTmpReg();
            ValueIR la = GetArithResult(node.a);
            ValueIR lb = GetArithResult(node.b);

            if (node.a.type.ac(new ClassType("string"))) {
                List<ValueIR> para = new LinkedList<>();
                para.add(la);
                para.add(lb);
                Call it = null;
                if (node.op.equals("+")) {
                    it = new Call("_string_add", ans, para);
                } else if (node.op.equals("<")) {
                    it = new Call("_string_less", ans, para);
                } else if (node.op.equals("<=")) {
                    it = new Call("_string_lessequal", ans, para);
                } else if (node.op.equals(">")) {
                    it = new Call("_string_great", ans, para);
                } else if (node.op.equals(">=")) {
                    it = new Call("_string_greaterequal", ans, para);
                } else if (node.op.equals("==")) {
                    it = new Call("_string_equal", ans, para);
                } else if (node.op.equals("!=")) {
                    it = new Call("_string_notequal", ans, para);
                }
                ctx.addQuad(it);
            } else {
                Binary.Opcode op = getop(node.op);
                ctx.addQuad(new Binary(ans, op, la, lb));
            }
            node.irvalue = ans;
        }
        return;
    }

    @Override
    public void visit(ExprState node) throws Exception {
        node.expression.accept(this);
    }

    @Override
    public void visit(IndexExpr node) throws Exception {
        node.left.accept(this);
        node.index.accept(this);

        ValueIR ind = GetArithResult(node.index);
        ValueIR baseoff = GetArithResult(node.left);
        RegIR ans = ctx.local.getTmpReg();
        RegIR offset = ctx.local.getTmpReg();
        RegIR offset2 = ctx.local.getTmpReg();
        ctx.addQuad(new Binary(offset,MUL,ind,new ConstIR(8)));
        ctx.addQuad(new Binary(offset2,ADD,offset,new ConstIR(8)));
        ctx.addQuad(new Binary(ans,ADD,baseoff,offset2));
        node.iraddr=ans;
    }

    @Override
    public void visit(AssignExpr node) throws Exception {
        node.l.accept(this);
        node.r.accept(this);

        RegIR dest=node.l.iraddr;
        ValueIR val = GetArithResult(node.r);

        ctx.addQuad(new Store(dest,val));

        node.iraddr = dest;
        node.irvalue = val;
    }

    @Override
    public void visit(MallocExpr node) throws Exception {
        if (node.type instanceof ArrayType) {
            for (Expr i:node.has) {
                i.accept(this);
            }
            RegIR tmp = newArray(node.has,0);
            node.irvalue = tmp;
        }   else {
            RegIR tmp = ctx.local.getTmpReg();
            ConstIR siz = new ConstIR(getsize(node.type));
            ctx.addQuad(new Malloc(tmp,siz));

            ClassNode def = ctx.classes.get(((ClassType)node.type).name);
            if (def.construction != null) {
                List<ValueIR> para = new LinkedList<>();para.add(tmp);
                ctx.addQuad(new Call(def.construction.global_name,new RegIR("@void"),para));
            }
            node.irvalue = tmp;
        }
    }

    @Override
    public void visit(MemberExpr node) throws Exception {
        node.left.accept(this);
        ValueIR lef = GetArithResult(node.left);
        RegIR ans = ctx.local.getTmpReg();

        ClassNode def = ctx.classes.get(((ClassType)node.left.type).name);
        ValueIR offset = new ConstIR(def.getoffset(node.name));
        ctx.addQuad(new Binary(ans,ADD,lef,offset));

        node.iraddr = ans;
    }

    @Override
    public void visit(FuncExpr node) throws Exception {
        List<ValueIR> para = new LinkedList<>();
        if (node.para!=null) {
            for (Expr i:node.para) {
                i.accept(this);
                para.add(GetArithResult(i));
            }
        }
        RegIR ret = (node.type.ac(new BasicType("void")))? new RegIR("@void"):ctx.local.getTmpReg();
        FuncNode def = ctx.func.get(node.name);

        if (def == null || !def.ismethod) {
            ctx.addQuad(new Call(node.name,ret,para));
        }   else {
            RegIR thisval = ctx.local.getTmpReg();
            ctx.addQuad(new Load(thisval,ctx.local._this));
            para.add(0,thisval);
            ctx.addQuad(new Call(node.name,ret,para));
        }
        node.irvalue = ret;
    }

    @Override
    public void visit(MethodExpr node) throws Exception {
        node.left.accept(this);

        RegIR inst= (RegIR) GetArithResult(node.left);

        List<ValueIR> para = new LinkedList<>();
        para.add(inst);

        if (node.para!=null) {
            for (Expr i:node.para) {
                i.accept(this);
                para.add(GetArithResult(i));
            }
        }

        RegIR ret = (node.type.ac(new BasicType("void")))? new RegIR("@void"):ctx.local.getTmpReg();

        String callname;
        if (node.left.type instanceof ArrayType) {
            callname = "_array_size";
        }   else {
            callname ='_'+ ((ClassType)node.left.type).name+'_'+node.name;
        }
        ctx.addQuad(new Call(callname,ret,para));
        node.irvalue = ret;
    }


    @Override
    public void visit(ReturnState node) throws Exception {
        ValueIR ret;
        if (node.ret!= null) {
            node.ret.accept(this);
            ret = GetArithResult(node.ret);
        }   else {
            ret= new RegIR("@void");
        }
        ctx.addQuad(new Ret(ret));
        ctx.stop.add(ctx.local.now);
    }

    @Override
    public void visit(EmptyState node) throws Exception {
        return;
    }

    @Override
    public void visit(ConstExpr node) throws Exception {
        if (node.type instanceof NullType) {
            ValueIR val = new ConstIR(0);
            node.irvalue = val;
        }   else if (node.type.ac(new BasicType("bool"))) {
            ValueIR val = new ConstIR(node.value.toLowerCase().equals("true")?1:0);
            node.irvalue = val;
        }   else if (node.type.ac(new BasicType("int"))) {
            ValueIR val = new ConstIR(Integer.parseInt(node.value));
            node.irvalue = val;
        }   else {
            ValueIR val = ctx.getConstString(node.value);
            node.irvalue = val;
        }
    }

    @Override
    public void visit(IfState node) throws Exception {
        BlockIR ifenter = ctx.local.newBlock();
        BlockIR iftrue = ctx.local.newBlock();
        BlockIR iffalse = ctx.local.newBlock();
        BlockIR ifend = ctx.local.newBlock();
        ctx.addQuad(new Jump(ifenter));
        ctx.local.now = ifenter;
        node.isnot.accept(this);
        ValueIR tmp = GetArithResult(node.isnot);
        ctx.addQuad(new CondJump(tmp,iftrue));
        ctx.addQuad(new Jump(iffalse));
        ctx.local.now = iftrue;
        if (node.istrue!=null) {
            node.istrue.accept(this);
        }
        ctx.addQuad(new Jump(ifend));
        ctx.local.now = iffalse;
        if (node.isfalse!=null) {
            node.isfalse.accept(this);
        }
        ctx.addQuad(new Jump(ifend));
        ctx.local.now = ifend;
    }

    @Override
    public void visit(BlockNode node) throws Exception {
        for (StateNode i:node.statement) {
            i.accept(this);
        }
    }

    @Override
    public void visit(ForState node) throws Exception {
        if (node.init!=null) node.init.accept(this);
        BlockIR forenter = ctx.local.newBlock();
        BlockIR fordoit = ctx.local.newBlock();
        BlockIR forupdate = ctx.local.newBlock();
        BlockIR forend = ctx.local.newBlock();
        BlockIR pre_forbegin = _forbegin;
        BlockIR pre_forend = _forend;
        _forbegin = forupdate;
        _forend = forend;
        ctx.addQuad(new Jump(forenter));
        ctx.local.now=forenter;
        if (node.isnot!=null) {
            node.isnot.accept(this);
            ValueIR tmp = GetArithResult(node.isnot);
            ctx.addQuad(new CondJump(tmp, fordoit));
            ctx.addQuad(new Jump(forend));
        }   else {
            ctx.addQuad(new Jump(fordoit));
        }
        ctx.local.now = fordoit;
        if (node.doit!=null) node.doit.accept(this);
        ctx.addQuad(new Jump(forupdate));
        ctx.local.now = forupdate;
        if (node.update!=null) node.update.accept(this);
        ctx.addQuad(new Jump(forenter));
        ctx.local.now = forend;
        _forbegin = pre_forbegin;
        _forend = pre_forend;
    }

    @Override
    public void visit(WhileState node) throws Exception {
        BlockIR forenter = ctx.local.newBlock();
        BlockIR fordoit = ctx.local.newBlock();
        BlockIR forend = ctx.local.newBlock();
        BlockIR pre_forbegin = _forbegin;
        BlockIR pre_forend = _forend;
        _forbegin = forenter;
        _forend = forend;
        ctx.addQuad(new Jump(forenter));
        ctx.local.now=forenter;
        node.isnot.accept(this);
        ValueIR tmp = GetArithResult(node.isnot);
        ctx.addQuad(new CondJump(tmp,fordoit));
        ctx.addQuad(new Jump(forend));
        ctx.local.now = fordoit;
        if (node.istrue!=null) node.istrue.accept(this);
        ctx.addQuad(new Jump(forenter));
        ctx.local.now = forend;
        _forbegin = pre_forbegin;
        _forend = pre_forend;
    }

    @Override
    public void visit(BreakState node) throws Exception {
        ctx.addQuad(new Jump(_forend));
    }

    @Override
    public void visit(ContinueState node) throws Exception {
        ctx.addQuad(new Jump(_forbegin));
    }
}
