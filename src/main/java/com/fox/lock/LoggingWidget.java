package com.fox.lock;

/**
 * @Description: [描述此类]
 * @Author: gaoyimin
 * @CreateDate: 2019/12/25
 * @Version: [v1.0]
 */
public class LoggingWidget extends Widget {
    @Override
    public synchronized void doSomething() {
        System.out.println("loggingwidget do");
        super.doSomething();
    }
}
