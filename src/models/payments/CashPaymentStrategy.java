package models.payments;

public class CashPaymentStrategy implements PaymentStrategy {

    @Override
    public void pay(float amount) {
        System.out.println("Paid using Cash: " + amount);
    }
}
