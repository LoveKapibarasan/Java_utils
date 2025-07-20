public class MockTreeConsumer implements TreeConsumer {
    private final MockContext mockContext;

    public MockTreeConsumer(MockContext mockContext) {
        this.mockContext = mockContext;
    }

    @Override
    public Object consumeTree(Tree input) {
        mockContext.addAction(MockContext.CONSUME_TREE);
        return new Object();
    }
}
