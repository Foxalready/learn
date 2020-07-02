package com.fox.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class CASTest {
    static int i = 0;
    static AtomicInteger j = new AtomicInteger(0);

    public void count() {
        i++;
    }

    public void safecount() {
        j.getAndIncrement();
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(System.nanoTime());
//        CASTest c = new CASTest();
//        ExecutorService executorService = Executors.newFixedThreadPool(50);
//        for (int k = 0; k < 100; k++) {
//            executorService.execute(new Runnable() {
//                @Override
//                public void run() {
//                    for (int m = 0; m < 100; m++) {
//                        c.count();
//                        c.safecount();
//                    }
//                }
//            });
//        }
//        Thread.sleep(5000);
//        System.out.println("castest 50 threads run add:");
//        System.out.println("count:" + i);
//        System.out.println("safecount:" + j.get());
    }

    static final class Node {
        /**
         * 共享
         */
        static final Node SHARED = new Node();
        /**
         * 独占
         */
        static final Node EXCLUSIVE = null;
        /**
         * 因为超时或者中断，节点会被设置为取消状态，被取消的节点时不会参与到竞争中的，他会一直保持取消状态不会转变为其他状态；
         */
        static final int CANCELLED = 1;
        /**
         * 后继节点的线程处于等待状态，而当前节点的线程如果释放了同步状态或者被取消，将会通知后继节点，使后继节点的线程得以运行
         */
        static final int SIGNAL = -1;
        /**
         * 节点在等待队列中，节点线程等待在Condition上，当其他线程对Condition调用了signal()后，改节点将会从等待队列中转移到同步队列中，加入到同步状态的获取中
         */
        static final int CONDITION = -2;
        /**
         * 表示下一次共享式同步状态获取将会无条件地传播下去
         */
        static final int PROPAGATE = -3;
        /**
         * 等待状态
         */
        volatile int waitStatus;
        /**
         * 前驱节点
         */
        volatile Node prev;
        /**
         * 后继节点
         */
        volatile Node next;
        /**
         * 获取同步状态的线程
         */
        volatile Thread thread;
        Node nextWaiter;

        final boolean isShared() {
            return nextWaiter == SHARED;
        }

        final Node predecessor() throws NullPointerException {
            Node p = prev;
            if (p == null) {
                throw new NullPointerException();
            }
            else{
                return p;
            }
        }

        Node() {
        }

        Node(Thread thread, Node mode) {
            this.nextWaiter = mode;
            this.thread = thread;
        }

        Node(Thread thread, int waitStatus) {
            this.waitStatus = waitStatus;
            this.thread = thread;
        }
    }

//    private Node addWaiter(Node mode) {
//        //新建Node
//        Node node = new Node(Thread.currentThread(), mode);
//        // 快速尝试添加尾节点
//        Node pred = tail;
//        if (pred != null) {
//            node.prev = pred;
//            // CAS设置尾节点
//            if (compareAndSetTail(pred, node)) {
//                pred.next = node;
//                return node;
//            }
//        }
//        // 多次尝试
//        enq(node);
//        return node;
//        //
//    }


}
