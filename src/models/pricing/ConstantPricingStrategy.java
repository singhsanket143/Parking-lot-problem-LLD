package models.pricing;

public class ConstantPricingStrategy implements PricingStrategy {

    private final long price;

    public ConstantPricingStrategy(long price) {
        this.price = price;
    }

    @Override
    public long calculatePrice() {
        return price;
    }

    @Override
    public PricingStrategyType getType() {
        return PricingStrategyType.CONSTANT;
    }
}
