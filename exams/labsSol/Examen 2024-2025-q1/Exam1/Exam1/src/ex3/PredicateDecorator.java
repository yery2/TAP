package ex3;

import java.util.function.Predicate;

public class PredicateDecorator<T> implements Predicate<T> {

    private Predicate<T> delegate;
    private int countTest = 0;

    public PredicateDecorator(Predicate<T> delegate) {
        this.delegate = delegate;
    }

    @Override
    public Predicate<T> and(Predicate<? super T> other) {
        return delegate.and(other);
    }

    @Override
    public Predicate<T> negate() {
        return delegate.negate();
    }

    @Override
    public Predicate<T> or(Predicate<? super T> other) {
        return delegate.or(other);
    }

    public int getCountTest() {
        return countTest;
    }

    @Override
    public boolean test(T t) {
        countTest = countTest +1;
        return delegate.test(t);
    }
}
