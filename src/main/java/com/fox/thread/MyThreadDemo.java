package com.fox.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: [描述此类]
 * @Author: gaoyimin
 * @CreateDate: 2019/9/3
 * @Version: [v1.0]
 */
public class MyThreadDemo {
    private int a = 0;

    private AtomicInteger b = new AtomicInteger(0);

    private void add() {
        a++;
    }

    private void atomicAdd() {
        b.incrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {
        MyThreadDemo demo = new MyThreadDemo();
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 50; j++) {
                        demo.add();
                        demo.atomicAdd();
                    }
                }
            });
        }
        Thread.sleep(5 * 1000);
        System.out.println("a : " + demo.a);
        System.out.println("b : " + demo.b);
    }
}
