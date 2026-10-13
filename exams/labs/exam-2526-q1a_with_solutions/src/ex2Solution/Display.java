package ex2Solution;

import utils.Measurement;

public class Display implements MeasurementObserver{
    @Override
    public void notify(Measurement m) {
        System.out.println(m);
    }
}
