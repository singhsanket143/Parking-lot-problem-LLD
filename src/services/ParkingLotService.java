package services;

import models.mobility.Vehicle;
import models.parking.FindSlotStrategy;
import models.parking.ParkingLot;
import models.parking.ParkingSlot;
import models.tickets.Ticket;

import java.util.HashMap;
import java.util.Optional;

public class ParkingLotService {

    private ParkingLot parkingLot;
    private FindSlotStrategy findSlotStrategy;
    private HashMap<String, ParkingSlot> vehicleSlotMap = new HashMap<>();
    private HashMap<String, Ticket> vehicleTicketMap = new HashMap<>();

    public ParkingLotService(ParkingLot parkingLot, FindSlotStrategy findSlotStrategy) {
        this.parkingLot = parkingLot;
        this.findSlotStrategy = findSlotStrategy;
    }

    public void parkCar(Vehicle vehicle) {
        Optional<ParkingSlot> slot = findSlotStrategy.findSlot(parkingLot, vehicle);
        if(!slot.isPresent()) {
            System.out.println("Parking is full !!!!");
            return;
        }
        slot.get().setVehicle(vehicle);
        vehicleSlotMap.put(vehicle.getRegistrationNumber(), slot.get());
        System.out.println("Vehicle parked at slot: " );
        slot.get().display();

        // Lets create a ticket
        Ticket ticket = new Ticket(System.currentTimeMillis(), vehicle, slot.get(), parkingLot.getPricingStrategies());
        vehicleTicketMap.put(vehicle.getRegistrationNumber(), ticket);
        System.out.println("Ticket created");
        ticket.display();
    }

    public void leaveParking(Vehicle vehicle) {
        ParkingSlot slot = vehicleSlotMap.get(vehicle.getRegistrationNumber());
        if(slot == null) {
            System.out.println("Vehicle not found in parking lot");
            return;
        }
        slot.removeVehicle();
        vehicleSlotMap.remove(vehicle.getRegistrationNumber());

        // Pay before leaving
        Ticket ticket = vehicleTicketMap.get(vehicle.getRegistrationNumber());
        ticket.setExitTime(System.currentTimeMillis());
        ticket.calculateAndPay();

        System.out.println("Vehicle left parking lot");
    }

}
