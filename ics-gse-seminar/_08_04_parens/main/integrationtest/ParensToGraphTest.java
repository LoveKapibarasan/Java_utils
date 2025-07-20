import org.graphstream.graph.Graph;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParensToGraphTest {

    @Test(expected=IllegalArgumentException.class)
    public void testRunNullInput() {
        run(null);
    }

    @Test public void testRunEmptyInput() {
        Graph g = (Graph) ParensToGraph.run("");
        assertEquals(1, g.getNodeCount());
        assertEquals(0, g.getEdgeCount());
    }

    @Test
    public void testRunRealInput() {
        Graph g = (Graph) ParensToGraph.run("()(())((()()))");
        assertEquals(8, g.getNodeCount());
        assertEquals(7, g.getEdgeCount());
        assertNotNull(g.getNode("7"));
        assertNotNull(g.getEdge("6_8"));
    }
}
