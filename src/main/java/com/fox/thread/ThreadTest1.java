package com.fox.thread;

import java.util.concurrent.ExecutorService;

/**
 * @Description: [描述此类]
 * @Author: gaoyimin
 * @CreateDate: 2019/7/25
 * @Version: [v1.0]
 */
public class ThreadTest1 {

    private LocalObject object;

    private volatile int a = 1;

    public static void main(String[] args) {
        ExecutorService executor;
    }

    private void testThread() {
        NoSafeThread thread = new NoSafeThread();
        new Thread(new MyRunnable(thread)).start();
        new Thread(new MyRunnable(thread)).start();
    }

    private void someMethod1() {
        LocalObject localObject = new LocalObject();
        LocalObject localObject1 = someMethod2(localObject);
        object = localObject1;
    }

    private LocalObject someMethod2(LocalObject localObject) {
        localObject.setValue("value");
        return localObject;
    }

    private void someMethod() {
        long threadSafeInt = 0;
        threadSafeInt++;
    }
}
