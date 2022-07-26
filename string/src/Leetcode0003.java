import java.util.HashSet;
import java.util.Set;
import java.lang.String;
public class Leetcode0003 {

    public int lengthOfLongestSubstring(String s) {

        char[] str = s.toCharArray();
        int i = 0;
        int j = 0;
        int max = 0;
        Set<Character> hashSet = new HashSet<>();
        while(j<str.length){
            if(!hashSet.contains(str[j])){
                hashSet.add(str[j]);
                j++;
                max = Math.max(max, hashSet.size());
            }else{
                while(str[i]!=str[j]){
                    hashSet.remove(str[i]);
                    i++;
                }
                hashSet.remove(str[i]);
                i++;
            }
        }
        return max;
    }


    public int lengthOfLongestSubstring1(String s) {
        char[] str = s.toCharArray();
        int i = 0;
        int j = 0;
        int max = 0;
        Set<Character> hashSet = new HashSet<>();
        while(j<str.length){
            if(!hashSet.contains(str[j])){
                hashSet.add(str[j]);
                j++;
                if(max<hashSet.size()){
                    max = hashSet.size();
                }
            }else{
                if(max<hashSet.size()){
                    max = hashSet.size();
                }
                while(str[i]!=str[j]){
                    hashSet.remove(str[i]);
                    i++;
                }
                hashSet.remove(str[i]);
                i++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Leetcode0003 leetcode0003 = new Leetcode0003();
        int abcabcbb = leetcode0003.lengthOfLongestSubstring("a");
        System.out.println(abcabcbb);
    }
}
