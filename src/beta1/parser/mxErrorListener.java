package beta1.parser;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class mxErrorListener extends BaseErrorListener {
    private mxErrorRecorder er;

    public mxErrorListener(mxErrorRecorder _er) {
        er=_er;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        er.addRecord(msg);
    }
}
