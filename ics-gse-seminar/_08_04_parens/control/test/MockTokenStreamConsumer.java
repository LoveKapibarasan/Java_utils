public class MockTokenStreamConsumer implements TokenStreamConsumer {
    private final MockContext mockContext;

    public MockTokenStreamConsumer(MockContext mockContext) {
        this.mockContext = mockContext;
    }

    @Override
    public void consumeTokenStream(TokenStream input) {
        mockContext.addAction(MockContext.CONSUME_TOKEN_STREAM);
    }
}
