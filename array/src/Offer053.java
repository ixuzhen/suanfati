/**
 * @author shkstart
 * @create 2022-07-29-11:05
 */
public class Offer053 {
    public int search(int[] nums, int target) {
        if (nums.length == 0)
            return 0;
        int left = getIndex(nums, target);
        int right = getIndex(nums, target+1);
        if(left<nums.length && nums[left]==target)
            return right - left;
        else
            return 0;
    }

//   得到第一个大于等于target的元素
    private int getIndex(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        int res = nums.length;
        while(j>=i){
            int mid = (i+j)/2;
            if(nums[mid]>target){
                j = mid - 1;
                res = mid;
            }else if (nums[mid]<target){
                i = mid + 1;
            }else{
                j = mid - 1;
                res = mid;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Offer053 offer053 = new Offer053();
        int[] ints = {5, 7, 7, 8, 8, 10};
        System.out.println(offer053.search(ints,0));
    }
}

