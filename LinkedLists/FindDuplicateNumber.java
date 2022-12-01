import java.util.HashSet;
//Leetcode #187
//https://leetcode.com/problems/linked-list-cycle/
//Time Complexity: O(n)
//Space Complexity: O(n)
public class FindDuplicateNumber {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int n : nums){
            if(set.contains(n))
                return n;
            
            set.add(n);
        }
        
        return -1;
    }
}