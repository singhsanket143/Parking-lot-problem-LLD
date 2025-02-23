package factories;

import models.parking.FindSlotStrategy;
import models.parking.LinearSearchFindingStrategy;

public class FindSlotStrategyFactory {

    public static FindSlotStrategy createLinearSearchFindSlotStrategy() {
        return new LinearSearchFindingStrategy();
    }
}
