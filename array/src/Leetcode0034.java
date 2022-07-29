import java.util.Arrays;

/**
 * @author shkstart
 * @create 2022-07-29-10:13
 */
public class Leetcode0034 {


    public int[] searchRange(int[] nums, int target) {
        int leftIndex = getLeftIndex(nums, target);
        int rightIndex = getRightIndex(nums, target)-1;
        if(leftIndex<nums.length && rightIndex<nums.length && nums[leftIndex]==target && nums[rightIndex]==target)
            return new int[]{leftIndex, rightIndex};
        return new int[]{-1, -1};
    }

    private int getRightIndex(int[] nums, int target) {
        int i=0;
        int j= nums.length - 1;
        int ans = nums.length;
        while(j>=i){
            int mid = (i+j)/2;
            if(nums[mid]>target){
                j = mid - 1;
                ans = mid;
            }else if(nums[mid]<target){
                i = mid + 1;
            }else{
                i = mid + 1;
            }
        }
        return ans;

    }

    private int getLeftIndex(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        int ans = 0;
        while(j>=i){
            int mid = (i+j)/2;
            if(nums[mid]>target){
                j = mid - 1;
            }else if(nums[mid]<target){
                i = mid + 1;
            }else{
                ans = mid;
                j = mid - 1;
            }
        }
        return ans;
    }


    public int[] searchRange1(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        int res = -1;
        while (j >= i) {
            int mid = (i + j) / 2;
            if (nums[mid] > target) {
                j = mid - 1;
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else {
                res = mid;
                break;
            }
        }
        if (res == -1) {
            return new int[]{-1, -1};
        }else{
            int t1 = res;
            while(t1>=0 && nums[t1]==target){
                t1--;
            }
            int t2 = res;
            while(t2<nums.length&&nums[t2]==target){
                t2++;
            }
            return new int[]{t1+1,t2-1};
        }

    }

    public static void main(String[] args) {
        Leetcode0034 leetcode0034 = new Leetcode0034();
        int[] ints = {6};
//        int[] ints = {};

        int[] ints1 = leetcode0034.searchRange(ints, 6);
        System.out.println(Arrays.toString(ints1));
    }
}
