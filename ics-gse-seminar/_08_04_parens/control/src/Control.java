public class Control {
    private final Logger logger;
    private final TokenStreamProducer tokenStreamProducer;
    private final TokenStreamConsumer tokenStreamConsumer;
    private final TreeProducer treeProducer;
    private final TreeConsumer treeConsumer;

    public Control(Logger logger, TokenStreamProducer tokenStreamProducer, TokenStreamConsumer tokenStreamConsumer,
                   TreeProducer treeProducer, TreeConsumer treeConsumer) {
        this.logger = logger;
        this.tokenStreamProducer = tokenStreamProducer;
        this.tokenStreamConsumer = tokenStreamConsumer;
        this.treeProducer = treeProducer;
        this.treeConsumer = treeConsumer;
    }

    public Object run() {
        logger.log("Control runs token stream producer");
        TokenStream tokenStream = tokenStreamProducer.produceTokenStream();
        logger.log("Control runs token stream consumer");
        tokenStreamConsumer.consumeTokenStream(tokenStream);
        logger.log("Control runs tree producer");
        Tree tree = treeProducer.produceTree();
        logger.log("Control runs tree consumer");
        return treeConsumer.consumeTree(tree);
    }
}
