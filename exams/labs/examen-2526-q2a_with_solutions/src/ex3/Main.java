package ex3;

import java.lang.reflect.Proxy;


public class Main {

    public static void main(String[] args) {
        ProductInterface product1 = new Product("RAM DDR5 6000MHz 32GB 2x16GB CL30 (Black)", 569.95f);
        ProductInterface product2 = new Product("RAM DDR5 6000MHz 32GB 2x16GB CL30 (White)", 679.00f);
        
        System.out.println("--- Regular product ---");
        System.out.println("Name: " + product1.getName());
        System.out.println("Price: " + product1.getPrice());
        product1.setName("New Name");
        product1.setPrice(100.0f);
        System.out.println("After setters - Name: " + product1.getName() + ", Price: " + product1.getPrice());

        System.out.println("\n--- Proxied product ---");
        ProductInterface proxiedProduct = (ProductInterface) Proxy.newProxyInstance(
                ProductInterface.class.getClassLoader(),
                new Class<?>[]{ProductInterface.class},
                new NoSettersHandler(product2)
        );

        System.out.println("Name: " + proxiedProduct.getName());
        System.out.println("Price: " + proxiedProduct.getPrice());
        proxiedProduct.setName("New Name");
        proxiedProduct.setPrice(100.0f);
        System.out.println("After proxy setters - Name: " + proxiedProduct.getName() + ", Price: " + proxiedProduct.getPrice());
    }
}
