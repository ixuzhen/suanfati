public class Leetcode0303 {
    private int[] sums;

    public Leetcode0303(int[] nums) {
        this.sums = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            if(i==0)
                sums[i] = nums[i];
            else
                sums[i] = sums[i-1]+nums[i];
        }

    }

    public int sumRange(int left, int right) {
        if(left == 0)
            return sums[right];
        return sums[right] - sums[left-1];
    }

}
