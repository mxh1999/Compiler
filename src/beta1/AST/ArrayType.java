package beta1.AST;

public class ArrayType extends Type {
    public SingleType base;
    public int dimension;

    public ArrayType(SingleType _base,int _dimension){
        base=_base;
        dimension=_dimension;
    }

    public ArrayType(ArrayType _t) {
        base = _t.base;
        dimension = _t.dimension;
    }
    @Override
    public boolean ac(Type other) {
        if (other instanceof ArrayType) return base.ac(((ArrayType) other).base) && dimension == ((ArrayType) other).dimension;
        return other instanceof NullType;
    }
}
