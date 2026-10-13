package ex2;

public class CarStrategy implements MovementStrategy {
    public float calculateDuration(float distance) {
        return distance + 5;
    }
}