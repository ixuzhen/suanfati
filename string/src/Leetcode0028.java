import org.junit.Test;

public class Leetcode0028 {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0)
            return 0;
        int index = -1;
        for(int i=0; i<=haystack.length()-needle.length(); i++){
            boolean flag = true;
            for(int j=0; j<needle.length(); j++){
                if(haystack.charAt(j+i)!=needle.charAt(j))
                    flag = false;
            }
            if(flag){
                index = i;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Leetcode0028 leetcode0028 = new Leetcode0028();
        int i = leetcode0028.strStr("aaaaa", "a");
        System.out.println(i);
    }

    @Test
    public void test01(){
        String str = "";
        System.out.println(str.length());
    }
}
