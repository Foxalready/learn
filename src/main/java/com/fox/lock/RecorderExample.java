package com.fox.lock;

/**
 * @Description: [描述此类]
 * @Author: gaoyimin
 * @CreateDate: 2019/12/27
 * @Version: [v1.0]
 */
public class RecorderExample {

    int a = 0;
    boolean flag = false;

    public void writer() {
        a = 1;                         //1
        flag = true;                   //2
    }

    public void reader() {
        if (flag) {                     //3
            int i = a * a;              //4
            ///
        }
    }
}
