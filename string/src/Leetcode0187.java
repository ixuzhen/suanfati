import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Leetcode0187 {
    public List<String> findRepeatedDnaSequences(String s) {
        ArrayList<String> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<=s.length()-10; i++){
            String t = s.substring(i, i + 10);
            map.put(t,map.getOrDefault(t,0)+1);
        }
        for (String s1 : map.keySet()) {
            if(map.get(s1)>1){
                res.add(s1);
            }
        }
        return res;

    }

    public static void main(String[] args) {
        Leetcode0187 leetcode0187 = new Leetcode0187();
        List<String> res = leetcode0187.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        System.out.println(res);
    }
}
