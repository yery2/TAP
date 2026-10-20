package ex1;

import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import utils.Measurement;
import static utils.Utils.loadMeasurements;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("\n---------------- Measurements loading ----------------");
        List<Measurement> measurements = loadMeasurements("measurements.csv");
        measurements.forEach(System.out::println);

        System.out.println("\n---------------- Exercise 1.1 ----------------");
        measurements.sort(Comparator.comparing(Measurement::getTimestamp));

        System.out.println("\n---------------- Exercise 1.2 ----------------");
        List<Measurement> rpms = queryBySensorName(measurements, "Inv_RPM");
        rpms.forEach(System.out::println); 

        System.out.println("\n---------------- Exercise 1.3 ----------------");
        List<Double> voltages = sensorValuesOverThreshold(measurements,"Inv_Current_Battery",110);
        voltages.forEach(System.out::println); 

        System.out.println("\n---------------- Exercise 1.4 ----------------");
        Map<String,List<Measurement>> group = measuresBySensorName(measurements);
        for(Map.Entry<String, List<Measurement>> entry : group.entrySet()){
            System.out.println(entry.getKey());
            entry.getValue().forEach(System.out::println);
        }
    }

        private static List<Measurement> query(List<Measurement> list, Predicate<Measurement> condition){
            return list.stream().filter(condition).collect(Collectors.toList());
        }
    
        private static List<Measurement> queryBySensorName(List<Measurement> list, String sensorName){
            return query(list, s -> s.getSensorName().equals(sensorName));
        }

        private static List<Double> sensorValuesOverThreshold(List<Measurement> list,String sensorName,double v){
             return list.stream()
                .filter((m)-> m.getSensorName().equals(sensorName) & m.getValue() > v)
                .map(Measurement::getValue)
                .collect(Collectors.toList());
        }

        private static Map<String,List<Measurement>> measuresBySensorName(List<Measurement> list){
            return list.stream()
            .collect(Collectors.groupingBy(Measurement::getSensorName));
        }
        
}
