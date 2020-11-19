package leetcode.link;

import leetcode.common.MyLinkedNode;

public class Problem160 {

    public static void main(String[] args) {

        Problem160 problem160 = new Problem160();

        MyLinkedNode headA = MyLinkedNode.create(1, 2, 3);
        MyLinkedNode headB = MyLinkedNode.create(6, 5);
        MyLinkedNode node = MyLinkedNode.create(4, 7, 8);
        headA.next = node;
        headB.next = node;
        MyLinkedNode a = problem160.getNode(headA, headB);
        System.out.println(a.value);

    }

    public MyLinkedNode getNode(MyLinkedNode headA, MyLinkedNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        MyLinkedNode pa = headA, pb = headB;
        while (pa != pb) {
            pa = (pa != null) ? pa.next : headB;
            pb = (pb != null) ? pb.next : headA;
        }
        return pa;
    }
}
