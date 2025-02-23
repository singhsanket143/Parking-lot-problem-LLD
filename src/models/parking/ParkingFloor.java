package models.parking;

import java.util.List;

public class ParkingFloor {

    private int floorNumber;
    private List<ParkingSlot> parkingSlots;

    // constructors, getters, and setters
    public ParkingFloor(int floorNumber, List<ParkingSlot> parkingSlots) {
        this.floorNumber = floorNumber;
        this.parkingSlots = parkingSlots;
    }

    public boolean addParkingSlot(ParkingSlot parkingSlot) {
        return false;
    }

    public int getFloorNumber() {
        return this.floorNumber;
    }

    public List<ParkingSlot> getParkingSlots() {
        return this.parkingSlots;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }
}
