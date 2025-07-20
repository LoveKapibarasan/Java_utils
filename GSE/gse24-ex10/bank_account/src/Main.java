import Customer.*;
import Product.Product;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {
	public static void main(String[] args) {
		Injector inj = Guice.createInjector(new ProductionModule());
		WebshopClient client = inj.getInstance(WebshopClient.class);
		
		Customer claus = new Customer("Claus", new BankAccount("Claus' account"));
		Product gof = new Product("The Gang of Four - Design Patterns", 20.0);
		client.order(claus, 50, gof);
	}
}

