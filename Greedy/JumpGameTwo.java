//Leetcode #45
//https://leetcode.com/problems/jump-game-ii/
//Time Complexity: O(n)
//Space Complexity: O(1)
public class JumpGameTwo {
    public int jump(int[] nums) {
        if(nums.length == 1)
            return 0;
        
        int lastIndex = nums.length-1;
        
        int minJumpDistance = nums[0];
        int jumps = 1;
        int reach = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(i > minJumpDistance){
                jumps++; 
                minJumpDistance = reach;
            }
            
            reach = Math.max(reach, i+nums[i]);
            
            if(reach >= lastIndex){
                if(minJumpDistance < lastIndex)
                    jumps++;
                return jumps;
            }
        }
        
        return jumps;
    }
}
