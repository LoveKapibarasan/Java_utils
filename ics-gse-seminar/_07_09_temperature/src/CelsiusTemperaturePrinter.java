public class CelsiusTemperaturePrinter {
	private CelsiusTemperatureReader reader;
	public CelsiusTemperaturePrinter(CelsiusTemperatureReader reader) {
		this.reader = reader;
	}
	public void printCurrentTemperature() {
		System.out.println("It is " + reader.getTemperatureInDegreeCelsius() + "°C.");
	}
}
