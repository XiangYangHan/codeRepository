package lc.book.list;

import static lc.book.list.ListNode.*;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class MergeTwoList {

    public static void main(String[] args) {
        MergeTwoList instance = new MergeTwoList();

        printList(instance.mergeTwoLists(generateNoneCycleList(new int[]{}), generateNoneCycleList(new int[]{})));
        printList(instance.mergeTwoLists(generateNoneCycleList(new int[]{1}), generateNoneCycleList(new int[]{})));
        printList(instance.mergeTwoLists(generateNoneCycleList(new int[]{}), generateNoneCycleList(new int[]{1})));
        printList(instance.mergeTwoLists(generateNoneCycleList(new int[]{1}), generateNoneCycleList(new int[]{2})));
        printList(instance.mergeTwoLists(generateNoneCycleList(new int[]{1,2,3}), generateNoneCycleList(new int[]{4,5,6})));
        printList(instance.mergeTwoLists(generateNoneCycleList(new int[]{1,3,5}), generateNoneCycleList(new int[]{2,4,6})));
        printList(instance.mergeTwoLists(generateNoneCycleList(new int[]{1,2,3,5}), generateNoneCycleList(new int[]{2,4,5,6})));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode p = head;

        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p = p2;
                p2 = p2.next;
            }
        }
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return head.next;
    }
}
