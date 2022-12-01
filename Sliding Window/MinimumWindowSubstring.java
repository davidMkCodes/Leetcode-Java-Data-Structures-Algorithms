
import java.util.HashMap;

//Leetcode #76
//https://leetcode.com/problems/minimum-window-substring/
//Time Complexity: O(s+t)
//Space Complexity: O(s+t)
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if(s.length() < t.length())
            return new String();
        
        String minWindow = "";
            
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        
        HashMap<Character, Integer> haveMap = new HashMap<>();
        int i = 0, have = 0;
        for(int j = 0; j < s.length(); j++){
            char c1 = s.charAt(j);
            
            if(map.containsKey(c1)){
                haveMap.put(c1, haveMap.getOrDefault(c1, 0) + 1);
                
                if(haveMap.get(c1) <= map.get(c1))
                    have++;
            }
            
            while(have == t.length()){
                if(minWindow == "" || j-i+1 <= minWindow.length())
                    minWindow = s.substring(i,j+1);
                
                char c2 = s.charAt(i);
                if(map.containsKey(c2)){
                    haveMap.put(c2, haveMap.get(c2)-1);
                    
                    if(haveMap.get(c2) < map.get(c2))
                        have--;
                }
                
                i++;
            }
        }
            
        return minWindow;
    }
}
