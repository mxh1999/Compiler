package beta1.parser;

import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

public class mxErrorRecorder {
    private List<String> errors;

    public mxErrorRecorder(){
        errors = new LinkedList<>();
    }

    public void addRecord(String msg){
        StackTraceElement[] stacks = new Throwable().getStackTrace();
        errors.add(msg);
    }

    public boolean hasError(){return !errors.isEmpty();}
}
