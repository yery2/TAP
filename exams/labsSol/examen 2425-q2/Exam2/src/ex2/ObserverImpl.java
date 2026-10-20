package ex2;

public class ObserverImpl implements Observer<Package, PackageState> {

    @Override
    public void update(Package self, PackageState newState) {
        System.out.println(self + " state set to: " + newState);
    }
}
