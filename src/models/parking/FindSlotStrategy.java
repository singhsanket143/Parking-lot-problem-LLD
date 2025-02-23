package models.parking;

import models.mobility.Vehicle;

import java.util.Optional;

public interface FindSlotStrategy {

    Optional<ParkingSlot> findSlot(ParkingLot parkingLot, Vehicle vehicle);
}
