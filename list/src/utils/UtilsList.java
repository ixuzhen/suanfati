package utils;

import java.util.Scanner;

public class UtilsList {

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

    /**
     * 使用一个字符串来创建一个链表，如："1 2 3 -1"
     * -1是结束的标志，链表中不包括-1
     * @param s
     * @return
     */
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        ListNode list1 = createList(s1);
//        printList(list1);
        ListNode list2 = createList(s2);
//        printList(list2);
    }
}
