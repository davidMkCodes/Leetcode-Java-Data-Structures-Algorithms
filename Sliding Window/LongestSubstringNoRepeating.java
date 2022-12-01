import java.util.HashMap;
//Leetcode #3
//https://leetcode.com/problems/longest-substring-without-repeating-characters/
//Time Complexity: O(n)
//Space Complexity: O(n)
public class LongestSubstringNoRepeating {
    public int lengthOfLongestSubstring(String s) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        int longestLength = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if(map.containsKey(c)){
                left = Math.max(left, map.get(c)+1);
                
            }
            
            map.put(c, i);
            
            
            longestLength = Math.max(longestLength, i-left+1);
        }
        
        return longestLength;
    }
}
