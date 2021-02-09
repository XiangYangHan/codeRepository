package lc.book.list;

import java.util.Objects;

public class HasCycle {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
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
