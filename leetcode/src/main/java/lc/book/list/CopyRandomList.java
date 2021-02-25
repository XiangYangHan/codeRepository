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
        if (head == null) {
            return null;
        }

        int count = 0;
        Node p = head;
        while (p != null) {
            p = p.next;
            count++;
        }

        Map<Node, Integer> indexMap = new HashMap<>();
        Node[] copy = new Node[count];
        p = head;
        for (int i = 0; i < count; i++) {
            Node node = new Node(p.val);
            copy[i] = node;
            if (i > 0) {
                copy[i - 1].next = node;
            }
            indexMap.put(p, i);
            p = p.next;
        }

        p = head;
        for (int i = 0; i < count; i++) {
            if (p.random != null) {
                copy[i].random = copy[indexMap.get(p.random)];
            }
            p = p.next;
        }
        return copy[0];
    }
}
