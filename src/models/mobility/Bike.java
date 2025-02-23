package models.mobility;

public class Bike extends Vehicle{

    // constructor
    public Bike(String registrationNumber, String color) {
        super(registrationNumber, color, VehicleType.BIKE);
    }

}
