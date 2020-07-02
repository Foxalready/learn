package com.fox.thread;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @Description: [描述此类]
 * @Author: gaoyimin
 * @CreateDate: 2019/9/16
 * @Version: [v1.0]
 */
public class MCSLock {

    public static class MCSNode {
        volatile MCSNode next;
        /**
         * 默认在等待锁
         */
        volatile boolean isWaiting = true;
    }

    /**
     * 指向最后一个申请锁的node
     */
    volatile MCSNode queue;

    private static final AtomicReferenceFieldUpdater<MCSLock, MCSNode> UPDATER = AtomicReferenceFieldUpdater.newUpdater(MCSLock.class, MCSNode.class, "queue");

    public void lock(MCSNode currentThread) {
        //step1 获取前面的线程 怎么获取的？
        MCSNode predcessor = UPDATER.getAndSet(this, currentThread);
        if (predcessor != null) {
            //step2 将当前线程作为前一个线程的下个节点
            predcessor.next = currentThread;
            //step3 自旋
            while (currentThread.isWaiting) {

            }
        } else {
            //获取前一个线程失败，说明只有当前线程在使用锁，没有前驱来通知它，所以得自己标记自己获得锁
            currentThread.isWaiting = true;
        }

    }

    public void unlock(MCSNode currentThread) {
        if (currentThread.isWaiting) {
            //只有锁的拥有者才能进行释放操作
            return;
        }

        if (currentThread.next == null) {
            if (UPDATER.compareAndSet(this, currentThread, null)) {
                //step4
                //compareAndSet返回true表示确实没有人排在自己后面
                return;
            } else {
                //突然有人排在自己后面了，可能还不知道是谁，下面是等待后续者
                //这里之所以要忙等是因为：step1执行完后，step2可能还没执行完
                while (currentThread.next == null) {
                    //step5
                }
            }
        }

        currentThread.next.isWaiting = false;
        //for GC
        currentThread.next = null;
    }
}
