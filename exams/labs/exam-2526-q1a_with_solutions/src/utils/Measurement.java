package utils;

public class Measurement {
    private String timestamp;
    private String sensorName;
    private double value;

    public Measurement(String timestamp, String sensorName, double value) {
        this.timestamp = timestamp;
        this.sensorName = sensorName;
        this.value = value;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getSensorName() {
        return sensorName;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return timestamp + " " + sensorName + " = " + value;
    }
}