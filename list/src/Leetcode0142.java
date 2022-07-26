import utils.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode0142 {
    /**
     * 解法一：使用hashset
     *
     * @param head
     * @return
     */
    public ListNode detectCycle01(ListNode head) {
        if (head == null) {
            return null;
        }
        Set<ListNode> s = new HashSet<>();
        s.add(head);
        while (head != null) {
            ListNode next = head.next;
            if (s.contains(next))
                return next;
            s.add(next);
            head = head.next;
        }
        return null;
    }


    /**
     * 解法二：使用快慢指针法
     *
     * @param head
     * @return
     */
    public ListNode detectCycle02(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null)
                fast = fast.next.next;
            else
                return null;
            if (fast == slow) {
                while(pre != slow){
                    pre = pre.next;
                    slow = slow.next;
                }
                return pre;
            }

        }
        return null;
    }
}
