package beta1;

import beta1.AST.BuildAST;
import beta1.AST.ProgNode;
import beta1.SymbolTable.BuildST;
import beta1.SymbolTable.CheckST;
import beta1.parser.mxErrorListener;
import beta1.parser.mxErrorRecorder;
import beta1.parser.mxLexer;
import beta1.parser.mxParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.FileInputStream;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws Exception{
        InputStream is;
        is =System.in;
        //is =new FileInputStream("D:\\compiler\\mxh\\Compiler\\testcase\\testcase_174.txt");
        ANTLRInputStream input = new ANTLRInputStream(is);
        mxLexer lexer = new mxLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        mxParser parser = new mxParser(tokens);

        mxErrorRecorder error = new mxErrorRecorder();
        parser.removeErrorListeners();
        mxErrorListener errorlistener = new mxErrorListener(error);
        parser.addErrorListener(errorlistener);
        ParseTree tree = parser.program();

        if (error.hasError()) {
            throw new Exception("antlr error");
        }

        BuildAST buildast = new BuildAST();
        buildast.visit(tree);

        ProgNode program = buildast.prog;

        BuildST buildst = new BuildST();
        program.accept(buildst);
        buildst.checkmain();

        CheckST checkst = new CheckST(buildst);
        program.accept(checkst);
    }
}
