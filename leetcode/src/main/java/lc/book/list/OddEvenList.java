package lc.book.list;

import static lc.book.list.ListNode.*;

public class OddEvenList {

    public static void main(String[] args) {
        OddEvenList instance = new OddEvenList();

        printList(instance.oddEvenList(generateNoneCycleList(new int[] {})));
        printList(instance.oddEvenList(generateNoneCycleList(new int[] {1})));
        printList(instance.oddEvenList(generateNoneCycleList(new int[] {1,2})));
        printList(instance.oddEvenList(generateNoneCycleList(new int[] {1,2,3})));
        printList(instance.oddEvenList(generateNoneCycleList(new int[] {1,2,3,4})));
        printList(instance.oddEvenList(generateNoneCycleList(new int[] {1,2,3,4,5})));
        printList(instance.oddEvenList(generateNoneCycleList(new int[] {1,2,3,4,5,6})));
        printList(instance.oddEvenList(generateNoneCycleList(new int[] {1,2,3,4,5,6,7})));
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode oddHead = head;
        ListNode oddTail = head;
        ListNode evenHead = head.next;
        ListNode evenTail = head.next;

        ListNode p = head.next.next;
        for (int i = 0; p != null; i++) {
            if ((i & 1) == 1) {
                evenTail.next = p;
                evenTail = p;
            } else {
                oddTail.next = p;
                oddTail = p;
            }
            p = p.next;
        }
        oddTail.next = evenHead;
        evenTail.next = null;
        return oddHead;
    }

}
