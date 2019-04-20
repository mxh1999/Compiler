package beta1;

import beta1.AST.BuildAST;
import beta1.AST.ProgNode;
import beta1.SymbolTable.BuildST;
import beta1.SymbolTable.CheckST;
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
        //is =new FileInputStream("D:\\compiler\\mxh\\Compiler\\testcase\\testcase_85.txt");
        ANTLRInputStream input = new ANTLRInputStream(is);
        mxLexer lexer = new mxLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        mxParser parser = new mxParser(tokens);

        ParseTree tree = parser.program();

        BuildAST buildast = new BuildAST();
        buildast.visit(tree);

        ProgNode program = buildast.prog;

        BuildST buildst = new BuildST();
        program.accept(buildst);

        CheckST checkst = new CheckST(buildst);
        program.accept(checkst);
    }
}
