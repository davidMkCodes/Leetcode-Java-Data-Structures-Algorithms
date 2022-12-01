import java.util.HashMap;

//Leetcode #1
//https://leetcode.com/problems/two-sum/
//Time Complexity: O(n)
//Space Complexity: O(n)
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] twoSum = new int[2];
        for(int i = 0; i < nums.length; i++){
            int curr = nums[i];
            int needed = target - curr;
            if(map.containsKey(needed)){
                twoSum[0] = i;
                twoSum[1] = map.get(needed);
                break;
            }
            
            map.put(curr, i);
        }
        
        return twoSum;
    }
}
