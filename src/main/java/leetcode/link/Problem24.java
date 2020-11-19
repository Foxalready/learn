package leetcode.link;

import leetcode.common.CommonUtil;
import leetcode.common.MyLinkedNode;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class Problem24 {

    public static void main(String[] args) {

        Problem24 problem24 = new Problem24();
        MyLinkedNode myLinkedNode = MyLinkedNode.create(1, 2, 3, 4);
        MyLinkedNode reverse = problem24.reverse(myLinkedNode);
        CommonUtil.printNode(reverse);


    }

    private MyLinkedNode reverse(MyLinkedNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        MyLinkedNode next = head.next;
        head.next = reverse(next.next);
        next.next = head;

        return next;
    }


}
