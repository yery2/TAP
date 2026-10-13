package ex2Solution;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("\n---------------- Exercise 2.1 ----------------");
        Receiver logger = new Receiver("measurements.csv");
        Display display = new Display();
        logger.addObserver(display);
        logger.readBus();

    }
    
}
