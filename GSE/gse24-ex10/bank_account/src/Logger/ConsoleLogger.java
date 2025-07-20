package Logger;

import Interfaces.LoggingService;

public class ConsoleLogger implements LoggingService {

	@Override
	public void log(String message) {
		System.out.println(message);
	}
}
