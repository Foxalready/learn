package com.fox.lock;

/**
 * @Description: [描述此类]
 * @Author: gaoyimin
 * @CreateDate: 2019/12/27
 * @Version: [v1.0]
 */
public class VolatileExample {

    int a = 0;
    volatile boolean flag = false;

    public void writer() {
        a = 1;
        flag = true;
    }

    public void reader() {
        if (flag) {
            int i = a;
            System.out.println(i);
        }
    }
}
