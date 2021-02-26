package lc.book.list;

import static lc.book.list.ListNode.*;

public class RotateRight {

    public static void main(String[] args) {
        RotateRight instance = new RotateRight();
        printList(instance.rotateRight(generateNoneCycleList(new int[]{}), 0));
        printList(instance.rotateRight(generateNoneCycleList(new int[]{1}), 0));
        printList(instance.rotateRight(generateNoneCycleList(new int[]{1,2}), 0));
        printList(instance.rotateRight(generateNoneCycleList(new int[]{1,2,3}), 0));
        printList(instance.rotateRight(generateNoneCycleList(new int[]{}), 1));
        printList(instance.rotateRight(generateNoneCycleList(new int[]{1}), 1));
        printList(instance.rotateRight(generateNoneCycleList(new int[]{1,2}), 1));
        printList(instance.rotateRight(generateNoneCycleList(new int[]{1,2,3}), 1));
        printList(instance.rotateRight(generateNoneCycleList(new int[]{}), 2));
        printList(instance.rotateRight(generateNoneCycleList(new int[]{1}), 2));
        printList(instance.rotateRight(generateNoneCycleList(new int[]{1,2}), 2));
        printList(instance.rotateRight(generateNoneCycleList(new int[]{1,2,3}), 2));
        printList(instance.rotateRight(generateNoneCycleList(new int[]{1,2,3,4}), 10));
        printList(instance.rotateRight(generateNoneCycleList(new int[]{1,2,3,4}), 100));

    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        int count = 1;
        while (p.next != null) {
            count++;
            p = p.next;
        }
        k = k % count;
        if (k == 0) {
            return head;
        }

        ListNode s = head;
        p = head;
        int i = 1;
        while (p.next != null) {
            p = p.next;
            if (i > k) {
                s = s.next;
            }
            i++;
        }

        p.next = head;
        head = s.next;
        s.next = null;

        return head;
    }
}
