
import java.util.HashMap;

//Leetcode #424
//https://leetcode.com/problems/longest-repeating-character-replacement/
//Time Complexity: O(n)
//Space Complexity: O(n)
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0;
        int mostFreq = 0;
        int maxLength = 0;
       
        for(int r = 0; r < s.length(); r++){
            char cR = s.charAt(r);
            map.put(cR, map.getOrDefault(cR, 0)+1);
            
            mostFreq = Math.max(mostFreq, map.get(cR));
            
            while(r-l+1-mostFreq > k){
                char cL = s.charAt(l);
                map.put(cL, map.get(cL)-1);
                l++;
            }
            
            maxLength = Math.max(maxLength, r-l+1);

        }
        
        return maxLength;
    }
}
