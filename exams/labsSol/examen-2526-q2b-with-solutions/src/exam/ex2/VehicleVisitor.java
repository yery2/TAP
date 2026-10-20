package exam.ex2;

public interface VehicleVisitor {
    void visit(Car car);
    void visit(Bus bus);
    void visit(ElectricScooter scooter);
}
