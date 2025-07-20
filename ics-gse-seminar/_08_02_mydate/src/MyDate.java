public class MyDate implements Comparable<MyDate> {
	private final int day;
	private final int month;
	private final int year;
	
	public MyDate(int day, int month, int year) {
		// implementation unknown (black box)
		if (day < 1 || day > 31 || month < 1 || month > 12) {
			throw new IllegalArgumentException();
		}
		this.day = day;
		this.month = month;
		this.year = year;
	}

	@Override
	public int compareTo(MyDate that) {
		// implementation unknown (black box)
		if (that == null) throw new IllegalArgumentException("MyDate.compareTo");
		if (this.year != that.year) {
			return this.year - that.year;
		}
		if (this.month != that.month) {
			return this.month - that.month;
		}
		return this.day - that.day;
	}
}

