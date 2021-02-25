package lc.book.list;

public class Flatten {

    public static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }


    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        Node node = new Node();
        Node p = node;
        p.val = head.val;

        Node child = flatten(head.child);
        if (child != null) {
            p.next = child;
            child.prev = p;
        }
        while (p.next != null) {
            p = p.next;
        }
        Node next = flatten(head.next);
        if (next != null) {
            p.next = next;
            next.prev = p;
            p = next;
        }
        return node;
    }
}
