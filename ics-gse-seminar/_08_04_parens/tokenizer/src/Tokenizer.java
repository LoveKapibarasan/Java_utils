public class Tokenizer implements TokenStreamProducer {
    private final Logger logger;
    private String input;

    public Tokenizer(Logger logger) {
        this.logger = logger;
    }

    public void setInput(String input) {
        this.input = input;
    }

    @Override
    public TokenStream produceTokenStream() {
        if (input == null) {
            throw new IllegalStateException("input==null");
        }
        TokenStream result = new TokenStream();
        for (char c : input.toCharArray()) {
            logger.log("Tokenizer receives input: " + c);
            switch (c) {
                case '(': result.addToken(Token.OPEN); break;
                case ')': result.addToken(Token.CLOSE); break;
            }
        }
        return result;
    }
}
