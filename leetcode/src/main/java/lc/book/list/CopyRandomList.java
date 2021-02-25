package lc.book.list;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {
    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node p = head;
        while (p != null) {
            map.put(p, new Node(p.val));
            p = p.next;
        }
        p = head;
        while (p != null) {
            Node copy = map.get(p);
            copy.next = map.get(p.next);
            copy.random = map.get(p.random);
            p = p.next;
        }
        return map.get(head);
    }

}
