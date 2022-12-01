//Leetcode #238
//https://leetcode.com/problems/product-of-array-except-self/
//Time Complexity: O(n)
//Space Complexity: O(1)
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        
        int maxProduct = 1;
        boolean oneZero = false;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0 && oneZero) return new int[nums.length];
            else if(nums[i] == 0) oneZero = true;
            else{
                maxProduct *= nums[i];
            }
        }
        
        
        if(oneZero){
            for(int i = 0; i < nums.length; i++){
                if(nums[i] != 0)nums[i] = 0;
                else nums[i] = maxProduct;
            }
        }else{
            for(int i = 0; i < nums.length; i++){
                nums[i] = maxProduct/nums[i];
            }
        }
        
        return nums;
    }
}
