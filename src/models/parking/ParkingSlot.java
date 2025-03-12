package models.parking;

import models.mobility.Vehicle;
import models.mobility.VehicleType;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Parking slot is an abstract class which represents a slot on a parking floor of a parking lot.
 *
 */
public abstract class ParkingSlot {

    private final List<VehicleType> supportedVehicleTypes;
    private final int slotNumber;
    private ParkingSlotStatus status;
    private ParkingFloor floor;
    private Optional<Vehicle> vehicle;

    public ParkingSlot(int slotNumber, ParkingFloor floor, List<VehicleType> supportedVehicleTypes) {
        this.slotNumber = slotNumber;
        this.floor = floor;
        this.status = ParkingSlotStatus.EMPTY;
        this.floor.addParkingSlot(this);
        this.supportedVehicleTypes = supportedVehicleTypes;
        this.vehicle = Optional.empty();
    }

    // getter setters
    public int getSlotNumber() {
        return slotNumber;
    }

    public ParkingSlotStatus getStatus() {
        return status;
    }

    public void setStatus(ParkingSlotStatus status) {
        this.status = status;
    }

    public ParkingFloor getFloor() {
        return floor;
    }

    public void setFloor(ParkingFloor floor) {
        this.floor = floor;
    }

    public Optional<Vehicle> getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        // we should first that the type of vehicle is part of supported vehicles or not ?
        this.vehicle = Optional.of(vehicle);
        this.status = ParkingSlotStatus.OCCUPIED;
    }

    public void removeVehicle() {
        this.status = ParkingSlotStatus.EMPTY;
        this.vehicle = Optional.empty();
    }

    public List<VehicleType> getSupportedVehicleTypes() {
        return supportedVehicleTypes;
    }

    public boolean isSlotAvailable() {
        return this.status == ParkingSlotStatus.EMPTY;
    }

    public boolean isVehicleSupported(Vehicle vehicle) {
        return supportedVehicleTypes.contains(vehicle.getType());
    }

    public void display() {
        System.out.println("Slot Number: " + slotNumber);
        System.out.println("Slot Status: " + status);
        System.out.println("Supported Vehicle Types: " + Arrays.toString(supportedVehicleTypes.toArray()));
        if (vehicle.isPresent()) {
            System.out.println("Parked Vehicle: " + vehicle.get().getRegistrationNumber());
        }
        else System.out.println("No Parked Vehicle");
    }

}
