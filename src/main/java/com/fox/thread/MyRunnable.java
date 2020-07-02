package com.fox.thread;

/**
 * @Description: [描述此类]
 * @Author: gaoyimin
 * @CreateDate: 2019/7/25
 * @Version: [v1.0]
 */
public class MyRunnable implements Runnable {

    private NoSafeThread instance;

    public MyRunnable(NoSafeThread instance) {
        this.instance = instance;
    }

    @Override
    public void run() {
        this.instance.add("some text");
    }
}
