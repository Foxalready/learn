package com.fox.executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Description: [描述此类]
 * @Author: gaoyimin
 * @CreateDate: 2019/8/8
 * @Version: [v1.0]
 */
public class ExecutorTest {

    ExecutorService executorService = Executors.newSingleThreadExecutor();


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorTest executorTest = new ExecutorTest();
        executorTest.doAction();
    }

    private void doAction() throws ExecutionException, InterruptedException {
        ExecutorRunnable runnable = new ExecutorRunnable();
        ExecutorCallable callable = new ExecutorCallable();

        Future<Integer> result = executorService.submit(runnable, 1);
        System.out.println(result.get());
        Future<?> submit = executorService.submit(runnable);
        System.out.println(submit.get());
        Future<Integer> submit1 = executorService.submit(callable);
        System.out.println(submit1.get());

    }
}
