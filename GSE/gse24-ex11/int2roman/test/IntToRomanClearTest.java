import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class IntToRomanClearTest {

    @Parameterized.Parameters(name = "{index}: IntToRoman({0}) = \"{1}\"")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {9, "IX"}, {10, "X"}, {12, "XII"}, {24, "XXIV"},
                {37, "XXXVII"}, {40, "XL"}, {52, "LII"}, {64, "LXIV"},
                {79, "LXXIX"}, {97, "XCVII"}, {99, "XCIX"}, {123, "CXXIII"},
                {268, "CCLXVIII"}, {284, "CCLXXXIV"}, {314, "CCCXIV"},
                {349, "CCCXLIX"}, {435, "CDXXXV"}, {700, "DCC"},
                {909, "CMIX"}, {1234, "MCCXXXIV"}, {2024, "MMXXIV"}, {3999, "MMMCMXCIX"}
        });
    }

    private final int input;
    private final String expected;

    public IntToRomanClearTest(int input, String expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void testRomanConversion() {
        assertEquals(expected, IntToRoman.apply(input));
    }
}
