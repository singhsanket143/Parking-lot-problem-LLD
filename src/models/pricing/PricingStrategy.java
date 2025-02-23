package models.pricing;

public interface PricingStrategy {

    long calculatePrice();

    PricingStrategyType getType();
}
