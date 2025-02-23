package models.payments;

public class FastagPaymentStrategy implements PaymentStrategy {

    @Override
    public void pay(float amount) {
        System.out.println("Paid using Fastag: " + amount);
    }
}
