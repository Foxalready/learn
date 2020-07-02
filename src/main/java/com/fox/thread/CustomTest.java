package com.fox.thread;

/**
 * @Description: [描述此类]
 * @Author: gaoyimin
 * @CreateDate: 2019/9/3
 * @Version: [v1.0]
 */
public class CustomTest implements Runnable {

    private int a = 1;

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " is coming");

        System.out.println(name + " before " + a);
        a = a + 1;
        System.out.println(name + ":" + a);
        System.out.println(name + " is finished");
    }

    public static void main(String[] args) throws InterruptedException {
        CustomTest autoIncreaseTest = new CustomTest();
        new Thread(autoIncreaseTest, "thread1").start();
        new Thread(autoIncreaseTest, "thread2").start();
        Thread.sleep(5 * 1000);
        System.out.println(autoIncreaseTest.a);
    }
}
