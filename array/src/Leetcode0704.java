/**
 * @author shkstart
 * @create 2022-07-29-10:55
 */
public class Leetcode0704 {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while(r>=l){
            int mid = (r + l) / 2;
            if(nums[mid]>target){
                r = mid - 1;
            }else if(nums[mid]<target){
                l = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
