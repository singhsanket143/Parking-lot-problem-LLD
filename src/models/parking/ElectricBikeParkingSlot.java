package models.parking;

import models.mobility.VehicleType;

import java.util.Arrays;
import java.util.List;

public class ElectricBikeParkingSlot extends ParkingSlot implements ElectricSlot, BikeSlot {
    public ElectricBikeParkingSlot(int slotNumber, ParkingFloor floor) {
        super(slotNumber, floor, List.of(VehicleType.ELECTRIC_BIKE));
    }

    @Override
    public void chargeVehicle() {
        System.out.println("Charging Electric Vehicle");
    }
}
