package exam.data;

public class GitHubEvent {
    private String id;
    private String type;
    private String repo;
    private String actor;
    private String timestamp;
    private Integer commits;

    public GitHubEvent() {}

    public GitHubEvent(String id, String type, String repo, String actor, String timestamp, Integer commits) {
        this.id = id;
        this.type = type;
        this.repo = repo;
        this.actor = actor;
        this.timestamp = timestamp;
        this.commits = commits;
    }

    public String getId() { return id; }
    public String getType() { return type; }
    public String getRepo() { return repo; }
    public String getActor() { return actor; }
    public String getTimestamp() { return timestamp; }
    public Integer getCommits() { return commits; }

    @Override
    public String toString() {
        return "GitHubEvent{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", repo='" + repo + '\'' +
                ", actor='" + actor + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", commits=" + commits +
                '}';
    }
}
