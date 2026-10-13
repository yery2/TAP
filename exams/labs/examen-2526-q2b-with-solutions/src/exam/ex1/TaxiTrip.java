package exam.ex1;

import java.time.LocalDateTime;

public class TaxiTrip {
    private String id;
    private int vendorId;
    private LocalDateTime pickupTime;
    private int passengerCount;
    private double tripDistance;
    private double totalAmount;

    public TaxiTrip(String id, int vendorId, String pickupTime, int passengerCount, double tripDistance, double totalAmount) {
        this.id = id;
        this.vendorId = vendorId;
        this.pickupTime = LocalDateTime.parse(pickupTime);
        this.passengerCount = passengerCount;
        this.tripDistance = tripDistance;
        this.totalAmount = totalAmount;
    }

    public int getVendorId() { return vendorId; }
    public double getTotalAmount() { return totalAmount; }
    public double getTripDistance() { return tripDistance; }
    public int getPassengerCount() { return passengerCount; }

    @Override
    public String toString() {
        return "\nTrip{" + id + ", vendor=" + vendorId + ", amt=" + totalAmount + "}";
    }
}
