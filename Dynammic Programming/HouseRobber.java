//Leetcode #198
//https://leetcode.com/problems/house-robber/
//Time Complexity: O(n)
//Space Complexity: O(1)
public class HouseRobber {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        
        int twoBehind = nums[0];
        int oneBehind = Math.max(nums[0], nums[1]);
        
        for(int i = 2; i < nums.length; i++){
            int curr = Math.max(nums[i]+twoBehind, oneBehind);
            
            twoBehind = oneBehind;
            oneBehind = curr;
        }
        
        return oneBehind;
    }
}
