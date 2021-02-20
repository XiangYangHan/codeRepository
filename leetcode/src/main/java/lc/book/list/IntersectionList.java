package lc.book.list;


public class IntersectionList {

    public static void main(String[] args) {
        IntersectionList instance = new IntersectionList();
        instance.printTest(new int[]{}, new int[]{}, new int[]{});
        instance.printTest(new int[]{1}, new int[]{}, new int[]{});
        instance.printTest(new int[]{}, new int[]{1}, new int[]{});
        instance.printTest(new int[]{}, new int[]{}, new int[]{1});
        instance.printTest(new int[]{1}, new int[]{2}, new int[]{3});
        instance.printTest(new int[]{1,2,3}, new int[]{4,5,6}, new int[]{});
        instance.printTest(new int[]{1,2,3}, new int[]{4,5,6}, new int[]{7,8,9});
    }

    public void printTest(int[] a, int[] b, int[] intersection) {
        ListNode headA = ListNode.generateCycleList(a, -1);
        ListNode headB = ListNode.generateCycleList(b, -1);
        ListNode intersectionHead = ListNode.generateCycleList(intersection, -1);

        if (headA == null) {
            headA = intersectionHead;
        } else {
            ListNode pa = headA;
            while (pa.next != null) {
                pa = pa.next;
            }
            pa.next = intersectionHead;
        }
        if (headB == null) {
            headB = intersectionHead;
        } else {
            ListNode pb = headB;
            while (pb.next != null) {
                pb = pb.next;
            }
            pb.next = intersectionHead;
        }

        System.out.println(getIntersectionNode(headA, headB));
    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa = headA;
        ListNode pb = headB;
        while (pa != pb) {
            if (pa == null) {
                pa = headB;
            } else {
                pa = pa.next;
            }
            if (pb == null) {
                pb = headA;
            } else {
                pb = pb.next;
            }
        }
        return pa;
    }
}
