package beta1.AST;

import beta1.SymbolTable.SymbolTable;

import java.util.LinkedList;
import java.util.List;

public class BlockNode extends StateNode {
    public List<StateNode> statement;

    public SymbolTable st = null;

    public void add(StateNode state) {
        statement.add(state);
    }
    public BlockNode() {
        statement = new LinkedList<>();
    }
    @Override
    public void accept(ASTVisitor visitor) throws Exception{
        visitor.visit(this);
    }
}
