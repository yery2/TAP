package ex1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {

    public static List<Mountain> loadDataset(String filePath) throws IOException {
        List<Mountain> trips = new ArrayList<>();

        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            trips = lines
                    .skip(1)
                    .filter(line -> !line.trim().isEmpty())
                    .map(line -> {
                        String[] tokens = line.split(",");

                        String name = tokens[0];
                        int height = Integer.parseInt(tokens[1]);
                        String country = tokens[2];
                        String continent = tokens[3];

                        return new Mountain(name, height, country, continent);
                    })
                    .collect(Collectors.toList());

        }

        return trips;
    }

    public static List<Mountain> filter(List<Mountain> mountains, Predicate<Mountain> condition) {
        return mountains.stream().filter(condition).collect(Collectors.toList());
    }

    public static List<Mountain> filterByHeight(List<Mountain> mountains, int minHeight) {
        return filter(mountains, m -> m.getHeight() > minHeight);
    }

    public static Map<String, List<Mountain>> groupByContinent(List<Mountain> mountains) {
        return mountains.stream().collect(Collectors.groupingBy(Mountain::getContinent));
    }

    public static double averageHeightByCountry(List<Mountain> mountains, String country) {
        return mountains.stream()
                .filter(m -> m.getCountry().equals(country))
                .mapToInt(Mountain::getHeight)
                .average()
                .orElse(0.0);
    }

    public static void main(String[] args) throws IOException {

        System.out.println("\n---------------- Dataset loading ----------------");
        List<Mountain> dataset = loadDataset("mountains.csv");
        dataset.forEach(System.out::println);

        System.out.println("\n---------------- Exercise 1.1 ----------------");
        List<Mountain> sorted = dataset.stream()
                .sorted((a, b) -> Integer.compare(b.getHeight(), a.getHeight()))
                .collect(Collectors.toList());
        sorted.forEach(System.out::println);

        System.out.println("\n---------------- Exercise 1.2 ----------------");
        List<Mountain> tallMountains = filterByHeight(dataset, 5000);
        tallMountains.forEach(System.out::println);

        System.out.println("\n---------------- Exercise 1.3 ----------------");
        Map<String, List<Mountain>> byContinent = groupByContinent(dataset);
        byContinent.forEach((continent, list) -> {
            System.out.println(continent + ":");
            list.forEach(System.out::println);
        });

        System.out.println("\n---------------- Exercise 1.4 ----------------");
        double avgNepal = averageHeightByCountry(dataset, "Nepal");
        System.out.println("Average height in Nepal: " + avgNepal);

    }
}
