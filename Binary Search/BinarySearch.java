//Leetcode #704
//https://leetcode.com/problems/car-fleet/
//Time Complexity: O(logn)
//Space Complexity: O(1)
public class BinarySearch {
    public int search(int[] nums, int target) {
        
        int l = 0;
        int r = nums.length-1;
        
        while(l <= r){
            int m = l + (r-l)/2;
            
            if(nums[m] == target)
                return m;
            
            if(nums[m] < target)
                l = m+1;
            else
                r = m-1;
        }
        
        
        return -1;
    }
}
