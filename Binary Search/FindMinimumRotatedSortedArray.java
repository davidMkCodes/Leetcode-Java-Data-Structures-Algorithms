//Leetcode #153
//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
//Time Complexity: O(logn)
//Space Compelxity: O(1)
public class FindMinimumRotatedSortedArray {
    public int findMin(int[] nums) {
        
        int l = 0;
        int r = nums.length-1;
        int m = l + (r-l)/2;
        
        while(l < r){
            m = l + (r-l)/2;
            
            if(nums[l] <= nums[m]){
                if(nums[m] >= nums[r])
                    l = m+1;
                else
                    r = m;
            }else{
                if(nums[l] >= nums[m])
                    r = m;
                else
                    l = m+1;
            }
        }
        
        m = l + (r-l)/2;
            
        return nums[m];
    }
}
