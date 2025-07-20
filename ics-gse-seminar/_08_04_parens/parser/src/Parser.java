import java.util.Stack;

public class Parser implements TokenStreamConsumer, TreeProducer {
    private TokenStream input = null;
    private final Logger logger;

    public Parser(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void consumeTokenStream(TokenStream input) {
        this.input = input;
    }

    @Override
    public Tree produceTree() {
        int idCounter = 0;
        if (input == null) {
            throw new IllegalStateException("input==null");
        }
        Stack<Tree> s = new Stack<>();
        s.add(new Tree(++idCounter));
        for (Token t : input.getTokens()) {
            if (t == Token.OPEN) {
                Tree next = new Tree(++idCounter);
                s.peek().addChild(next);
                s.push(next);
                logger.log("Parser recognizes '('");
            } else if (s.size() > 1) {
                s.pop();
                logger.log("Parser recognizes ')'");
            } else {
                throw new IllegalStateException("unbalanced token stream");
            }
        }
        if (s.size() != 1) {
            throw new IllegalStateException("unbalanced token stream");
        }
        return s.pop();
    }
}
