import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ParserTest {
    private Parser instance;

    @Before
    public void setUp() {
        instance = new Parser(new DummyLogger());
    }

    @Test(expected=IllegalStateException.class)
    public void testNullInput() {
        instance.produceTree();
    }

    @Test public void testEmptyInput() {
        instance.consumeTokenStream(tokenStreamOf());
        Tree tree = instance.produceTree();
        assertEquals(1, tree.getId());
        assertTrue(tree.getChildren().isEmpty());
    }

    @Test(expected= IllegalStateException.class)
    public void testUnbalancedTooManyOpen() {
        instance.consumeTokenStream(tokenStreamOf(Token.OPEN, Token.OPEN, Token.CLOSE));
        instance.produceTree();
    }

    @Test(expected=IllegalStateException.class)
    public void testUnbalancedTooManyClose() {
        instance.consumeTokenStream(tokenStreamOf(Token.OPEN, Token.CLOSE, Token.CLOSE));
        instance.produceTree();
    }

    @Test public void testSingle() { // ()
        instance.consumeTokenStream(tokenStreamOf(Token.OPEN, Token.CLOSE));
        Tree tree = instance.produceTree();
        assertEquals(1, tree.getId());
        assertEquals(1, tree.getChildren().size());
        assertEquals(2, tree.getChildren().getFirst().getId());
        assertEquals(0, tree.getChildren().getFirst().getChildren().size());
    }

    @Test public void testFlat() { // ()()()
        instance.consumeTokenStream(tokenStreamOf(Token.OPEN, Token.CLOSE, Token.OPEN, Token.CLOSE, Token.OPEN, Token.CLOSE));
        Tree tree = instance.produceTree();
        assertEquals(1, tree.getId());
        assertEquals(3, tree.getChildren().size());
        assertEquals(2, tree.getChildren().getFirst().getId());
        assertEquals(0, tree.getChildren().getFirst().getChildren().size());
        assertEquals(3, tree.getChildren().get(1).getId());
        assertEquals(0, tree.getChildren().get(1).getChildren().size());
        assertEquals(4, tree.getChildren().get(2).getId());
        assertEquals(0, tree.getChildren().get(2).getChildren().size());
    }

    @Test public void testDeep() { // ((()))
        instance.consumeTokenStream(tokenStreamOf(Token.OPEN, Token.OPEN, Token.OPEN, Token.CLOSE, Token.CLOSE, Token.CLOSE));
        Tree tree = instance.produceTree();
        assertEquals(1, tree.getId());
        assertEquals(1, tree.getChildren().size());
        assertEquals(2, tree.getChildren().getFirst().getId());
        assertEquals(1, tree.getChildren().getFirst().getChildren().size());
        assertEquals(3, tree.getChildren().getFirst().getChildren().getFirst().getId());
        assertEquals(1, tree.getChildren().getFirst().getChildren().getFirst().getChildren().size());
        assertEquals(4, tree.getChildren().getFirst().getChildren().getFirst().getChildren().getFirst().getId());
        assertEquals(0, tree.getChildren().getFirst().getChildren().getFirst().getChildren().getFirst().getChildren().size());
    }

    @Test public void testMultiple() { // ()(())((()()))
        instance.consumeTokenStream(tokenStreamOf(Token.OPEN, Token.CLOSE,
                Token.OPEN, Token.OPEN, Token.CLOSE, Token.CLOSE,
                Token.OPEN, Token.OPEN, Token.OPEN, Token.CLOSE,
                Token.OPEN, Token.CLOSE, Token.CLOSE, Token.CLOSE));
        Tree tree = instance.produceTree();
        assertEquals(1, tree.getId());
        assertEquals(3, tree.getChildren().size());
        assertEquals(2, tree.getChildren().getFirst().getId());
        assertEquals(0, tree.getChildren().getFirst().getChildren().size());
        assertEquals(3, tree.getChildren().get(1).getId());
        assertEquals(1, tree.getChildren().get(1).getChildren().size());
        assertEquals(4, tree.getChildren().get(1).getChildren().getFirst().getId());
        assertEquals(0, tree.getChildren().get(1).getChildren().getFirst().getChildren().size());
        assertEquals(5, tree.getChildren().get(2).getId());
        assertEquals(1, tree.getChildren().get(2).getChildren().size());
        assertEquals(6, tree.getChildren().get(2).getChildren().getFirst().getId());
        assertEquals(2, tree.getChildren().get(2).getChildren().getFirst().getChildren().size());
        assertEquals(7, tree.getChildren().get(2).getChildren().getFirst().getChildren().getFirst().getId());
        assertEquals(0, tree.getChildren().get(2).getChildren().getFirst().getChildren().getFirst().getChildren().size());
        assertEquals(8, tree.getChildren().get(2).getChildren().getFirst().getChildren().get(1).getId());
        assertEquals(0, tree.getChildren().get(2).getChildren().getFirst().getChildren().get(1).getChildren().size());
    }

    private TokenStream tokenStreamOf(Token... tokens) {
        TokenStream ts = new TokenStream();
        Arrays.asList(tokens).forEach(ts::addToken);
        return ts;
    }
}
