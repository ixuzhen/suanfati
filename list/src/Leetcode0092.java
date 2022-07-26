import utils.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode0092 {
//    方法2
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1, head);
        ListNode pre = dummyNode;
        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }
        ListNode leftNode = pre.next;
        ListNode curr = leftNode.next;
        for (int i = 0; i < (right - left); i++) {
            ListNode t = curr;
            curr = curr.next;
            leftNode.next = curr;
            t.next = pre.next;
            pre.next = t;
        }
        return dummyNode.next;
    }

// 方法一
    public ListNode reverseBetween1(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1, head);
        ListNode pre = dummyNode;
        ListNode pl = head;
        ListNode pr = head;
        ListNode ptail;
        for (int i = 1; i < left; i++) {
            pl = pl.next;
            pre = pre.next;
        }
        for (int i = 1; i < right; i++){
            pr = pr.next;
        }
        ListNode pr_next = pr.next;
        pr.next = null;
        reverseTemp(pl);
        pre.next = pr;
        pl.next = pr_next;

        return dummyNode.next;
    }

    private void reverseTemp(ListNode pl) {
        ListNode head = new ListNode(-1);
        while(pl != null){
            ListNode t = pl;
            pl = pl.next;
            t.next = head.next;
            head.next = t;
        }
    }
}
