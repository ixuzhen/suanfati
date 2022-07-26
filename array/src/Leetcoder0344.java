public class Leetcoder0344 {
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length-1;
        for(;i<j;i++,j--){
            char t = s[i];
            s[i] = s[j];
            s[j] = t;
        }
    }
}
