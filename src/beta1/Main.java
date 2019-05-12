package beta1;

import beta1.AST.BuildAST;
import beta1.AST.ProgNode;
import beta1.IR.BuildIR;
import beta1.IR.IRContext;
import beta1.SymbolTable.BuildST;
import beta1.SymbolTable.CheckST;
import beta1.Trans.Translator;
import beta1.parser.mxErrorListener;
import beta1.parser.mxErrorRecorder;
import beta1.parser.mxLexer;
import beta1.parser.mxParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Main {
    public static void main(String[] args) throws Exception{
        InputStream is;
        is =System.in;
        //is =new FileInputStream("D:\\compiler\\mxh\\Compiler\\0.txt");
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

        IRContext ir = new IRContext();
        BuildIR buildir = new BuildIR(ir);
        buildir.visit(program);

        Translator translator = new Translator(ir);
        OutputStream out = System.out;
        //OutputStream out = new FileOutputStream("D:\\compiler\\mxh\\Compiler\\test.asm");
        byte outdata[] = translator.IRtoNASM().getBytes();
        out.write(outdata);
        out.close();
    }
}
