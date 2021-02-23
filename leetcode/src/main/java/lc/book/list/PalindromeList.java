package lc.book.list;

import static lc.book.list.ListNode.*;

/**
 *  请判断一个链表是否为回文链表。
 *
 *  https://leetcode-cn.com/leetbook/read/linked-list/fov6t/
 */
public class PalindromeList {

    public static void main(String[] args) {
        PalindromeList instance = new PalindromeList();
        printList(instance.reverseList(generateNoneCycleList(new int[]{})));
        printList(instance.reverseList(generateNoneCycleList(new int[]{1})));
        printList(instance.reverseList(generateNoneCycleList(new int[]{1,2})));
        printList(instance.reverseList(generateNoneCycleList(new int[]{1,2,3})));

        System.out.println(instance.isPalindrome(generateNoneCycleList(new int[]{})));
        System.out.println(instance.isPalindrome(generateNoneCycleList(new int[]{1})));
        System.out.println(instance.isPalindrome(generateNoneCycleList(new int[]{1,2})));
        System.out.println(instance.isPalindrome(generateNoneCycleList(new int[]{1,1})));
        System.out.println(instance.isPalindrome(generateNoneCycleList(new int[]{1,2,3})));
        System.out.println(instance.isPalindrome(generateNoneCycleList(new int[]{1,2,1})));
        System.out.println(instance.isPalindrome(generateNoneCycleList(new int[]{1,2,2,1})));
        System.out.println(instance.isPalindrome(generateNoneCycleList(new int[]{1,2,3,2,1})));
    }


    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode f = head;
        ListNode s = head;
        ListNode reversePre = head;
        while (f != null && f.next != null) {
            reversePre = s;
            s = s.next;
            f = f.next.next;
        }
        // 元素个数为奇数时，f在最后一个结点，s在中间节点，需要对s之后的节点进行反转（不含s）
        if (f != null) {
            reversePre = s;
        }
        // 从 reversePre 后面开始翻转链表
        reversePre.next = reverseList(reversePre.next);

        // 开始匹配
        f = head;
        s = reversePre.next;
        boolean isPalindrome = true;
        while (s != null) {
            if (s.val != f.val) {
                isPalindrome = false;
                break;
            }
            s = s.next;
            f = f.next;
        }

        // 从 reversePre 后面开始翻转链表，还原链表原始结构
        reversePre.next = reverseList(reversePre.next);
        return isPalindrome;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        ListNode next = head.next;
        while (next != null) {
            head.next = next.next;
            next.next = p;
            p = next;
            next = head.next;
        }
        head.next = null;
        return p;
    }

}
