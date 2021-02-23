package lc.book.list;

public class PalindromeList {



    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode f = head;
        ListNode s = head;
        ListNode reversePre = head;
        while (f != null && f.next != null) {
            reversePre = s;
            s = s.next;
            f = f.next.next;
        }

        // 从 s 处开始翻转链表
        reversePre.next = reverseList(reversePre.next);

        // 开始匹配
        f = head;
        boolean isPalindrome = true;
        while (s != null) {
            if (s != f) {
                isPalindrome = false;
            }
            s = s.next;
            f = f.next;
        }

        // 从 s 处开始翻转链表，还原链表
//        reversePre.next = reverseList(reversePre.next);

        return isPalindrome;
    }

    public ListNode reverseList(ListNode head) {
        ListNode p = head;
        ListNode next = head.next;
        while (next != null) {
            head.next = next.next;
            next.next = p;
            p = next;
            next = head.next;
        }
        head.next = null;
        return null;
    }

}
