package ex3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class NoSettersHandler implements InvocationHandler {
    private Object target;

    public NoSettersHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().startsWith("set")) {
            System.out.println("Setter " + method.getName() + " canceled");
            return null;
        }
        return method.invoke(target, args);
    }
}