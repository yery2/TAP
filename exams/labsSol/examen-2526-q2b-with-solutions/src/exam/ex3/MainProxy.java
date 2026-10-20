package exam.ex3;

import java.lang.reflect.Proxy;

public class MainProxy {
    public static void main(String[] args) {
        PaymentService realService = new StripePaymentService();

        PaymentService proxyService = (PaymentService) Proxy.newProxyInstance(
                PaymentService.class.getClassLoader(),
                new Class<?>[]{PaymentService.class},
                new AuditHandler(realService)
        );

        proxyService.processPayment("user_123", 99.99);
        proxyService.refund("txn_abc");
    }
}
