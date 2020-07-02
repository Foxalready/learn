package com.fox.link;

import java.util.List;

/**
 * @Description: [描述此类]
 * @Author: gaoyimin
 * @CreateDate: 2019/1/7
 * @Version: [v1.0]
 */
public class NodeTest {

    public static void main(String[] args) {

        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = null;

        NodeTest nodeTest = new NodeTest();
        Node node = nodeTest.rev(a);
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }

    private Node rev(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node previous = null;

        while (head != null && head.next != null) {
            Node next = head.next;
            head.next = previous;
            previous = head;
            head = next;
        }

        if (head != null) {
            head.next = previous;
        }
        return head;
    }

//        Node reverse = nodeTest.reverse(a);
//        while (reverse != null) {
//            System.out.println(reverse.value);
//            reverse = reverse.next;
//        }


    private Node myReverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node previous = null;

        while (head.next != null) {
            Node next = head.next;
            head.next = previous;
            previous = head;
            head = next;
        }

        head.next = previous;

        return head;
    }


    public Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node temp = head.next;
        Node newTemp = reverse(head.next);
        temp.next = head;
        head.next = null;
        return newTemp;
    }

//    public static void main(String[] args) {


//        NodeTest nodeTest = new NodeTest();
//
//        Node node1 = new Node(1);
//        Node node2 = new Node(2);
//        Node node3 = new Node(3);
//        Node node4 = new Node(4);
//
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//
//        Node reverse = nodeTest.reverse(node1);
//        while (reverse != null) {
//            System.out.println(reverse.value);
//            reverse = reverse.next;
//        }
//    }

}
