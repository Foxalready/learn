package com.fox.spi;

public class PythonHello implements IHello {
    @Override
    public String sayHello() {
        System.out.println("Hello python");
        return "python";
    }
}
