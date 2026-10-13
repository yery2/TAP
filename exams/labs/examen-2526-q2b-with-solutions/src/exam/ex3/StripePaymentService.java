package exam.ex3;

public class StripePaymentService implements PaymentService {
    @Override
    public void processPayment(String user, double amount) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("Processing Stripe payment for " + user + ": $" + amount);
    }

    @Override
    public void refund(String transactionId) {
        System.out.println("Refunding Stripe transaction: " + transactionId);
    }
}
