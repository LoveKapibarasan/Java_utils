package Customer;

public class Customer {
	private final String name;
	private final BankAccount bankAccount;
	
	public Customer(String name, BankAccount bankAccount) {
		this.name = name;
		this.bankAccount = bankAccount;
	}
	
	public String getName() {
		return name;
	}
	
	public BankAccount getBankAccount() {
		return bankAccount;
	}
}
