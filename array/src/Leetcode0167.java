import java.util.Arrays;

public class Leetcode0167 {

    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = 0;
        for (i=0; i<numbers.length; i++){
            for (j=0; j<numbers.length; j++){
                if(i!=j){
                    if(numbers[i]+numbers[j]==target){
                        return new int[]{i+1,j+1};
                    }
                }
            }
        }
        return new int[]{i, j};
    }

    public int[] twoSum1(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length-1;

        while (j>i){
            if(numbers[i]+numbers[j]>target)
                j--;
            if(numbers[i]+numbers[j]<target)
                i++;
            if(numbers[i]+numbers[j]==target)
                return new int[]{i + 1, j + 1};
        }

        return new int[]{-1,-1};
    }



    public static void main(String[] args) {
//        int[] ints = new int[]{2,7,11,15};
//        Leetcode0167 leetcode0167 = new Leetcode0167();
//        int[] ints1 = leetcode0167.twoSum1(ints,9);
//        System.out.println(Arrays.toString(ints1));
//
        int[] a = {1,2,3};
        int[][] a1 = new int[2][];
        a1[0] = new int[3];
        System.out.println(a1[0].length);
    }

}
