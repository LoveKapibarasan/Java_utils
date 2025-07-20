public class IntToRoman {
	/*
	public static String apply(int n) {
		if (n < 1 || n > 3999) {
			throw new IllegalArgumentException("Not convertible to roman numeral: " + n);
		}
		StringBuilder sb = new StringBuilder();
		if (n >= 5) {
			n -= 5;
			sb.append("V");
		}
		if (n == 4) {
			sb.append("IV");
		} else {
			while (n > 0) {
				n--;
				sb.append("I");
			}
		}
		return sb.toString();
	}
*/


	public static String apply(int n) {
			if (n < 1 || n > 3999) {
				throw new IllegalArgumentException("Not convertible to Roman numeral: " + n);
			}

			// Roman numeral mappings
			int[] values =    {1000, 900, 500, 400, 100,  90,  50,  40,  10,   9,   5,   4,   1};
			String[] numerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

			StringBuilder sb = new StringBuilder();

			// Loop through values and build Roman numeral
			for (int i = 0; i < values.length; i++) {
				while (n >= values[i]) {
					n -= values[i];
					sb.append(numerals[i]);
				}
			}
			/*
			IntStream.range(0, values.length).forEach(i -> {
            while (num[0] >= values[i]) {
                num[0] -= values[i];
                sb.append(numerals[i]);
            }
            });
			 */

			return sb.toString();
		}
}
