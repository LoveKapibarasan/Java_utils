import Interfaces.LoggingService;
import Interfaces.PaymentService;
import Logger.ConsoleLogger;
import Payments.ProductionPaymentService;
import com.google.inject.AbstractModule;

public class ProductionModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(LoggingService.class).to(ConsoleLogger.class);
		bind(PaymentService.class).to(ProductionPaymentService.class);
	}
}
