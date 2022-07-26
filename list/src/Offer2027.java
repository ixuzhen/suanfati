import utils.ListNode;
import utils.UtilsList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Offer2027 {
    public boolean isPalindrome(ListNode head) {
        if (head.next == null)
            return false;
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null){
            fast = fast.next;
            if (fast==null)
                break;
            fast = fast.next;
            if (fast==null)
                break;
            slow = slow.next;
        }

        ListNode laterNode = reverseList(slow.next);
        ListNode p1 = head;
        ListNode p2 = laterNode;
        while(p2!=null){
            if(p1.val != p2.val)
                return false;
        }
        return true;

    }

    public ListNode reverseList(ListNode head){
        ListNode dummpy = new ListNode(-1, null);
        while(head!=null){
            ListNode t = head;
            head = head.next;
            t.next = dummpy.next;
            dummpy.next = t;
        }
        return dummpy.next;
    }

    public static void main(String[] args) {
        ListNode list = UtilsList.createList("1 2 -1");
        UtilsList.printList(list);
        Offer2027 offer2027 = new Offer2027();
        offer2027.isPalindrome(list);

    }


}