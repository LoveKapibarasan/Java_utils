public class FahrenheitToCelsiusAdapter implements CelsiusTemperatureReader {
	private FahrenheitWeatherDisplay adaptee;
	public FahrenheitToCelsiusAdapter(FahrenheitWeatherDisplay adaptee) {
		this.adaptee = adaptee;
	}
	@Override public double getTemperatureInDegreeCelsius() {
		return (adaptee.getCurrentTemperatureFahrenheit() - 32.0) * (5.0 / 9.0);
	}
}
