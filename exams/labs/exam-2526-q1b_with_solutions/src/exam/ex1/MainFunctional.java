package exam.ex1;

import exam.data.DataLoader;
import exam.data.GitHubEvent;

import java.util.List;
import java.util.Map;

public class MainFunctional {
    public static void main(String[] args) {
        List<GitHubEvent> events = DataLoader.loadFromDataset("github-events.json");

        System.out.println("=== Sorted by timestamp ===");
        FunctionalJava.sortByTimestamp(events).forEach(System.out::println);

        System.out.println("\n=== Filter by type: PushEvent ===");
        FunctionalJava.filterByType(events, "PushEvent").forEach(System.out::println);

        System.out.println("\n=== Filter by actor: alice ===");
        FunctionalJava.filterByActor(events, "alice").forEach(System.out::println);

        System.out.println("\n=== Group by type ===");
        Map<String, List<GitHubEvent>> grouped = FunctionalJava.groupByType(events);
        grouped.forEach((type, list) -> System.out.println(type + " -> " + list.size() + " events"));

        System.out.println("\n=== Average commits by repo (PushEvents only) ===");
        Map<String, Double> averages = FunctionalJava.averageCommitsByRepo(events);
        averages.forEach((repo, avg) -> System.out.println(repo + ": " + avg));
    }
}
