package lc.book.list;

import static lc.book.list.ListNode.*;

public class RemoveElement {

    public static void main(String[] args) {
        RemoveElement instance = new RemoveElement();
        printList(instance.removeElements(generateNoneCycleList(new int[]{}), 6));
        printList(instance.removeElements(generateNoneCycleList(new int[]{1}), 6));
        printList(instance.removeElements(generateNoneCycleList(new int[]{1,2}), 6));
        printList(instance.removeElements(generateNoneCycleList(new int[]{6}), 6));
        printList(instance.removeElements(generateNoneCycleList(new int[]{6,6}), 6));
        printList(instance.removeElements(generateNoneCycleList(new int[]{6,6,6}), 6));
        printList(instance.removeElements(generateNoneCycleList(new int[]{6,2,3,4,6,6}), 6));
        printList(instance.removeElements(generateNoneCycleList(new int[]{1,6,2,3,4,6,6}), 6));
        printList(instance.removeElements(generateNoneCycleList(new int[]{1,6,2,3,4,6,6,7}), 6));
    }

    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return null;
        }

        ListNode p = head;
        while (p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }

        return head;
    }
}
