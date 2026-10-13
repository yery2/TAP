package exam.ex2;

public class MainComposite {
public static void main(String[] args) {
        Repository repoA = new Repository("repo-A", 10);
        Repository repoB = new Repository("repo-B", 5);
        Repository repoC = new Repository("repo-C", 7);
        Repository repoD = new Repository("repo-D", 3);

        Organization orgFrontend = new Organization("Frontend");
        orgFrontend.add(repoA);
        orgFrontend.add(repoB);

        Organization orgBackend = new Organization("Backend");
        orgBackend.add(repoC);
        orgBackend.add(repoD);

        Organization company = new Organization("MyCompany");
        company.add(orgFrontend);
        company.add(orgBackend);

        System.out.println("=== Composite Structure ===");
        System.out.println("Frontend total events: " + orgFrontend.getEventCount());
        System.out.println("Backend total events: " + orgBackend.getEventCount());
        System.out.println("Company total events: " + company.getEventCount());
    }
}
