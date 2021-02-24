package lc.book.list;

import static lc.book.list.ListNode.*;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        AddTwoNumbers instance = new AddTwoNumbers();
        printList(instance.addTwoNumbers(generateNoneCycleList(new int[] {}), generateNoneCycleList(new int[]{})));
        printList(instance.addTwoNumbers(generateNoneCycleList(new int[] {1}), generateNoneCycleList(new int[]{})));
        printList(instance.addTwoNumbers(generateNoneCycleList(new int[] {}), generateNoneCycleList(new int[]{1})));
        printList(instance.addTwoNumbers(generateNoneCycleList(new int[] {1}), generateNoneCycleList(new int[]{1})));
        printList(instance.addTwoNumbers(generateNoneCycleList(new int[] {1}), generateNoneCycleList(new int[]{9})));
        printList(instance.addTwoNumbers(generateNoneCycleList(new int[] {1,0}), generateNoneCycleList(new int[]{1})));
        printList(instance.addTwoNumbers(generateNoneCycleList(new int[] {1,9}), generateNoneCycleList(new int[]{1})));
        printList(instance.addTwoNumbers(generateNoneCycleList(new int[] {1,0}), generateNoneCycleList(new int[]{1,0})));
        printList(instance.addTwoNumbers(generateNoneCycleList(new int[] {1,5}), generateNoneCycleList(new int[]{1,5})));
        printList(instance.addTwoNumbers(generateNoneCycleList(new int[] {1,9}), generateNoneCycleList(new int[]{1,1})));
        printList(instance.addTwoNumbers(generateNoneCycleList(new int[] {1,9,9}), generateNoneCycleList(new int[]{1,0,0})));
        printList(instance.addTwoNumbers(generateNoneCycleList(new int[] {1,9,9,9,9,9,9}), generateNoneCycleList(new int[]{1})));
        printList(instance.addTwoNumbers(generateNoneCycleList(new int[] {1,9,9,9,9,9,9}), generateNoneCycleList(new int[]{1,0})));
        printList(instance.addTwoNumbers(generateNoneCycleList(new int[] {1,9,9,9,9,9,9}), generateNoneCycleList(new int[]{1,0,0,0,0,1})));
        printList(instance.addTwoNumbers(generateNoneCycleList(new int[] {2,4,3}), generateNoneCycleList(new int[]{5,6,4})));
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode p = head;
        int flag = 0;
        while (l1 != null && l2 != null) {
            int bitSum = l1.val + l2.val + flag;
            flag = bitSum / 10;
            p.next = new ListNode(bitSum % 10);
            l1 = l1.next;
            l2 = l2.next;
            p = p.next;
        }
        if (flag == 0) {
            if (l1 != null) {
                p.next = l1;
            }
            if (l2 != null) {
                p.next = l2;
            }
        } else {
            while (l1 != null) {
                int bitSum = l1.val + flag;
                flag = bitSum / 10;
                p.next = new ListNode(bitSum % 10);
                p = p.next;
                l1 = l1.next;
            }
            while (l2 != null) {
                int bitSum = l2.val + flag;
                flag = bitSum / 10;
                p.next = new ListNode(bitSum % 10);
                p = p.next;
                l2 = l2.next;
            }
            if (flag != 0) {
                p.next = new ListNode(flag);
            }
        }
        return head.next;
    }
}
