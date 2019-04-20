package beta1.AST;

public class ClassType extends SingleType {
    public String name;

    public ClassType(String _name) {
        name = _name;
    }
    @Override
    public boolean ac(Type other) {
        if (other instanceof NullType) {
            if (name.equals("string"))  return false;
            return true;
        }
        if (other instanceof ClassType) return ((ClassType) other).name.equals(name);
        return false;
    }
}
