import utils.ListNode;

public class leetcode0234 {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        swag(a, b);
        System.out.println();
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
    public static void swag(Integer a, Integer b){
        int t = a;
        a = b;
        b =t;
    }
}
