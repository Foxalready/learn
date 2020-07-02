package com.fox.thread;

import org.apache.hadoop.yarn.webapp.hamlet.Hamlet;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: [描述此类]
 * @Author: gaoyimin
 * @CreateDate: 2019/9/3
 * @Version: [v1.0]
 */
public class AutoIncreaseTest implements Runnable {

    private AtomicInteger a = new AtomicInteger(1);

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " is coming");

        System.out.println(name + " before " + a);
        a.incrementAndGet();
        System.out.println(name + ":" + a);
        System.out.println(name + " is finished");
    }

    public static void main(String[] args) throws InterruptedException {
        AutoIncreaseTest autoIncreaseTest = new AutoIncreaseTest();
        new Thread(autoIncreaseTest, "thread1").start();
        new Thread(autoIncreaseTest, "thread2").start();
        Thread.sleep(5 * 1000);
        System.out.println(autoIncreaseTest.a);
    }
}


