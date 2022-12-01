//Leetcode #55
//https://leetcode.com/problems/jump-game/
//Time Complexity: O(n)
//Space Complexity: O(1)
public class JumpGame {
    public boolean canJump(int[] nums) {
        int lastIndex = nums.length-1;
        
        int reach = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(i > reach)
                return false;
            
            reach = Math.max(reach, i+nums[i]);
            
            if(reach >= lastIndex)
                return true;  
        }
        
        return true;
    }
}
