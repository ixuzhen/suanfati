import java.util.Arrays;

public class Leetcode0005 {



    public String longestPalindrome(String s) {
        if (s.length()<2){
            return s;
        }
        char[] chars = s.toCharArray();
        int min_index = 0;
        int max_index = 0;
        int max_len = 1;
        int[] subString_len;
        for (int i=0; i<chars.length; i++){
            subString_len = getPalidromeLen(chars,i-1, i+1);
            if(subString_len[2]>max_len){
                min_index = subString_len[0];
                max_index = subString_len[1];
                max_len = subString_len[2];
            }
            if(i+1<chars.length && chars[i]==chars[i+1]){
                subString_len = getPalidromeLen(chars,i, i+1);
            }
            if(subString_len[2]>max_len){
                min_index = subString_len[0];
                max_index = subString_len[1];
                max_len = subString_len[2];
            }
        }
        return s.substring(min_index, max_index+1);
    }

    private int[] getPalidromeLen(char[] chars, int i, int j) {
        while(i>=0 && j<chars.length && chars[i]==chars[j]) {
            i--;
            j++;
        }
        int len = j-i-1;
        return new int[]{i+1, j-1, len};
    }

    //    暴力解法
    public String longestPalindrome1(String s) {
        int len = s.length();
        int min_index = 0;
        int max_index = 1;
        int max_len = 1;
        for(int i = 0; i<len; i++){
            for (int j = i+1; j<=len; j++){
                String substring = s.substring(i, j);
                if(isPalindrome(substring)){
                    if(max_len<j-i){
                        max_len = j - i;
                        min_index = i;
                        max_index = j;
                    }
                }
            }
        }


        return s.substring(min_index, max_index+1);
    }

    public boolean isPalindrome(String s){
        int i = 0;
        int j = s.length()-1;
        for(;i<j;i++,j--){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "bb";
        Leetcode0005 leetcode0005 = new Leetcode0005();
        String s1 = leetcode0005.longestPalindrome(s);
        System.out.println(s1);
        char[] chars = s.toCharArray();
        int[] palidromeLen = leetcode0005.getPalidromeLen(chars, 0, 1);
        System.out.println(Arrays.toString(palidromeLen));
    }


}
