package com.fox.lock;

/**
 * @Description: [描述此类]
 * @Author: gaoyimin
 * @CreateDate: 2019/12/26
 * @Version: [v1.0]
 */
public class NoVisibility {

    private static boolean ready;

    private static int number;

    public static void main(String[] args) {
        new ReaderThread().start();
        number = 42;
        ready = true;
    }

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                System.out.println("yield");
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static boolean isReady() {
        return ready;
    }

    public static void setReady(boolean ready) {
        NoVisibility.ready = ready;
    }
}
