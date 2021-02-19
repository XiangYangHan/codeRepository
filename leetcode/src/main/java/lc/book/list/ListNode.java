package lc.book.list;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode() {
    }

    /**
     * 构建一个链表，pos指示环入口元素索引
     * @param arr 元素序列
     * @param pos 环入口索引
     * @return
     */
    public static ListNode generateCycleList (int[] arr, int pos) {
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
}
