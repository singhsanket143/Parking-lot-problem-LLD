package models.mobility;

public class ElectricBike extends Vehicle implements ElectricVehicle{

    // constructor
    public ElectricBike(String registrationNumber, String color) {
        super(registrationNumber, color, VehicleType.ELECTRIC_BIKE);
    }

    @Override
    public void charge() {
        System.out.println("Charging Electric Bike");
    }

    @Override
    public float getBatteryLevel() {
        return 0;
    }
}
