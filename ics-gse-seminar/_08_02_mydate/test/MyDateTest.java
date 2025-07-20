import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyDateTest {
	
	@Test
	public void invalidDate() {
		assertThrows(IllegalArgumentException.class, () -> new MyDate(-1, 11, 2023));
	}
	
	@Test
	public void differentDay() {
		assertTrue(new MyDate(1, 11, 2023).compareTo(new MyDate(2, 11, 2023)) < 0);
	}
	
	@Test
	public void differentMonth() {
		assertTrue(new MyDate(1, 12, 2023).compareTo(new MyDate(1, 11, 2023)) > 0);
	}
	
	@Test
	public void differentYear() {
		assertTrue(new MyDate(1, 11, 2023).compareTo(new MyDate(1, 11, 2024)) < 0);
	}

}
