package exam.ex1;

import exam.data.GitHubEvent;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FunctionalJava {

    public static List<GitHubEvent> sortByTimestamp(List<GitHubEvent> events) {
        return events.stream()
                .sorted(Comparator.comparing(GitHubEvent::getTimestamp))
                .collect(Collectors.toList());
    }

    public static List<GitHubEvent> filterEvents(List<GitHubEvent> events, Predicate<GitHubEvent> condition) {
        return events.stream().filter(condition).collect(Collectors.toList());
    }

    public static List<GitHubEvent> filterByType(List<GitHubEvent> events, String type) {
        return filterEvents(events, e -> e.getType().equalsIgnoreCase(type));
    }

    public static List<GitHubEvent> filterByActor(List<GitHubEvent> events, String actor) {
        return filterEvents(events, e -> e.getActor().equalsIgnoreCase(actor));
    }

    public static Map<String, List<GitHubEvent>> groupByType(List<GitHubEvent> events) {
        return events.stream().collect(Collectors.groupingBy(GitHubEvent::getType));
    }

    public static Map<String, Double> averageCommitsByRepo(List<GitHubEvent> events) {
        return events.stream()
                .filter(e -> "PushEvent".equalsIgnoreCase(e.getType()) && e.getCommits() != null)
                .collect(Collectors.groupingBy(
                        GitHubEvent::getRepo,
                        Collectors.averagingInt(GitHubEvent::getCommits)
                ));
    }
}
