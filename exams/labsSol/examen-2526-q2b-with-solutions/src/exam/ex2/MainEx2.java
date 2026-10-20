package exam.ex2;

import java.util.Arrays;
import java.util.List;

public class MainEx2 {
    public static void main(String[] args) {
        List<Vehicle> fleet = Arrays.asList(
                new Car(),
                new Bus(30),
                new ElectricScooter()
        );

        MaintenanceCostVisitor maintenance = new MaintenanceCostVisitor();

        for (Vehicle v : fleet) {
            v.accept(maintenance);
        }

        System.out.println("Total Fleet Maintenance Cost: " + maintenance.getTotalCost());
    }
}
