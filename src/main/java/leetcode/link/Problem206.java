package leetcode.link;


import leetcode.common.CommonUtil;
import leetcode.common.MyLinkedNode;

/**
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class Problem206 {

    private MyLinkedNode head;
    private MyLinkedNode tail;

    public static void main(String[] args) {
        Problem206 problem206 = new Problem206();

        MyLinkedNode node = MyLinkedNode.create(1, 2, 3, 4, 5);
        CommonUtil.printNode(node);
        MyLinkedNode node1 = problem206.reverseList(node);
//        CommonUtil.printNode();
//        MyLinkedNode node1 = problem206.reverseList(node);
        CommonUtil.printNode(node1);

    }

    private MyLinkedNode reverseList(MyLinkedNode node) {
        MyLinkedNode last = null;
        while (node != null) {
            MyLinkedNode tmp = node;
            node = node.next;
            tmp.next = last;
            last = tmp;
        }
        return last;
    }

//    private void reverseList(MyLinkedNode node) {
//        if (node == null) {
//            return;
//        }
//        reverseList(node.next);
//
//        addResultNode(node.value);
//
//        CommonUtil.printNode(head);

//}

    private void addResultNode(int val) {
        if (head == null) {
            head = tail = new MyLinkedNode(val);
        } else {
            MyLinkedNode node = new MyLinkedNode(val);
            tail.next = node;
            tail = node;
        }
    }
}
