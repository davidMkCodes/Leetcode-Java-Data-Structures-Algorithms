import java.util.List;
import java.util.ArrayList;

//Leetcode #494
//https://leetcode.com/problems/target-sum/
//Time Complexity: O(n)
//Space Complexity: O(n)
public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        List<int[]> list = new ArrayList<int[]>();
        for(int i = 0; i < nums.length; i++) list.add(new int[]{0,0});
        
        list.get(0)[0] += nums[0];
        list.get(0)[1] -= nums[0];

        for(int i = 1; i < nums.length; i++){
            int currNum = nums[i];
            list.get(i)[0] = list.get(i-1)[0] + currNum;
            list.get(i)[1] = list.get(i-1)[1] - currNum;
        }
        
        return helper(0, 0, list, nums, target);
    }
    
    
    private int helper(int idx, int num, List<int[]> boundaryList, int[]nums, int target){
        if(idx >= nums.length){
            if(num == target) return 1;
            else return 0;
        }
        
        int[] currBounds = boundaryList.get(idx);
        
        int posWays = 0;
        int positiveNum = num + nums[idx];
        if(positiveNum <= currBounds[0] && positiveNum >= currBounds[1])
            posWays += helper(idx+1, positiveNum, boundaryList, nums, target);
        
        
        int negWays = 0;
        int negativeNum = num - nums[idx];
        if(negativeNum <= currBounds[0] && negativeNum >= currBounds[1])
            negWays += helper(idx+1, negativeNum, boundaryList, nums, target);
        
        return posWays + negWays;
    }
}
