package lc.book.list;

import static lc.book.list.ListNode.*;

public class ReverseList {

    public static void main(String[] args) {
        ReverseList instance = new ReverseList();
        instance.printTest(new int[]{});
        instance.printTest(new int[]{1});
        instance.printTest(new int[]{1,2});
        instance.printTest(new int[]{1,2,3});
        instance.printTest(new int[]{1,2,3,4});
    }

    public void printTest(int[] arr) {
        printList(reverseList_01(generateNoneCycleList(arr)));
        printList(reverseList_02(generateNoneCycleList(arr)));
    }


    public ListNode reverseList_01(ListNode head) {
        return iterationReverse(head);
    }

    public ListNode reverseList_02(ListNode head) {
        return recursionReverse(head, null);
    }

    public ListNode iterationReverse(ListNode head) {
        ListNode p1 = null;
        ListNode p2 = head;
        ListNode p3;
        while (p2 != null) {
            p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }

        return p1;
    }

    public ListNode recursionReverse(ListNode cur, ListNode prev) {
        if (cur == null) {
            return prev;
        } else {
            ListNode next = cur.next;
            cur.next = prev;
            return recursionReverse(next, cur);
        }
    }
}
