package models.mobility;

public class ElectricCar extends Vehicle implements ElectricVehicle {

    // constructor
    public ElectricCar(String registrationNumber, String color) {
        super(registrationNumber, color, VehicleType.ELECTRIC_CAR);
    }

    @Override
    public void charge() {
        System.out.println("Charging Electric Car");
    }

    @Override
    public float getBatteryLevel() {
        return 0;
    }
}
