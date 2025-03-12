package models.tickets;

import models.mobility.Vehicle;
import models.parking.ParkingSlot;
import models.payments.CardPaymentStrategy;
import models.payments.PaymentStrategy;
import models.pricing.PricingStrategy;
import services.PricingService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Ticket {

    private String id;
    private Long entryTime;
    private Optional<Long> exitTime;
    private Vehicle vehicle;
    private ParkingSlot parkingSlot;
    private List<PricingStrategy> pricingStrategies;
    private Optional<PaymentStrategy> paymentStrategy;

    public Ticket(Long entryTime, Vehicle vehicle, ParkingSlot parkingSlot, List<PricingStrategy> pricingStrategies) {
        this.entryTime = entryTime;
        this.vehicle = vehicle;
        this.parkingSlot = parkingSlot;
        this.pricingStrategies = pricingStrategies;
        this.id = UUID.randomUUID().toString();
        this.paymentStrategy = Optional.of(new CardPaymentStrategy());
    }

    public void setExitTime(Long exitTime) {
        this.exitTime = Optional.of(exitTime);
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = Optional.of(paymentStrategy);
    }

    public void calculateAndPay() {
        long price = PricingService.calculateParkingCharge(this);
        System.out.println("Price calculated: " + price);
        paymentStrategy.get().pay(price);
    }

    // getter setters
    public Long getEntryTime() {
        return entryTime;
    }

    public Optional<Long> getExitTime() {
        return exitTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public List<PricingStrategy> getPricingStrategies() {
        return pricingStrategies;
    }

    public Optional<PaymentStrategy> getPaymentStrategy() {
        return paymentStrategy;
    }

    public void display() {
        System.out.println("Ticket ID: " + this.id);
        System.out.println("Entry Time: " + this.entryTime);
        System.out.println("Vehicle: " + this.vehicle.getRegistrationNumber());
        System.out.println("Parking Slot: " + this.parkingSlot.getSlotNumber());
    }
}
