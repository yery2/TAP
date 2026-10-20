package ex3;


import java.lang.reflect.Proxy;

public class StateDemo {

    public static void main(String[] args) {

        PackageDecorator pkg = new PackageDecorator(new Package());
        PackageDecorator pkg2 = new PackageDecorator(new Package());


        Observer obs = (Observer) Proxy.newProxyInstance(Observer.class.getClassLoader(),
                new Class<?>[] {Observer.class},
                new FileWriterDynamicProxy(new ObserverImpl(), "statechanges.log"));


        pkg.register(obs);
        pkg2.register(obs);

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
