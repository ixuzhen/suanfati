import org.junit.Test;

import java.util.*;

public class Leetcode0076 {
    public String minWindow(String s, String t) {
        int len_s = s.length();
        int len_t = t.length();
        if (len_s < len_t)
            return "";
        HashMap<Character, Integer> map_s = new HashMap<>();
        HashMap<Character, Integer> map_t = new HashMap<>();
        String res = "";
        int i = 0;
        int j = 0;
        for (; j < t.length(); j++) {
            map_s.put(s.charAt(j), map_s.getOrDefault(s.charAt(j), 0) + 1);
            map_t.put(t.charAt(j), map_t.getOrDefault(t.charAt(j), 0) + 1);
        }
        if (equalsMap(map_s, map_t, t)){
            return s.substring(i,j);
        }

        while (true) {
            if(j>=len_s && i>len_s-len_t)
                break;
            if (equalsMap(map_s, map_t, t)){
                if("".equals(res) || res.length() > j - i){
                    res = s.substring(i, j);
                }
                map_s.put(s.charAt(i), map_s.get(s.charAt(i)) - 1);
                i++;
            }else{
                if(j<s.length()){
                    map_s.put(s.charAt(j), map_s.getOrDefault(s.charAt(j),0)+1);
                    j++;
                }else{
                    i++;
                    if(i<len_s)
                        map_s.put(s.charAt(i), map_s.get(s.charAt(i)) - 1);
                }

            }

        }


        return res;

    }

    public boolean equalsMap(Map<Character, Integer> map_s, Map<Character, Integer> map_t, String s){
        for (Map.Entry<Character, Integer> entry : map_t.entrySet()) {
            if(map_s.getOrDefault(entry.getKey(),0)<entry.getValue())
                return false;
        }

        return true;
    }

//    public boolean equalsMap(Map<Character, Integer> map_s, Map<Character, Integer> map_t, String s){
//        Iterator iter = map_t.entrySet().iterator();
//        while (iter.hasNext()) {
//            Map.Entry entry = (Map.Entry) iter.next();
//            Character key = (Character) entry.getKey();
//            Integer val = (Integer) entry.getValue();
//            if (map_s.getOrDefault(key, 0) < val) {
//                return false;
//            }
//        }
//        return true;
//
//    }


    public static void main(String[] args) {
        Leetcode0076 leetcode0076 = new Leetcode0076();
        String s = leetcode0076.minWindow("ab", "b");
        System.out.println(s);
    }

    @Test
    public void testmap() {
        Map<Character, Integer> map_s = new HashMap<>();
        map_s.put('a', 4);
        map_s.put('b', 5);
        Set<Character> characters = map_s.keySet();
        System.out.println(characters);
        System.out.println(map_s.values());
        Set<Map.Entry<Character, Integer>> entries = map_s.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

    }

    @Test
    public void testSet(){
        Set<String> set = new HashSet<>();
        set.add("abc");
        set.add("123");
        Object[] objects = set.toArray();
        String[] strings = set.toArray(new String[0]);
        System.out.println(123);
    }

    @Test
    public void testString(){
        String s = "21234564";
        System.out.println(s.startsWith("212"));
        System.out.println(s.startsWith("12",0));
        System.out.println(s.startsWith("12",1));
        System.out.println(s.startsWith("23",1));

        System.out.println("------------------------");
        System.out.println(s.indexOf("1"));
        System.out.println(s.indexOf("12"));
        System.out.println(s.indexOf("23"));
        System.out.println(s.indexOf("2"));
        System.out.println(s.indexOf("2",1));

        System.out.println("--------------------");
        System.out.println(s.lastIndexOf("4"));
        System.out.println(s.lastIndexOf("4",s.length()-2));
    }
}
