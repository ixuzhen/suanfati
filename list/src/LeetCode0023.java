import utils.ListNode;
import utils.UtilsList;

import java.util.Comparator;
import java.util.PriorityQueue;

//import utils.UtilsList;
public class LeetCode0023 {
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        PriorityQueue<ListNode> q = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                return (l1.val - l2.val);
            }
        });

        for(ListNode l : lists){
            if(l != null){
                q.offer(l);
            }
        }
        while(!q.isEmpty()){
            ListNode poll = q.poll();
            tail.next = poll;
            tail = poll;
            ListNode t = poll.next;
            if(t != null)
                q.offer(t);
        }
        return head.next;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode[] a = new ListNode[]{l1, l2, l3};

        ListNode listNode = mergeKLists(a);
        UtilsList.printList1(listNode);

    }
}
