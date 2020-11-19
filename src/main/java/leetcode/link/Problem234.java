package leetcode.link;

import leetcode.common.MyLinkedNode;

/**
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 */
public class Problem234 {


    public static void main(String[] args) {
        Problem234 problem234 = new Problem234();

        MyLinkedNode node = MyLinkedNode.create(1, 1, 2, 1);
        boolean palindrome = problem234.isPalindrome(node);
        System.out.println(palindrome);


    }

    /**
     * 判断链表是否为回文链表
     * 我的想法是 将此链表反转，然后比较此链表和反转后的链表的关系
     * 如果相等，则是回文，如果不相等，则不是回文链表
     * 这种想法肯定是正确的，就是感觉稍显复杂
     * 吐了，是错误的。反转是正确的，但是原来的head数量为啥就成了一个呢？因为在反转操作里面，会把原来的头置为尾部，导致之前的 head的next就是null了，所以这种做法是错误的，不可取
     * <p>
     * <p>
     * 正确的是用两个指针，将链表分为两部分
     * 然后这两个部分进行比较
     *
     * @param head
     * @return
     */
    private boolean isPalindrome(MyLinkedNode head) {

        MyLinkedNode slow = head;
        MyLinkedNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        MyLinkedNode reverse = reverse(slow.next);
        while (reverse != null) {
            if (head.value != reverse.value) {
                return false;
            }
            head = head.next;
            reverse = reverse.next;
        }


        return true;
    }

    private MyLinkedNode reverse(MyLinkedNode head) {

        MyLinkedNode last = null;
        while (head != null) {
            MyLinkedNode tmp = head;
            head = head.next;
            tmp.next = last;
            last = tmp;
        }

        return last;
    }


}
