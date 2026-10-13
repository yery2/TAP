package ex2;

public class WalkStrategy implements MovementStrategy {
    public float calculateDuration(float distance) {
        return distance * 12;
    }
}