import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {
    private LinkedList list1;
    private LinkedList list3;

    @Before
    public void setUp() {
        list1 = new LinkedList("I'm a single list.");
        list3 = new LinkedList("Hello");
        list3.add("three-elements");
        list3.add("list");
    }

    @Test
    public void testGetValue() {
        assertEquals("I'm a single list.", list1.getValue());
        assertEquals("Hello", list3.getValue());
    }

    @Test
    public void testAdd() {
        assertNull(list1.getNext());

        list1.add("with a good friend.");

        assertNotNull(list1.getNext());
        assertEquals("I'm a single list.", list1.getValue());
        assertEquals("with a good friend.", list1.getNext().getValue());
    }

    @Test
    public void testAddRecursive() {
        assertNull(list3.getNext().getNext().getNext());

        list3.add("extended");

        assertNotNull(list3.getNext().getNext().getNext());
        assertEquals("Hello", list3.getValue());
        assertEquals("three-elements", list3.getNext().getValue());
        assertEquals("list", list3.getNext().getNext().getValue());
        assertEquals("extended", list3.getNext().getNext().getNext().getValue());
    }

    @Test
    public void testToString() {
        assertEquals("[I'm a single list.]", list1.toString());
    }

    @Test
    public void testToStringRecursive() {
        assertEquals("[Hello, three-elements, list]", list3.toString());
    }
}
