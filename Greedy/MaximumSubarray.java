//Leetcode #53
//https://leetcode.com/problems/maximum-subarray/
//Time Complexity: O(n)
//Space Complexity: O(1)
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int currMax = nums[0];
        int max = nums[0];
        for(int i = 1; i< nums.length; i++){
            currMax = Math.max(nums[i], nums[i]+currMax);
            max = Math.max(max, currMax);
        }
        
        return max;
    }
}
