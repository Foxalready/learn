package leetcode.common;

import java.io.Serializable;

public class MyLinkedNode implements Serializable {

    public int value;

    public MyLinkedNode next;

    public MyLinkedNode(int value) {
        this.value = value;
        this.next = null;
    }

    /**
     * 先新建一个节点值为0的链表，然后创建链表，创建完之后，将这个0的值抛弃，直接return后面的值即可
     */
    public static MyLinkedNode create(int... args) {
        MyLinkedNode head = new MyLinkedNode(0);
        MyLinkedNode current = head;
        for (int val : args) {
            current.next = new MyLinkedNode(val);
            current = current.next;
        }

        return head.next;
    }



    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public MyLinkedNode getNext() {
        return next;
    }

    public void setNext(MyLinkedNode next) {
        this.next = next;
    }
}
