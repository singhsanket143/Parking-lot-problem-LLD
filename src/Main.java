import models.mobility.Bike;
import models.mobility.Car;
import models.mobility.Vehicle;
import models.parking.*;
import models.pricing.ConstantPricingStrategy;
import models.pricing.PricingStrategy;
import services.ParkingLotService;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Parking Lot");
        ParkingFloor parkingFloor1 = new ParkingFloor(1, new ArrayList<>());
        ParkingFloor parkingFloor2 = new ParkingFloor(2, new ArrayList<>());

        ParkingSlot parkingSlot1 = new BikeParkingSlot(1, parkingFloor2);
        ParkingSlot parkingSlot2 = new CarParkingSlot(2, parkingFloor2);

        parkingFloor2.addParkingSlot(parkingSlot1);
        parkingFloor2.addParkingSlot(parkingSlot2);


        parkingFloor1.addParkingSlot(parkingSlot1);
        parkingFloor1.addParkingSlot(parkingSlot2);


        PricingStrategy pricingStrategy1 = new ConstantPricingStrategy(40);

        ParkingLot parkingLot = new ParkingLot(List.of(parkingFloor2, parkingFloor1), List.of(pricingStrategy1));

        Vehicle vehicle1 = new Bike("bike123",  "BLUE");
        Vehicle vehicle2 = new Car("car123",  "RED");

        FindSlotStrategy findSlotStrategy = new LinearSearchFindingStrategy();
        ParkingLotService parkingLotService = new ParkingLotService(parkingLot, findSlotStrategy);
        System.out.println(" --------- Parking Vehicle ------");
        parkingLotService.parkVehicle(vehicle1);

        System.out.println(" --------- UnParking Vehicle ------");
        parkingLotService.leaveParking(vehicle1);

        System.out.println(" --------- Display Parking Slot -------- ");
        parkingSlot1.display();

    }
}