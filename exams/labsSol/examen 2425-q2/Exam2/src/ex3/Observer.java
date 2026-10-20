package ex3;

public interface Observer<T,U> {
    public void update(T self, U newState);
}
