package exam.ex3;

public class MainReflection {
    public static void main(String[] args) {
        Calculator calc = new SlowCalculator();
        Calculator memoCalc = MemoizationHandler.createProxy(calc, Calculator.class);

        System.out.println("=== Dynamic Proxy Memoization Demo ===");

        long start = System.currentTimeMillis();
        int result1 = memoCalc.sum(4, 5);
        long time1 = System.currentTimeMillis() - start;
        System.out.println("First call result: " + result1 + " (took " + time1 + " ms)");

        start = System.currentTimeMillis();
        int result2 = memoCalc.sum(4, 5);
        long time2 = System.currentTimeMillis() - start;
        System.out.println("Second call result: " + result2 + " (took " + time2 + " ms)");
    }
}
