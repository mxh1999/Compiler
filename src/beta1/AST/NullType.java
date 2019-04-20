package beta1.AST;

public class NullType extends Type {
    @Override
    public boolean ac(Type other) {
        return (other instanceof ClassType && !(((ClassType) other).name.equals("string"))) || other instanceof  ArrayType;
    }
}
