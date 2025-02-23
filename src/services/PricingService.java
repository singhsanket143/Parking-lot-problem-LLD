package services;

import config.ServerConfig;
import factories.PricingStrategyFactory;
import helpers.TimeHelpers;
import models.pricing.HourlyPricingStrategy;
import models.pricing.PricingStrategy;
import models.pricing.PricingStrategyType;
import models.tickets.Ticket;

import java.util.List;

public class PricingService {

    public static long calculateParkingCharge(Ticket ticket) {

        // Check if we have hourly pricing strategy then we need to set the number of hours first
        for(PricingStrategy strategy : ticket.getPricingStrategies()) {
            if(strategy.getType().equals(PricingStrategyType.HOURLY)) {
                strategy = PricingStrategyFactory.createHourlyPricingStrategy(ticket);
            }
        }

        return ticket.getPricingStrategies().stream().mapToLong(PricingStrategy::calculatePrice).sum();
    }

}
