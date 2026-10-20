package ex2;

public class StateDemo {

    public static void main(String[] args) {

        PackageDecorator pkg = new PackageDecorator(new Package());
        PackageDecorator pkg2 = new PackageDecorator(new Package());

        pkg.register(new ObserverImpl());
        pkg2.register(new ObserverImpl());

        pkg.printStatus();
        pkg.nextState();
        pkg.printStatus();
        pkg.nextState();
        pkg.printStatus();
        pkg.nextState();
        pkg.printStatus();

        pkg2.setState(new DeliveredState());
        pkg2.printStatus();
        pkg2.previousState();
        pkg2.printStatus();
        pkg2.nextState();
        pkg2.printStatus();
        pkg2.nextState();
        pkg2.printStatus();
    }
}
