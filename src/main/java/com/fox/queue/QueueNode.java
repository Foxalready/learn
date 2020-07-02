package com.fox.queue;

import java.io.Serializable;

/**
 * @Description: [描述此类]
 * @Author: gaoyimin
 * @CreateDate: 2019/10/23
 * @Version: [v1.0]
 */
public class QueueNode implements Serializable {

    private int value;

    public QueueNode prev;

    public QueueNode next;

    public QueueNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public QueueNode getPrev() {
        return prev;
    }

    public void setPrev(QueueNode prev) {
        this.prev = prev;
    }

    public QueueNode getNext() {
        return next;
    }

    public void setNext(QueueNode next) {
        this.next = next;
    }

}
