public class MockTokenStreamProducer implements TokenStreamProducer {
    private final MockContext mockContext;

    public MockTokenStreamProducer(MockContext mockContext) {
        this.mockContext = mockContext;
    }

    @Override
    public TokenStream produceTokenStream() {
        mockContext.addAction(MockContext.PRODUCE_TOKEN_STREAM);
        return new TokenStream();
    }
}
