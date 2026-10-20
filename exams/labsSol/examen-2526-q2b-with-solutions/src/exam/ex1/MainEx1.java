package exam.ex1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class MainEx1 {

    public static List<TaxiTrip> loadFromDataset(String filePath) {
        List<TaxiTrip> trips = new ArrayList<>();

        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            trips = lines
                    .skip(1)
                    .filter(line -> !line.trim().isEmpty())
                    .map(line -> {
                        String[] tokens = line.split(",");

                        String id = tokens[0];
                        int vendorId = Integer.parseInt(tokens[1]);

                        String pickupTimeRaw = tokens[2].replace(" ", "T");

                        int passengerCount = (int) Double.parseDouble(tokens[3]);

                        double tripDistance = Double.parseDouble(tokens[4]);
                        double totalAmount = Double.parseDouble(tokens[5]);

                        return new TaxiTrip(id, vendorId, pickupTimeRaw, passengerCount, tripDistance, totalAmount);
                    })
                    .collect(Collectors.toList());

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            e.printStackTrace();
        }

        return trips;
    }


    public static void main(String[] args) {
        // Load from nyc-trips.csv
        List<TaxiTrip> dataset = loadFromDataset("nyc-trips.csv");

        TripAnalysis analysis = new TripAnalysis();

        System.out.println("Sorted: " + analysis.sortByAmountDesc(dataset));
        System.out.println("**********************");
        System.out.println("Vendor 1: " + analysis.filterByVendor(dataset, 1));
        System.out.println("**********************");
        System.out.println("Grouped: " + analysis.groupByPassengerCount(dataset));
        System.out.println("**********************");
        System.out.println("Avg Amount Vendor 1: " + analysis.getAverageAmountByVendor(dataset, 1));
    }
}
