package com.fox.executor;

/**
 * @Description: [描述此类]
 * @Author: gaoyimin
 * @CreateDate: 2019/8/8
 * @Version: [v1.0]
 */
public class ExecutorRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("this is runnable");
    }
}
