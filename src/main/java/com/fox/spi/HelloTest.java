package com.fox.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

public class HelloTest {

    public static void main(String[] args) {
        ServiceLoader<IHello> load = ServiceLoader.load(IHello.class);
        for (IHello hello : load) {
            hello.sayHello();
        }
        Iterator<IHello> iterator = load.iterator();
        while (iterator.hasNext()) {
            IHello next = iterator.next();
            next.sayHello();
        }
    }
}
