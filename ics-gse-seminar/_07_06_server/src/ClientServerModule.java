import com.google.inject.AbstractModule;

public class ClientServerModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(IServer.class).to(ServerImpl.class);
	}
}
