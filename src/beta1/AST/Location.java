package beta1.AST;

import org.antlr.v4.runtime.Token;

public class Location {
    public int row,col;
    public Location(int row,int col) {
        this.row=row;
        this.col=col;
    }
    public Location(Token token) {
        row=token.getLine();
        col=token.getCharPositionInLine();
    }
    public boolean less(Location other) {
        if (row!=other.row) return row<other.row;
        return col<other.col;
    }
}
