package models.parking;

import models.mobility.VehicleType;

import java.util.Arrays;

public class ElectricCarParkingSlot extends ParkingSlot implements ElectricSlot, CarSlot {
    public ElectricCarParkingSlot(int slotNumber, ParkingFloor floor) {
        super(slotNumber, floor, Arrays.asList(VehicleType.ELECTRIC_CAR, VehicleType.ELECTRIC_BIKE));
    }

    @Override
    public void chargeVehicle() {
        System.out.println("Charging Electric Vehicle");
    }
}
