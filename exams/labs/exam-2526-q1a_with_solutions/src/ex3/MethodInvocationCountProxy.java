package ex3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;


public class MethodInvocationCountProxy implements InvocationHandler{
    private Object target = null;
    private Map<String, Integer> counts;

    public static Object newInstance(Object target){
        Class targetClass = target.getClass();
        Class interfaces[] = targetClass.getInterfaces();
        return Proxy. newProxyInstance(targetClass.getClassLoader(),
                interfaces, new  MethodInvocationCountProxy(target));
    }

    private  MethodInvocationCountProxy(Object target) {
        this.target = target;
        this.counts = new HashMap<>();
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
        int count = this.counts.getOrDefault(method.getName(), 0);
        this.counts.put(method.getName(), count + 1);

        
        System.out.println("\tMethodInvocationCountProxy counts:");
        for(Map.Entry<String, Integer> entry: this.counts.entrySet()){
            System.out.println("\t\t" + entry.getKey() + "=" + entry.getValue());
        }

        return method.invoke(this.target, args);
        
    }
}
