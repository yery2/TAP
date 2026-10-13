package exam.ex2;

public class MaintenanceCostVisitor implements VehicleVisitor {
    private double totalCost = 0;

    @Override
    public void visit(Car car) {
        double cost = 50.0;
        System.out.println("Car maintenance: " + cost);
        totalCost += cost;
    }

    @Override
    public void visit(Bus bus) {
        double cost = 100.0 + (bus.getSeatCapacity() * 5.0);
        System.out.println("Bus maintenance: " + cost);
        totalCost += cost;
    }

    @Override
    public void visit(ElectricScooter scooter) {
        double cost = 15.0;
        System.out.println("Scooter maintenance: " + cost);
        totalCost += cost;
    }

    public double getTotalCost() {
        return totalCost;
    }
}
