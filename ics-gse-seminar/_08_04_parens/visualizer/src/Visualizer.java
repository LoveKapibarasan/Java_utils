import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

public class Visualizer implements TreeConsumer {
    private final Logger logger;
    private Graph graph;

    public Visualizer(Logger logger) {
        this.logger = logger;
    }

    @Override
    public Graph consumeTree(Tree input) {
        if (input == null) {
            throw new IllegalArgumentException("input == null");
        }
        System.setProperty("org.graphstream.ui", "swing");
        graph = new SingleGraph("");
        addNodes(input);
        addEdges(input);
        graph.display();
        return graph;
    }

    private void addNodes(Tree input) {
        logger.log("Visualizer adds graph node: " + input.getId());
        graph.addNode("" + input.getId());
        for (Tree child : input.getChildren()) {
            addNodes(child);
        }
    }

    private void addEdges(Tree input) {
        for (Tree child : input.getChildren()) {
            String edgeId = input.getId() + "_" + child.getId();
            logger.log("Visualizer adds edge: " + edgeId);
            graph.addEdge(edgeId, "" + input.getId(), "" + child.getId());
            addEdges(child);
        }
    }

}
