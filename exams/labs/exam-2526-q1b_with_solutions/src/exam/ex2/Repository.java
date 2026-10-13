package exam.ex2;

public class Repository implements OrganizationComponent {
    private final String name;
    private final int eventCount;

    public Repository(String name, int eventCount) {
        this.name = name;
        this.eventCount = eventCount;
    }

    @Override
    public int getEventCount() {
        return eventCount;
    }

    @Override
    public String toString() {
        return name + " (" + eventCount + " events)";
    }
}
