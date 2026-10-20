package ex3;

import java.util.ArrayList;
import java.util.List;

public class PackageDecorator extends Package {
    private Package pack;
    private List<Observer<Package, PackageState>> observerList;

    public PackageDecorator(Package pack) {
        this.pack = pack;
        this.observerList = new ArrayList<>();
    }

    @Override
    public PackageState getState() {
        return pack.getState();
    }

    @Override
    public void setState(PackageState state) {
        pack.setState(state);
        notifyObservers(state);
    }

    @Override
    public void previousState() {
        pack.previousState();
        notifyObservers(pack.getState());
    }

    @Override
    public void nextState() {
        pack.nextState();
        notifyObservers(pack.getState());
    }

    @Override
    public void printStatus() {
        pack.printStatus();
    }

    public void register(Observer<Package, PackageState> observer) {
        observerList.add(observer);
    }

    public void remove(Observer<Package, PackageState> observer) {
        observerList.remove(observer);
    }

    public void notifyObservers(PackageState state) {
        for (Observer<Package, PackageState> observer : observerList) {
            observer.update(this.pack, state);
        }
    }
}
