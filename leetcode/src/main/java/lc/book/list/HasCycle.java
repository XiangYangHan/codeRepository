package lc.book.list;

public class HasCycle {

    public static void main(String[] args) {
        HasCycle instance = new HasCycle();
        System.out.println(instance.hasCycle(ListNode.generateCycleList(new int[]{3, 2, 0, -4}, -1)));
        System.out.println(instance.hasCycle(ListNode.generateCycleList(new int[]{3, 2, 0, -4}, 0)));
        System.out.println(instance.hasCycle(ListNode.generateCycleList(new int[]{3, 2, 0, -4}, 1)));
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode s = head;
        ListNode f = head.next;
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
            if (s == f) {
                break;
            }
        }
        return s == f;
    }
}
