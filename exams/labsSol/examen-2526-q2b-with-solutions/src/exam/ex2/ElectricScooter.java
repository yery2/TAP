package exam.ex2;

public class ElectricScooter implements Vehicle {
    @Override
    public void accept(VehicleVisitor visitor) {
        visitor.visit(this);
    }
}
