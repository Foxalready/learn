package com.fox.lock;

import java.math.BigDecimal;
import java.util.Vector;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Description: [描述此类]
 * @Author: gaoyimin
 * @CreateDate: 2019/12/25
 * @Version: [v1.0]
 */
public class LockTest {

    public static void main(String[] args) {

        BigDecimal a = null;
        new Vector<>();
        new ConcurrentLinkedQueue<>();

        LoggingWidget loggingWidget = new LoggingWidget();
        loggingWidget.doSomething();
    }
}
