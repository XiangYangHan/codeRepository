package lc.book.list;

import java.util.Objects;

public class HasCycle {

    public static void main(String[] args) {
        HasCycle instance = new HasCycle();
        System.out.println(instance.hasCycle(ListNode.generateCycleList(new int[]{3, 2, 0, -4}, -1)));
        System.out.println(instance.hasCycle(ListNode.generateCycleList(new int[]{3, 2, 0, -4}, 0)));
        System.out.println(instance.hasCycle(ListNode.generateCycleList(new int[]{3, 2, 0, -4}, 1)));
    }

    public boolean hasCycle(ListNode head) {
        boolean result = false;
        ListNode f = head;
        ListNode s = head;
        while (Objects.nonNull(f) && Objects.nonNull(f.next)) {
            f = f.next.next;
            s = s.next;
            if (Objects.equals(s, f)) {
                result = true;
                break;
            }
        }

        return result;
    }
}
