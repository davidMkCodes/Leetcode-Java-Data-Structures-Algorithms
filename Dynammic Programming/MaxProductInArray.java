
//Leetcode #152
//https://leetcode.com/problems/maximum-product-subarray/
//Time Complexity: O(n)
//Space Complexity: O(1)
public class MaxProductInArray {
    public int maxProduct(int[] nums) {
        
        int currMax = nums[0];
        int currMin = nums[0];
        int result = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == 0){
                result = Math.max(result, Math.max(currMax, 0));
                currMax = 0;
                currMin = 0;
                continue;
            }
            
            int currNum = nums[i];
            int max = currMax*nums[i];
            int min = currMin*nums[i];
            
            currMax = Math.max(currNum, Math.max(max, min));
            currMin = Math.min(currNum, Math.min(max, min));
            result = Math.max(result, currMax);
        }
        
        
        return result;
    }
}
