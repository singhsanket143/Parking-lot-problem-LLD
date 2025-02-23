package models.mobility;

public abstract class Vehicle {

    private String registrationNumber;
    private String color;
    private VehicleType type;

    public Vehicle(String registrationNumber, String color, VehicleType type) {
        this.registrationNumber = registrationNumber;
        this.color = color;
        this.type = type;
    }

    // getter and setters
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

}
