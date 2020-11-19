package leetcode.link;

import leetcode.common.MyLinkedNode;

/**
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 *  
 * <p>
 * 进阶：
 * <p>
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * <p>
 *  
 * <p>
 * 示例：
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 */
public class Problem445 {

    private MyLinkedNode result;

    int extra = 0;

    public static void main(String[] args) {

        Problem445 problem445 = new Problem445();

        MyLinkedNode l1 = MyLinkedNode.create(1, 2, 3, 4);
        MyLinkedNode l2 = MyLinkedNode.create(9, 8);

        MyLinkedNode node = problem445.addTwoNumbers(l1, l2);
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }

//        MyLinkedNode node = MyLinkedNode.create(1, 2, 3);
//        MyLinkedNode node1 = problem445.addHead(node, 3);
////
//        while (node1 != null) {
//            System.out.println(node1.value);
//            node1 = node1.next;
//        }
//
//        int i = problem445.countNode(node);
//        System.out.println(i);


    }

    private MyLinkedNode addTwoNumbers(MyLinkedNode l1, MyLinkedNode l2) {

        int a = countNode(l1);
        int b = countNode(l2);
        if (a > b) {
            l2 = addHead(l2, a - b);
        }
        if (a < b) {
            l1 = addHead(l1, b - a);
        }
//        while (l1 != null) {
//            System.out.println(l1.value);
//            l1 = l1.next;
//        }
//        while (l2 != null) {
//            System.out.println(l2.value);
//            l2 = l2.next;
//        }

        sum(l1, l2);
        if (extra > 0) {
            addResultNode(extra);
        }

        return result;
    }

    private void sum(MyLinkedNode l1, MyLinkedNode l2) {
        if (l1 == null && l2 == null) {
            return;
        }
        //因为左边，右边长度是一样的，所以可以直接同时进行next操作
        sum(l1.next, l2.next);

        //计算当前节点
        int sum = l1.value + l2.value + extra;
        extra = 0;
        if (sum >= 10) {
            sum = sum - 10;
            extra = 1;
        }
        addResultNode(sum);
    }

    private void addResultNode(int value) {
        if (result == null) {
            result = new MyLinkedNode(value);
        } else {
            MyLinkedNode node = new MyLinkedNode(value);
            node.next = result;
            result = node;
        }
    }

    private int countNode(MyLinkedNode node) {
        int count = 0;
        while (node != null) {
            count += 1;
            node = node.next;
        }
        return count;
    }

    private MyLinkedNode addHead(MyLinkedNode node, int count) {

        for (int i = 0; i < count; i++) {
            MyLinkedNode node0 = new MyLinkedNode(0);
            node0.next = node;
            node = node0;
        }


        return node;
    }

}
