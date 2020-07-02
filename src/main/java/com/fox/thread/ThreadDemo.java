package com.fox.thread;

/**
 * @Description: [描述此类]
 * @Author: gaoyimin
 * @CreateDate: 2020/5/20
 * @Version: [v1.0]
 */
public class ThreadDemo {

    public synchronized void sayA() throws InterruptedException {
        System.out.println("aaaaa");
        Thread.sleep(5 * 1000);
    }

    public void sayB() throws InterruptedException {
        System.out.println("bbbbbbbbbbb");
        Thread.sleep(5 * 1000);
    }
}
