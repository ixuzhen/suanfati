import utils.ListNode;

import java.util.Scanner;
//https://leetcode-cn.com/problems/merge-two-sorted-lists/



public class Leetcode0021 {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null;
        ListNode tail = null;
        if(list1 == null && list2 == null){
            return null;
        }else if(list1 ==null && list2 != null){
            return list2;
        }else if(list2 == null && list1 != null){
            return list1;
        }
        if(list1.val > list2.val){
            head = list2;
            list2 = list2.next;
        }else{
            head = list1;
            list1 = list1.next;
        }
        tail = head;
        while(list1 != null && list2 != null){
            if(list1.val > list2.val){
                tail.next = list2;
                tail = list2;
                list2 = list2.next;
            }else{
                tail.next = list1;
                tail = list1;
                list1 = list1.next;
            }
        }
        if(list1 == null){
            tail.next = list2;
        }
        if(list2 == null){
            tail.next = list1;
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        ListNode list1 = createList(s1);
//        printList(list1);
        ListNode list2 = createList(s2);
//        printList(list2);
        ListNode listNode = mergeTwoLists(list1, list2);
        printList1(listNode);
    }

    public static ListNode createList(String s) {
        if ("-1".equals(s) || "".equals(s))
            return null;
        ListNode head = null;
        ListNode tail = null;
        String[] s1 = s.split(" ");
        for (int i=0; i<s1.length; i++) {
            ListNode t = new ListNode(Integer.parseInt(s1[i]));
            if(i == 0) {
                head = t;
                tail = t;
            }else if(i == (s1.length - 1)){
                break;
            }else{
                tail.next = t;
                tail = t;
            }
        }
        return head;
    }

    public static void printList(ListNode list){
        while(list!=null){
            System.out.print(list.val + " ");
            list = list.next;
        }
        System.out.println();
    }

    public static void printList1(ListNode list){
        while(list!=null){
            System.out.print(list.val);
            if(list.next != null)
                System.out.print(" ");
            list = list.next;
        }
    }

}
