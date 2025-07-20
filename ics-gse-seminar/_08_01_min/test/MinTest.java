import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MinTest {

    @Test(expected = IllegalArgumentException.class)
    public void testNullList() {
        Min.min(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyList() {
        Min.min(Arrays.<Integer>asList());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testListWithNull() {
        Min.min(Arrays.asList(1, null));
    }

    // ---

    @Test public void testSingleElementList() {
        int actual = Min.min(Arrays.asList(1));
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test public void testTwoElementList() {
        int actual = Min.min(Arrays.asList(1, 2));
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test public void testSortedList() {
        int actual = Min.min(Arrays.asList(1, 2, 3));
        int expected = 1;
        assertEquals(expected, actual);
    }

    // ---

    @Test public void testInverselySortedList() {

    }

    @Test public void testNonSortedList() {

    }

    @Test public void testListWithMultipleOccurrenceOfNonMinElement() {

    }

    // ---

    @Test public void testListWithMultipleOccurrenceOfMinElement() {

    }

    @Test public void testLargeList() {

    }

    @Test public void testListWhereMinIsNotOne() {

    }
}
