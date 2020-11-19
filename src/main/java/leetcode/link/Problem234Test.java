package leetcode.link;

import leetcode.common.MyLinkedNode;

public class Problem234Test {

    public boolean isPalindrome(MyLinkedNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // 寻找左半边链表的结尾
        MyLinkedNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 如果节点为奇数，则 slow 指向链表的中间点；
        // 如果节点为偶数，则 slow 指向链表的左边链表的尾巴；
        // 下面，我们要将 slow 跳到右边链表的开头，因为后续要反转右半边的链表
        MyLinkedNode right = reverse(slow.next);

        // 开始比较
        MyLinkedNode left = head; // 注意，这个 left 其实是全链表，这么写就是为了清晰。
        while (right != null) {
            if (right.value != left.value) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        // 比较成功，返回 true
        return true;
    }

    private MyLinkedNode reverse(MyLinkedNode head) {
        MyLinkedNode prev = null;
        while (head != null) {
            MyLinkedNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }
        return prev;
    }

    public static void main(String[] args) {
        Problem234Test solution = new Problem234Test();
//        System.out.println(solution.isPalindrome(MyLinkedNode.create(1, 2)));
        System.out.println(solution.isPalindrome(MyLinkedNode.create(1, 2, 2, 1)));
        System.out.println(solution.isPalindrome(MyLinkedNode.create(1, 2, 1)));
        System.out.println(solution.isPalindrome(MyLinkedNode.create(1, 2, 3, 2, 1)));
        System.out.println(solution.isPalindrome(MyLinkedNode.create(1, 2, 3, 2, 2)));
    }
}
