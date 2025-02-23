package models.mobility;

public class Car extends Vehicle{

    // constructor
    public Car(String registrationNumber, String color) {
        super(registrationNumber, color, VehicleType.CAR);
    }


}
