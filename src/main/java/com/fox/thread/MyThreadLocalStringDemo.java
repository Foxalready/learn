package com.fox.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @Description: [描述此类]
 * @Author: gaoyimin
 * @CreateDate: 2020/4/3
 * @Version: [v1.0]
 */
public class MyThreadLocalStringDemo {

    private ThreadLocal<String> threadLocal = new ThreadLocal<>();
    private ThreadLocal<String> count = new ThreadLocal<>();
//    private String threadLocal;

    public String getString() {
        return threadLocal.get();
//        return threadLocal;
    }

    public void setString(String string) {
        threadLocal.set(string);
//        this.threadLocal = string;
    }

    public String getCount() {
        return count.get();
    }

    public void setCount(String s) {
        count.set(s);
    }

    public static void main(String[] args) {
        int threads = 9;

        MyThreadLocalStringDemo demo = new MyThreadLocalStringDemo();
        CountDownLatch countDownLatch = new CountDownLatch(threads);
        for (int i = 0; i < threads; i++) {
            Thread thread = new Thread(() -> {
                demo.setString(Thread.currentThread().getName());
                demo.setCount("2");
                System.out.println(demo.getString());
                countDownLatch.countDown();
            }, "thread - " + i);
            thread.start();
        }

    }
}
