package Payments;

import Customer.BankAccount;
import Interfaces.LoggingService;
import Interfaces.PaymentService;
import com.google.inject.Inject;

public class ProductionPaymentService implements PaymentService {
    private final LoggingService logger;
    @Inject
    public ProductionPaymentService(LoggingService logger) {
        this.logger = logger;
    }
    @Override
    public void issuePayment(BankAccount source, BankAccount target, double amount){
        logger.log(String.format("... Transferring %.2f EUR from %s to %s ...",
                amount, source.getOwner(), target.getOwner()));
    }
}
