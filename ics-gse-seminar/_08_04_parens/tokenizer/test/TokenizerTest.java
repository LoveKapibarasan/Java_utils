import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TokenizerTest {
    private Tokenizer instance;

    @Before public void setUp() {
        instance = new Tokenizer(new DummyLogger());
    }

    @Test(expected=IllegalStateException.class)
    public void testNullInput() {
        instance.produceTokenStream();
    }

    @Test public void testEmptyInput() {
        instance.setInput("");
        TokenStream ts = instance.produceTokenStream();
        assertTrue(ts.getTokens().isEmpty());
    }

    @Test public void testSingleOpen() {
        instance.setInput("(");
        TokenStream ts = instance.produceTokenStream();
        assertEquals(1, ts.getTokens().size());
        assertEquals(Token.OPEN, ts.getTokens().getFirst());
    }

    @Test public void testSingleClose() {
        instance.setInput(")");
        TokenStream ts = instance.produceTokenStream();
        assertEquals(1, ts.getTokens().size());
        assertEquals(Token.CLOSE, ts.getTokens().getFirst());
    }

    @Test public void testSingleUnmatched() {
        instance.setInput(":-]");
        TokenStream ts = instance.produceTokenStream();
        assertTrue(ts.getTokens().isEmpty());
    }

    @Test public void testMultiple() {
        instance.setInput("()(())((()()))");
        TokenStream ts = instance.produceTokenStream();
        assertEquals(14, ts.getTokens().size());
        assertEquals(List.of(Token.OPEN, Token.CLOSE,
                        Token.OPEN, Token.OPEN, Token.CLOSE, Token.CLOSE,
                        Token.OPEN, Token.OPEN, Token.OPEN, Token.CLOSE,
                        Token.OPEN, Token.CLOSE, Token.CLOSE, Token.CLOSE),
                ts.getTokens());
    }

    @Test public void testMultipleWithUnmatched() {
        instance.setInput("(:)((asdf))((/()<>())\\)");
        TokenStream ts = instance.produceTokenStream();
        assertEquals(14, ts.getTokens().size());
        assertEquals(List.of(Token.OPEN, Token.CLOSE,
                        Token.OPEN, Token.OPEN, Token.CLOSE, Token.CLOSE,
                        Token.OPEN, Token.OPEN, Token.OPEN, Token.CLOSE,
                        Token.OPEN, Token.CLOSE, Token.CLOSE, Token.CLOSE),
                ts.getTokens());
    }
}
