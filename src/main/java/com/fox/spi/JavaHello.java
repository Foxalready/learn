package com.fox.spi;

public class JavaHello implements IHello {
    @Override
    public String sayHello() {
        System.out.println("hello java");
        return "java";
    }
}
