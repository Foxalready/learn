package com.fox.lock;

/**
 * @Description: [描述此类]
 * @Author: gaoyimin
 * @CreateDate: 2019/12/27
 * @Version: [v1.0]
 */
public class SynchronizedExample {

    int a = 0;
    boolean flag = false;

    public synchronized void writer() {
        a = 1;
        flag = true;
    }

    public synchronized void reader() {
        if (flag) {
            int i = a;
            System.out.println(i);
        }
    }

}
