package ex2;

public class Trip {
    private float distance;
    private MovementStrategy strategy;

    public Trip(float distance){
        this.distance = distance;
    }

    public Trip(float distance, MovementStrategy strategy){
        this.distance = distance;
        this.strategy = strategy;
    }

    public float getDistance(){ return distance; }

    public void setStrategy(MovementStrategy strategy){
        this.strategy = strategy;
    }

    public float getDuration(){
        return strategy.calculateDuration(distance);
    }
}