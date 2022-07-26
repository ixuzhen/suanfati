import java.util.*;

public class Leetcode0438 {
    public List<Integer> findAnagrams(String s, String p) {
        int len_s = s.length();
        int len_p = p.length();
        if (len_s < len_p)
            return new ArrayList<Integer>();
        int[] array_s = new int[26];
        int[] array_p = new int[26];

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len_p; i++) {
            ++array_s[s.charAt(i) - 'a'];
            ++array_p[p.charAt(i) - 'a'];
        }

        if(Arrays.equals(array_s, array_p)){
            list.add(0);
        }

        for(int i=1; i<=len_s-len_p; i++){
            --array_s[s.charAt(i-1)-'a'];
            ++array_s[s.charAt(i+len_p-1)-'a'];
            if(Arrays.equals(array_s, array_p)){
                list.add(i);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        Leetcode0438 leetcode0438 = new Leetcode0438();
        List<Integer> anagrams = leetcode0438.findAnagrams("cbaebabacd", "abc");
        System.out.println(anagrams);


    }
}
