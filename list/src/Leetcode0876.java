import utils.ListNode;

public class Leetcode0876 {
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            fast = fast.next;
            if (fast != null)
                fast = fast.next;
            else
                break;
            slow = slow.next;

        }
        return slow;
    }
}
