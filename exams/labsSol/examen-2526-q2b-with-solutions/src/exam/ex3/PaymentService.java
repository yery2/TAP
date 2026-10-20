package exam.ex3;

public interface PaymentService {
    void processPayment(String user, double amount);
    void refund(String transactionId);
}
