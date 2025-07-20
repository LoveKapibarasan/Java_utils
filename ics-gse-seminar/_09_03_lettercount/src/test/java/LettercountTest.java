import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LettercountTest {
    @Test(expected = IllegalArgumentException.class)
    public void testNullArray() {
        Lettercount.countLetter((String[]) null, 'x');
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullString() {
        Lettercount.countLetter((String) null, 'x');
    }

    @Test public void testEmptyArray() {
        assertEquals(0, Lettercount.countLetter(new String[]{}, 'x'));
    }

    @Test public void testEmptyString() {
        assertEquals(0, Lettercount.countLetter("", 'x'));
    }

    @Test public void testNonEmptyArray() {
        assertEquals(3, Lettercount.countLetter(new String[]{"Hello", "World"}, 'l'));
    }

    @Test public void testNonEmptyString() {
        assertEquals(3, Lettercount.countLetter("Hello, World!", 'l'));
    }
}
