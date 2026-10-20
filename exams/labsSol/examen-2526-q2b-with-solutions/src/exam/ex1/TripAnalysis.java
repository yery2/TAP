package exam.ex1;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TripAnalysis {

    public List<TaxiTrip> sortByAmountDesc(List<TaxiTrip> trips) {
        return trips.stream()
                .sorted(Comparator.comparingDouble(TaxiTrip::getTotalAmount).reversed())
                .collect(Collectors.toList());
    }

    public List<TaxiTrip> filterTrips(List<TaxiTrip> trips, Predicate<TaxiTrip> condition) {
        return trips.stream()
                .filter(condition)
                .collect(Collectors.toList());
    }

    public List<TaxiTrip> filterByVendor(List<TaxiTrip> trips, int vendorId) {
        return filterTrips(trips, t -> t.getVendorId() == vendorId);
    }

    public Map<Integer, List<TaxiTrip>> groupByPassengerCount(List<TaxiTrip> trips) {
        return trips.stream()
                .collect(Collectors.groupingBy(TaxiTrip::getPassengerCount));
    }

    public double getAverageAmountByVendor(List<TaxiTrip> trips, int vendorId) {
        return trips.stream()
                .filter(t -> t.getVendorId() == vendorId)
                .mapToDouble(TaxiTrip::getTotalAmount)
                .average()
                .orElse(0.0);
    }
}
