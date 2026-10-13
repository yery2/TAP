package exam.ex2;

import java.util.ArrayList;
import java.util.List;

public class Organization implements OrganizationComponent {
    private final String name;
    private final List<OrganizationComponent> children = new ArrayList<>();

    public Organization(String name) {
        this.name = name;
    }

    public void add(OrganizationComponent component) {
        children.add(component);
    }

    @Override
    public int getEventCount() {
        return children.stream().mapToInt(OrganizationComponent::getEventCount).sum();
    }

    @Override
    public String toString() {
        return name + " (" + getEventCount() + " total events)";
    }
}
