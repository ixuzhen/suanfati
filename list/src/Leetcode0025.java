import utils.ListNode;
import utils.UtilsList;

public class Leetcode0025 {
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyNode = new ListNode(-1, head);
        ListNode pre = dummyNode;
        ListNode pLeft = null;
        ListNode pRight = null;
        ListNode pTail = null;
        while (true) {
            pLeft = pre.next;
            pRight = pLeft;
            if (pLeft == null)
                break;
            for (int i = 1; i < k; i++) {
                pRight = pRight.next;
                if (pRight == null)
                    return dummyNode.next;
            }
            pTail = pRight.next;
            pRight.next = null;
            reverse(pLeft);
            pre.next = pRight;
            pLeft.next = pTail;
            pre = pLeft;
        }
        return dummyNode.next;
    }

    public static void reverse(ListNode head) {
        ListNode dummyNode = new ListNode(-1);
        while(head != null) {
            ListNode t = head;
            head = head.next;
            t.next = dummyNode.next;
            dummyNode.next = t;
        }
    }

    public static void main(String[] args) {
        ListNode list = UtilsList.createList("1 2 3 4 5 -1");
        UtilsList.printList(list);
        ListNode listNode = reverseKGroup(list, 2);
        UtilsList.printList1(listNode);
    }

}
