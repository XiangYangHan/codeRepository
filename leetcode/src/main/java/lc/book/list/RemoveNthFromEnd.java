package lc.book.list;

public class RemoveNthFromEnd {


    public static void main(String[] args) {
        RemoveNthFromEnd instance = new RemoveNthFromEnd();
//        instance.printTest(new int[]{}, 0);
//        instance.printTest(new int[]{1}, 0);
        instance.printTest(new int[]{1}, 1);
        instance.printTest(new int[]{1,2}, 1);
        instance.printTest(new int[]{1,2}, 2);
        instance.printTest(new int[]{1,2,3}, 1);
        instance.printTest(new int[]{1,2,3}, 2);
        instance.printTest(new int[]{1,2,3}, 3);

    }

    public void printTest(int[] arr, int n) {
        ListNode head = ListNode.generateNoneCycleList(arr);
        ListNode.printList(removeNthFromEnd(head, n));
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode f = head;
        for (int i = 0; i < n; i++) {
            f = f.next;
        }

        if (f == null) {
            // 说明要移除第一个元素
            head = head.next;
        } else {
            ListNode s = head;
            while (f.next != null) {
                s = s.next;
                f = f.next;
            }
            s.next = s.next.next;
        }
        return head;
    }
}
