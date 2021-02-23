package lc.book.list;

public class MyLinkedList {

    static class Node{
        private int val;
        private Node next, prev;

        public Node() { }

        public Node(int val) { this.val = val; }
    }

    private Node head = null;
    private Node tail = null;
    private int size = 0;


    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    private boolean validateIndex(int index) {
        return index >= 0 && index < size;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (!validateIndex(index)) {
            return -1;
        }
        Node p = head;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node = new Node(val);
        if (size == 0) {
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
        }
        head = node;
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (size == 0) {
            addAtHead(val);
        } else {
            Node node = new Node(val);
            tail.next = node;
            node.prev = tail;
            tail = node;
            size++;
        }
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        } else if (index <= 0) {
            addAtHead(val);
        } else if (index == size) {
            addAtTail(val);
        } else {
            Node p = head;
            for (int i = 0; i < index - 1; i++) {
                p = p.next;
            }
            Node node = new Node(val);
            node.next = p.next;
            node.prev = p;
            p.next.prev = node;
            p.next = node;
            size++;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (!validateIndex(index)) {
            return;
        }
        if (size == 1) {
            head = null;
            tail = null;
        } else if (index == 0) {
            head = head.next;
            head.prev.next = null;
            head.prev = null;
        } else if (index == size - 1){
            tail = tail.prev;
            tail.next.prev = null;
            tail.next = null;
        } else  {
            Node p = head;
            for (int i = 0; i < index; i++) {
                p = p.next;
            }
            p.prev.next = p.next;
            p.next.prev = p.prev;
        }
        size--;
    }
}
