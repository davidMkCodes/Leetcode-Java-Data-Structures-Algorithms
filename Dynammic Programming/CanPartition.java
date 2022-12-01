import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

//Leetcode #416
//https://leetcode.com/problems/partition-equal-subset-sum/
//Time Complexity: O(n*m)
//Space Complexity: O(n)
public class CanPartition {
    public boolean canPartition(int[] nums) {
        
        int totalSum = 0;
        for(int n : nums)
            totalSum += n;
        
        if(totalSum % 2 != 0)
            return false;
        
        int subSetTarget = totalSum/2;
        List<Integer> allSums = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        allSums.add(0);
        for(int i = 0; i < nums.length; i++){
            int currNum = nums[i];
            
            int size = allSums.size();
            for(int j = 0; j < size; j++){
                int currSum = currNum + allSums.get(j);
                if(currSum == subSetTarget)
                    return true;
                
                if(!set.contains(currSum)){
                    allSums.add(currSum);
                    set.add(currSum);
                }
            }
        }
        
        return false;
    }
}
