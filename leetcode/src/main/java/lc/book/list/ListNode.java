package lc.book.list;

import java.util.HashSet;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode() {
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode generateNoneCycleList(int[] arr) {
        return generateCycleList(arr, -1);
    }

    /**
     * 构建一个链表，pos指示环入口元素索引
     *
     * @param arr 元素序列
     * @param pos 环入口索引
     * @return
     */
    public static ListNode generateCycleList(int[] arr, int pos) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        ListNode head = new ListNode(arr[0]);
        ListNode p = head;
        for (int i = 1; i < arr.length; i++) {
            p.next = new ListNode(arr[i]);
            p = p.next;
        }

        if (pos >= 0) {
            ListNode entrance = head;
            for (int i = 1; i <= pos; i++) {
                entrance = entrance.next;
            }
            p.next = entrance;
        }
        return head;
    }

    public static void printList(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        ListNode p = head;
        while (p != null) {
            if (set.add(p)) {
                sb.append(",").append(p.val);
                set.add(p);
                p = p.next;
            } else {
                sb.append(",...").append(p.val);
                break;
            }
        }

        if (sb.length() > 0) {
            System.out.println("[" + sb.substring(1) + "]");
        } else {
            System.out.println("[]");
        }
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        ListNode next = head.next;
        while (next != null) {
            head.next = next.next;
            next.next = p;
            p = next;
            next = head.next;
        }
        head.next = null;
        return p;
    }

    public static void main(String[] args) {
        printList(generateCycleList(new int[]{1}, 0));
        printList(generateCycleList(new int[]{1, 2}, 0));
        printList(generateCycleList(new int[]{1, 2, 3}, 1));
        printList(generateCycleList(new int[]{1, 2, 3, 4}, 3));
        printList(reverseList(generateNoneCycleList(new int[]{})));
        printList(reverseList(generateNoneCycleList(new int[]{1})));
        printList(reverseList(generateNoneCycleList(new int[]{1, 2})));
        printList(reverseList(generateNoneCycleList(new int[]{1, 2, 3})));
        printList(reverseList(generateNoneCycleList(new int[]{1, 2, 3, 4})));
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
