import org.graphstream.graph.Graph;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VisualizerTest {
    private Visualizer instance;

    @Before
    public void setUp() {
        instance = new Visualizer(new DummyLogger());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullInput() {
        instance.consumeTree(null);
    }

    @Test public void testSingle() { // ()
        Graph g = instance.consumeTree(new Tree(1));
        g.display(false);
        assertEquals(1, g.getNodeCount());
        assertEquals(0, g.getEdgeCount());
        assertNotNull(g.getNode("1"));
        assertNull(g.getNode("2"));
    }

    @Test public void testFlat() { // ()()()
        Graph g = instance.consumeTree(new Tree(1).addChild(new Tree(2)).addChild(new Tree(3)).addChild(new Tree(4)));
        g.display(false);
        assertEquals(4, g.getNodeCount());
        assertEquals(3, g.getEdgeCount());
        assertNotNull(g.getNode("1"));
        assertNotNull(g.getNode("2"));
        assertNotNull(g.getNode("3"));
        assertNotNull(g.getNode("4"));
        assertNull(g.getNode("5"));
        assertNotNull(g.getEdge("1_2"));
        assertNotNull(g.getEdge("1_3"));
        assertNotNull(g.getEdge("1_4"));
        assertNull(g.getNode("2_1"));
    }

    @Test public void testDeep() { // ((()))
        Graph g = instance.consumeTree(new Tree(1).addChild(new Tree(2).addChild(new Tree(3).addChild(new Tree(4)))));
        g.display(false);
        assertEquals(4, g.getNodeCount());
        assertEquals(3, g.getEdgeCount());
        assertNotNull(g.getNode("1"));
        assertNotNull(g.getNode("2"));
        assertNotNull(g.getNode("3"));
        assertNotNull(g.getNode("4"));
        assertNull(g.getNode("5"));
        assertNotNull(g.getEdge("1_2"));
        assertNotNull(g.getEdge("2_3"));
        assertNotNull(g.getEdge("3_4"));
        assertNull(g.getNode("2_1"));
    }

    @Test public void testMultiple() { // ()(())((()()))
        Graph g = instance.consumeTree(new Tree(1)
                .addChild(new Tree(2))
                .addChild(new Tree(3).addChild(new Tree(4)))
                .addChild(new Tree(5).addChild(new Tree(6).addChild(new Tree(7)).addChild(new Tree(8)))));
        assertEquals(8, g.getNodeCount());
        assertEquals(7, g.getEdgeCount());
        assertNotNull(g.getNode("1"));
        assertNotNull(g.getNode("2"));
        assertNotNull(g.getNode("3"));
        assertNotNull(g.getNode("4"));
        assertNotNull(g.getNode("5"));
        assertNotNull(g.getNode("6"));
        assertNotNull(g.getNode("7"));
        assertNotNull(g.getNode("8"));
        assertNull(g.getNode("9"));
        assertNotNull(g.getEdge("1_2"));
        assertNotNull(g.getEdge("1_3"));
        assertNotNull(g.getEdge("3_4"));
        assertNotNull(g.getEdge("1_5"));
        assertNotNull(g.getEdge("5_6"));
        assertNotNull(g.getEdge("6_7"));
        assertNotNull(g.getEdge("6_8"));
        assertNull(g.getNode("2_1"));
    }
}