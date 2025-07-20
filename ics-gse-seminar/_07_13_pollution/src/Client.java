public class Client {
	public static void main(String[] args) {
		AirPollutionSensor sensor = new AirPollutionSensor();
		sensor.setPollution(30);
		sensor.addPropertyChangeListener(new AirPollutionDisplay());
		sensor.setPollution(40);
		sensor.setPollution(35);
	}
}
