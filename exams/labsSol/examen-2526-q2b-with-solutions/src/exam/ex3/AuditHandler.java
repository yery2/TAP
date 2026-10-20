package exam.ex3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AuditHandler implements InvocationHandler {
    private final Object target;

    public AuditHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("[AUDIT] Starting execution of: " + method.getName());
        long startTime = System.currentTimeMillis();

        Object result = method.invoke(target, args);

        long endTime = System.currentTimeMillis();
        System.out.println("[AUDIT] Finished execution of: " + method.getName() +
                ". Time taken: " + (endTime - startTime) + " ms");

        return result;
    }
}
