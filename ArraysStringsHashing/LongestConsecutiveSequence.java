import java.util.HashSet;

//Leetcode #128
//Time Complexity: O(n)
//Space Complexity: O(n)
//https://leetcode.com/problems/longest-consecutive-sequence/
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        
        HashSet<Integer> set = new HashSet<>();
        for(int n : nums)
            set.add(n);
        
        int longestStreak = 0;
        for(int n : set){
            if(!set.contains(n-1)){
                int currStreak = 1;
                int currNum = n;
                while(set.contains(currNum+1)){
                    currStreak++;
                    currNum++;
                }
                
                longestStreak = Math.max(longestStreak, currStreak);
            }
        }
        
        return longestStreak;
    }
}
