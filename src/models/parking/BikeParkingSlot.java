package models.parking;

import models.mobility.VehicleType;

import java.util.Arrays;
import java.util.List;

public class BikeParkingSlot extends ParkingSlot implements BikeSlot {
    public BikeParkingSlot(int slotNumber, ParkingFloor floor) {
        super(slotNumber, floor, List.of(VehicleType.BIKE));
    }

}
