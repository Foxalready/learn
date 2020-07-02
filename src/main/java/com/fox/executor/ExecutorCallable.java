package com.fox.executor;

import java.util.concurrent.Callable;

/**
 * @Description: [描述此类]
 * @Author: gaoyimin
 * @CreateDate: 2019/8/8
 * @Version: [v1.0]
 */
public class ExecutorCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("this is callable");
        return 2;
    }
}
