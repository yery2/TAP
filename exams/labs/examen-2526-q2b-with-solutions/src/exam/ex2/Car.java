package exam.ex2;

public class Car implements Vehicle {
    @Override
    public void accept(VehicleVisitor visitor) {
        visitor.visit(this);
    }
}
