public class MockTreeProducer implements TreeProducer {
    private final MockContext mockContext;

    public MockTreeProducer(MockContext mockContext) {
        this.mockContext = mockContext;
    }

    @Override
    public Tree produceTree() {
        mockContext.addAction(MockContext.PRODUCE_TREE);
        return new Tree(0);
    }
}
