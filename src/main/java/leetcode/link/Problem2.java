package leetcode.link;

import leetcode.common.MyLinkedNode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Problem2 {

    private MyLinkedNode head = null;

    private MyLinkedNode tail = null;

    public static void main(String[] args) {

        Problem2 problem2 = new Problem2();
        MyLinkedNode node1 = MyLinkedNode.create(2, 4, 8);
        MyLinkedNode node2 = MyLinkedNode.create(5, 6, 4);

        MyLinkedNode node = problem2.addTwoNujmbers(node1, node2);

        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }

    }

    private MyLinkedNode addTwoNujmbers(MyLinkedNode l1, MyLinkedNode l2) {
        int extra = 0;
        while (true) {
            //这个sum绝了！！！！！！！
            //把上一个循环的进位作为下一个循环的初始值来进行计算
            int sum = extra;
            extra = 0;
            if (l1 == null && l2 == null) {
                //循环到最后一步的时候，如果还有值，就将这个值相加
                if (sum > 0) {
                    addNode(sum);
                }
                break;
            }
            //计算
            if (l1 != null) {
                sum += l1.value;
            }
            if (l2 != null) {
                sum += l2.value;
            }
            if (sum > 9) {
                sum = sum - 10;
                extra = 1;
            }

            //设置到节点上
            addNode(sum);
            //跳到下个节点
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return head;
    }

    private void addNode(int value) {
        //不存在头节点
        if (head == null) {
            head = tail = new MyLinkedNode(value);
            return;
        }

        //存在头节点
        //直接加到尾节点的下一个，然后将尾节点的指针移到最后
        tail.next = new MyLinkedNode(value);
        tail = tail.next;
    }


    private MyLinkedNode addTwoNum(MyLinkedNode l1, MyLinkedNode l2) {

        int a = 0;
        int b = 0;
        int c = 1;
        int d = 1;
        while (l1 != null) {
            a = a + l1.value * c;
            c = c * 10;
            l1 = l1.next;
        }

        while (l2 != null) {
            b = b + l2.value * d;
            d = d * 10;
            l2 = l2.next;
        }

        int e = a + b;
        int count = 1;
        int i1 = e % 10;
        System.out.println(i1);
        while (e / 10 > 0) {
            count += 1;
            e = e / 10;
        }

//        for (int i = count; i <0; i++) {
//            e=
//        }

        int i = e % 10;
        int j = (e / 10) % 10;
        int k = (e / 100) % 10;

        MyLinkedNode nodek = new MyLinkedNode(k);
        MyLinkedNode nodej = new MyLinkedNode(j);
        MyLinkedNode nodei = new MyLinkedNode(i);

        nodei.next = nodej;
        nodej.next = nodek;


        return nodei;
    }

}
