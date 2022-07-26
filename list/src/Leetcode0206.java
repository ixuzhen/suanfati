import utils.ListNode;

import java.util.List;

public class Leetcode0206 {
    public ListNode reverseList(ListNode head) {
        ListNode p = new ListNode(-1);
        while(head != null) {
            ListNode t = head;
            head = head.next;
            t.next = p.next;
            p.next = t;
        }
        return p.next;
    }
}
