import utils.ListNode;

public class LeetCode0141 {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != fast){
            if(slow == null || fast == null)
                return false;
            slow = slow.next;
            fast = fast.next;
            if(fast == null)
                return false;
            fast = fast.next;
        }
        return true;
    }
}
