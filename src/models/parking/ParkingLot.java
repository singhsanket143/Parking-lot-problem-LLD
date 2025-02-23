package models.parking;

import models.pricing.PricingStrategy;
import services.ParkingLotService;

import java.util.List;

public class ParkingLot {

    private List<ParkingFloor> floors;
    private List<PricingStrategy> pricingStrategies;

    public ParkingLot(List<ParkingFloor> floors, List<PricingStrategy> pricingStrategies) {
        this.floors = floors;
        this.pricingStrategies = pricingStrategies;
    }

    public void addParkingFloor(ParkingFloor parkingFloor) {
        this.floors.add(parkingFloor);
    }

    public void removeParkingFloor(ParkingFloor parkingFloor) {
        this.floors.remove(parkingFloor);
    }

    public List<ParkingFloor> getFloors() {
        return this.floors;
    }

    public List<PricingStrategy> getPricingStrategies() {
        return this.pricingStrategies;
    }
}
