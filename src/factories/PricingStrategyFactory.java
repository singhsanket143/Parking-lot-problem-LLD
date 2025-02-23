package factories;

import config.ServerConfig;
import helpers.TimeHelpers;
import models.pricing.HourlyPricingStrategy;
import models.pricing.PricingStrategy;
import models.tickets.Ticket;

public class PricingStrategyFactory {

    public static PricingStrategy createHourlyPricingStrategy(Ticket ticket) {
        return new HourlyPricingStrategy(
                ServerConfig.PRICE_PER_HOUR,
                TimeHelpers.convertMillisecondsToHours(ticket.getExitTime().get() - ticket.getEntryTime()));
    }

}
