import Customer.*;
import Interfaces.*;
import Product.Product;
import com.google.inject.Inject;

public class WebshopClient {
	private final BankAccount shopAccount;
	private final LoggingService loggingService;
	private final PaymentService paymentService;
	
	@Inject
	public WebshopClient(LoggingService loggingService, PaymentService paymentService) {
		shopAccount = new BankAccount("The shop");
		this.loggingService = loggingService;
		this.paymentService = paymentService;
	}
	
	public void order(Customer c, int quantity, Product p) {
		loggingService.log(String.format("%s buys %dx %s (%.2f EUR each)", c.getName(), quantity, p.getName(), p.getPrice()));
		paymentService.issuePayment(shopAccount, c.getBankAccount(), p.getPrice() * quantity);
		loggingService.log("Payment done.");
	}
}
