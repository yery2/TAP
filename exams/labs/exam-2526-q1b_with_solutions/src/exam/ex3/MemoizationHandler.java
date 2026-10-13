package exam.ex3;

import java.lang.reflect.*;
import java.util.*;

public class MemoizationHandler implements InvocationHandler {
    private final Object target;
    private final Map<String, Object> cache = new HashMap<>();

    public MemoizationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String key = method.getName() + Arrays.deepToString(args);
        if (cache.containsKey(key)) {
            System.out.println("Returning cached result for " + key);
            return cache.get(key);
        }
        Object result = method.invoke(target, args);
        cache.put(key, result);
        return result;
    }

    @SuppressWarnings("unchecked")
    public static <T> T createProxy(T target, Class<T> iface) {
        return (T) Proxy.newProxyInstance(
                iface.getClassLoader(),
                new Class<?>[]{iface},
                new MemoizationHandler(target)
        );
    }
}
