//Leetcode #33
//https://leetcode.com/problems/search-in-rotated-sorted-array/
//Time Complexity: O(logn)
//Space Complexity: O(1)
public class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
            
        int l = 0;
        int r = nums.length-1;
        
        while(l < r){
            int m = l + (r-l)/2;
            
            if(nums[m] == target)
                return m;
            
            if(nums[l] <= nums[m]){
                if(nums[l] <= target && target <= nums[m])
                    r = m;
                else
                    l = m+1;
            }else{
                if(nums[m] <= target && target <= nums[r])
                    l = m+1;
                else
                    r = m;
            }
        }
        
        if(nums[l+(r-l)/2] == target)
            return l+(r-l)/2;
        
        return -1;
    }
}
