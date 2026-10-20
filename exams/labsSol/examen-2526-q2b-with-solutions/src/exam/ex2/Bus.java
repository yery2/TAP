package exam.ex2;

public class Bus implements Vehicle {
    private int seatCapacity;

    public Bus(int seatCapacity) {
        this.seatCapacity = seatCapacity;
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }

    @Override
    public void accept(VehicleVisitor visitor) {
        visitor.visit(this);
    }
}
