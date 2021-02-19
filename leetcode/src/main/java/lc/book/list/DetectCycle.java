package lc.book.list;

public class DetectCycle {

    public static void main(String[] args) {
        DetectCycle instance = new DetectCycle();
        System.out.println(instance.detectCycle(ListNode.generateCycleList(new int[]{}, -1)));
        System.out.println(instance.detectCycle(ListNode.generateCycleList(new int[]{3}, -1)));
        System.out.println(instance.detectCycle(ListNode.generateCycleList(new int[]{3}, 0)));
        System.out.println(instance.detectCycle(ListNode.generateCycleList(new int[]{3, 2, 0, -4}, -1)));
        System.out.println(instance.detectCycle(ListNode.generateCycleList(new int[]{3, 2, 0, -4}, 0)));
        System.out.println(instance.detectCycle(ListNode.generateCycleList(new int[]{3, 2, 0, -4}, 1)));
    }


    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        boolean hasCycle = false;
        ListNode s = head;
        ListNode f = head;
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
            if (s == f) {
                hasCycle = true;
                break;
            }
        }

        // 存在环
        // 解释参考：https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/linked-list-cycle-ii-kuai-man-zhi-zhen-shuang-zhi-/
        if (hasCycle) {
            f = head;
            while (s != f) {
                s = s.next;
                f = f.next;
            }
            return s;
        }
        return null;
    }
}