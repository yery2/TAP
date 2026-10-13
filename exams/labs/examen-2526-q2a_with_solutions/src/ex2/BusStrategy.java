package ex2;

public class BusStrategy implements MovementStrategy {
    public float calculateDuration(float distance) {
        return distance + 2 * (float) Math.floor(distance / 5);
    }
}