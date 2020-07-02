package com.fox.reactor;

/**
 * @Description: [描述此类]
 * @Author: gaoyimin
 * @CreateDate: 2019/7/17
 * @Version: [v1.0]
 */
public class Reactor implements Runnable {
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
