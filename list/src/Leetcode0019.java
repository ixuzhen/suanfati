import utils.ListNode;
import utils.UtilsList;

// https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
public class Leetcode0019 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = new ListNode(-1, slow);
//      让fast先走n-1步
        for (int i = 1; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
            pre = pre.next;
        }
        pre.next = slow.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode list = UtilsList.createList("1 2 3 4 5 -1");
        UtilsList.printList(list);
        ListNode listNode = removeNthFromEnd(list, 2);
        UtilsList.printList1(listNode);

    }
}
