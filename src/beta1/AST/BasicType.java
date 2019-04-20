package beta1.AST;

import beta1.parser.mxParser;

public class BasicType extends SingleType {
    public String name;

    public BasicType(String _name) {
        name=_name;
    }

    @Override
    public boolean ac(Type other) {
        return other instanceof BasicType && ((BasicType) other).name.equals(name);
    }
}