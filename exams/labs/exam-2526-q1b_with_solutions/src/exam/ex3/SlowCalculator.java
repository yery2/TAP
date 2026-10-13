package exam.ex3;

public class SlowCalculator implements Calculator {
    @Override
    public int sum(int a, int b) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ignored) {}
        return a + b;
    }
}
