//Leetcode #213
//https://leetcode.com/problems/house-robber-ii/
//Time Complexity: O(n)
//Space Complkexity: O(1)
public class HouseRobberTwo {
    public int rob(int[] nums) {
        if(nums.length == 1) 
            return nums[0];
        if(nums.length == 2)
            return Math.max(nums[0], nums[1]);
        
        return Math.max(robHouses(nums, 1, nums.length), robHouses(nums, 0, nums.length-1));
    }
    
    private int robHouses(int[] nums, int start, int end){
        
        int twoBehind = nums[start];
        int oneBehind = Math.max(nums[start+1], twoBehind);
        
        for(int i = start+2; i < end; i++){
            int curr = Math.max(nums[i]+twoBehind, oneBehind);
            
            twoBehind = oneBehind;
            oneBehind = curr;
        }
        
        return oneBehind;
    }
}
