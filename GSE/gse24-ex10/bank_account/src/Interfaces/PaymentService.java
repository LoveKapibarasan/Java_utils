package Interfaces;

import Customer.*;

public interface PaymentService {
	void issuePayment(BankAccount source, BankAccount target, double amount);
}
