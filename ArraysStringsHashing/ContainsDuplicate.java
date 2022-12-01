import java.util.HashSet;

//Leetcode #217
//https://leetcode.com/problems/contains-duplicate/
//Time Complexity: O(n)
//Space Complexity: O(n)
public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        for(int n : nums){
            if(set.contains(n))
                return true;
            
            set.add(n);
        }
        
        return false;
    }
}
