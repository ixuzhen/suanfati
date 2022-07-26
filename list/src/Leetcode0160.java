import utils.ListNode;

public class Leetcode0160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int m = countNodes(headA);
        int n = countNodes(headB);
        if (m > n) {
            int t = m-n;
            for(int i = 0; i < t; i++) {
                headA = headA.next;
            }
        }else if (m < n) {
            int t = n - m;
            for(int i = 0; i < t; i++) {
                headB = headB.next;
            }
        }
        while (headA != null) {
            if(headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    public int countNodes(ListNode l) {
        if (l == null)
            return 0;
        int n = 0;
        while (l != null) {
            n++;
            l = l.next;
        }
        return n;
    }
}
