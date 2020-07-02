package com.fox.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: [描述此类]
 * @Author: gaoyimin
 * @CreateDate: 2019/12/19
 * @Version: [v1.0]
 */
public class ThreadNotify {

    private Lock reentrantLock = new ReentrantLock();
    private Lock lock = new ReentrantLock();
    private boolean isRun = true;
    private Condition consumeCon = lock.newCondition();
    private Condition productCon = lock.newCondition();

    private volatile int a = 1;


    public static void main(String[] args) throws InterruptedException {

        ThreadNotify threadNotify = new ThreadNotify();
        threadNotify.test();
    }

    private void test() throws InterruptedException {
        Object lock = new Object();
        Thread a = new ThreadA(lock);
        Thread b = new ThreadB(lock);
        a.start();
        b.start();
    }

    class ThreadA extends Thread {

        private Object lock;

        public ThreadA(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {
                if (i == 5) {
                    synchronized (lock) {
                        lock.notifyAll();
                    }
                }
                System.out.println(i);
            }
        }
    }

    class ThreadB extends Thread {

        private Object lock;

        public ThreadB(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized (lock) {
                System.out.println("b get lock");
            }
        }
    }
}
