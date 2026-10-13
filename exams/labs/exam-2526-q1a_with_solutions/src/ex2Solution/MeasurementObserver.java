package ex2Solution;

import utils.Measurement;

public interface MeasurementObserver {
    void notify(Measurement measurement);
}
