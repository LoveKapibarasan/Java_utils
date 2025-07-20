import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntToRomanTest {

	@Test(expected = IllegalArgumentException.class)
	public void testIllegalArgument() {
		IntToRoman.apply(-1);
	}
	
	@Test
	public void testSet1() {
		assertEquals("I", IntToRoman.apply(1));
		assertEquals("VII", IntToRoman.apply(7));
	}
	@Test
	public void testSet2() {
		assertEquals("IV", IntToRoman.apply(4)); // covers n == 4
		assertEquals("V", IntToRoman.apply(5));  // covers n >= 5, then n == 0
	}
	/*===  Test 3 ===*/
	@Test public void test9()  { assertEquals("IX", IntToRoman.apply(9)); }
	@Test public void test10() { assertEquals("X", IntToRoman.apply(10)); }
	@Test public void test12() { assertEquals("XII", IntToRoman.apply(12)); }
	@Test public void test24() { assertEquals("XXIV", IntToRoman.apply(24)); }
    /*===  Test 4 ===*/
	@Test public void test37() { assertEquals("XXXVII", IntToRoman.apply(37)); }
	@Test public void test40() { assertEquals("XL", IntToRoman.apply(40)); }
	@Test public void test52() { assertEquals("LII", IntToRoman.apply(52)); }
	@Test public void test64() { assertEquals("LXIV", IntToRoman.apply(64)); }
	/*=== Test 5 ===*/
	@Test public void test79()  { assertEquals("LXXIX", IntToRoman.apply(79)); }
	@Test public void test97()  { assertEquals("XCVII", IntToRoman.apply(97)); }
	@Test public void test99()  { assertEquals("XCIX", IntToRoman.apply(99)); }
	@Test public void test123() { assertEquals("CXXIII", IntToRoman.apply(123)); }
	/*=== ===*/
	@Test public void test268() { assertEquals("CCLXVIII", IntToRoman.apply(268)); }
	@Test public void test284() { assertEquals("CCLXXXIV", IntToRoman.apply(284)); }
	@Test public void test314() { assertEquals("CCCXIV", IntToRoman.apply(314)); }

	/*=== ===*/
	@Test public void test349() { assertEquals("CCCXLIX", IntToRoman.apply(349)); }
	@Test public void test435() { assertEquals("CDXXXV", IntToRoman.apply(435)); }
	@Test public void test700() { assertEquals("DCC", IntToRoman.apply(700)); }

	/*=== ===*/
	@Test public void test909()  { assertEquals("CMIX", IntToRoman.apply(909)); }
	@Test public void test1234() { assertEquals("MCCXXXIV", IntToRoman.apply(1234)); }
	@Test public void test2024() { assertEquals("MMXXIV", IntToRoman.apply(2024)); }
	@Test public void test3999() { assertEquals("MMMCMXCIX", IntToRoman.apply(3999)); }
}
