package models.pricing;

public class HourlyPricingStrategy implements PricingStrategy {

    private final int pricePerHour;
    private long numberOfHours;

    public HourlyPricingStrategy(int pricePerHour, long numberOfHours) {
        this.pricePerHour = pricePerHour;
        this.numberOfHours = numberOfHours;
    }

    @Override
    public long calculatePrice() {
        return (long)pricePerHour * this.numberOfHours;
    }

    public void setNumberOfHours(long numberOfHours) {
        this.numberOfHours = numberOfHours;
    }

    @Override
    public PricingStrategyType getType() {
        return PricingStrategyType.HOURLY;
    }
}
