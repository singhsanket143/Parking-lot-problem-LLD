import models.mobility.Bike;
import models.mobility.Car;
import models.mobility.Vehicle;
import models.parking.*;
import models.pricing.ConstantPricingStrategy;
import models.pricing.PricingStrategy;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ParkingFloor parkingFloor = new ParkingFloor(1, new ArrayList<>());
        ParkingFloor parkingFloor2 = new ParkingFloor(2, new ArrayList<>());

        ParkingSlot parkingSlot = new BikeParkingSlot(1, parkingFloor2);
        ParkingSlot parkingSlot2 = new CarParkingSlot(2, parkingFloor2);

        parkingFloor2.addParkingSlot(parkingSlot);
        parkingFloor2.addParkingSlot(parkingSlot2);


        parkingFloor.addParkingSlot(parkingSlot);
        parkingFloor.addParkingSlot(parkingSlot2);




        PricingStrategy pricingStrategy1 = new ConstantPricingStrategy(40);

        ParkingLot parkingLot = new ParkingLot(List.of(parkingFloor2, parkingFloor), List.of(pricingStrategy1));

        Vehicle vehicle = new Bike("bike123",  "BLUE");
        Vehicle vehicle2 = new Car("car123",  "RED");

        parkingSlot.display();



    }
}