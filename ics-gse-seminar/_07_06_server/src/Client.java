import com.google.inject.Inject;

public class Client {

	private IServer server;
	
	@Inject	public Client(IServer server) {
		this.server = server;
	}
	
	public void printServerResponse() {
		System.out.println(server.getResponse());
	}

}
