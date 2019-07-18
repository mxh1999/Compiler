package beta1.IR;

import java.util.LinkedHashMap;
import java.util.Map;

public class ProgramIR {
    public Map<String,FuncIR> funcs = new LinkedHashMap<>();
    public Map<String,FuncIR> func = new LinkedHashMap<>();
    public Map<String,RegIR> gvars = new LinkedHashMap<>();

}
