public class Client {
	public static void main(String[] args) {
		FahrenheitWeatherDisplay fwd = new FahrenheitWeatherDisplay();
		fwd.setCurrentTemperatureFahrenheit(100.0);
		CelsiusTemperatureReader reader = new FahrenheitToCelsiusAdapter(fwd);
		CelsiusTemperaturePrinter printer = new CelsiusTemperaturePrinter(reader);
		printer.printCurrentTemperature();
	}
}
