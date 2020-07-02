package com.fox.thread;

/**
 * @Description: [描述此类]
 * @Author: gaoyimin
 * @CreateDate: 2020/5/20
 * @Version: [v1.0]
 */
public class ThreadDemoTest {


    public static void main(String[] args) {
        ThreadDemoTest test = new ThreadDemoTest();
        test.say();
    }

    private void say() {

        ThreadDemo threadDemo = new ThreadDemo();

        ThreadA threadA = new ThreadA(threadDemo);
        ThreadB threadB = new ThreadB(threadDemo);
        threadA.start();
        threadB.start();
    }

    class ThreadA extends Thread {

        private ThreadDemo demo;

        public ThreadA(ThreadDemo demo) {
            this.demo = demo;
        }

        @Override
        public void run() {
            try {
                demo.sayA();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class ThreadB extends Thread {

        private ThreadDemo demo;

        public ThreadB(ThreadDemo demo) {
            this.demo = demo;
        }

        @Override
        public void run() {
            try {
                demo.sayB();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
