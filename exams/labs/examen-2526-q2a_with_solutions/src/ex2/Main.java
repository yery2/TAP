package ex2;


public class Main {

    public static void main(String[] args) {
        Trip trip1 = new Trip(10, new WalkStrategy());
        System.out.println(trip1.getDistance()+"km in "+ trip1.getDuration() +" minutes (Walk)");

        Trip trip2 = new Trip(10, new CarStrategy());
        System.out.println(trip2.getDistance()+"km in "+ trip2.getDuration() +" minutes (Car)");

        Trip trip3 = new Trip(10, new BusStrategy());
        System.out.println(trip3.getDistance()+"km in "+ trip3.getDuration() +" minutes (Bus)");

        Trip trip4 = new Trip(25);
        trip4.setStrategy(new WalkStrategy());
        System.out.println(trip4.getDistance()+"km in "+ trip4.getDuration() +" minutes (Walk)");

        trip4.setStrategy(new CarStrategy());
        System.out.println(trip4.getDistance()+"km in "+ trip4.getDuration() +" minutes (Car)");

        trip4.setStrategy(new BusStrategy());
        System.out.println(trip4.getDistance()+"km in "+ trip4.getDuration() +" minutes (Bus)");
    }
}
