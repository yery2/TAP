package ex2;

public interface Observer<T,U> {
    public void update(T self, U newState);
}
