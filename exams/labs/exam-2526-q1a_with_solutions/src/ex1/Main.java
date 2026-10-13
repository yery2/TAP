package ex1;

import java.io.IOException;
import java.util.*;

import utils.Measurement;
import static utils.Utils.loadMeasurements;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("\n---------------- Measurements loading ----------------");
        List<Measurement> measurements = loadMeasurements("measurements.csv");
        measurements.forEach(System.out::println);

        System.out.println("\n---------------- Exercise 1.1 ----------------");


        System.out.println("\n---------------- Exercise 1.2 ----------------");


        System.out.println("\n---------------- Exercise 1.3 ----------------");


        System.out.println("\n---------------- Exercise 1.4 ----------------");


    }

}
