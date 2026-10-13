package ex3;

/**
 * http://javahowto.blogspot.com.es/2011/12/java-dynamic-proxy-example.html
 *
 */

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

public class FileWriterDynamicProxy implements InvocationHandler {

    private Object testImpl;
    private FileWriter fileWriter;

    public FileWriterDynamicProxy(Object impl, String path) {
        this.testImpl = impl;
        try {
            this.fileWriter = new FileWriter(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("update")) {
            fileWriter.write("[" + new Date().toString() + "] ");
            fileWriter.write(args[0].toString());
            fileWriter.write(" changed state to: ");
            fileWriter.write(args[1].toString());
            fileWriter.write("\n");
            fileWriter.flush();

            return null;
        } else {
            return method.invoke(testImpl, args);
        }
    }
}