import java.util.HashMap;

//Leetcode #567
//https://leetcode.com/problems/permutation-in-string/
//Time Compleixty: O(n)
//Space Complexity: O(n)
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s1.toCharArray())
            map.put(c, map.getOrDefault(c, 0)+1);
        
        for(int i = 0; i < s2.length(); i++){
            char c = s2.charAt(i);
            if(map.containsKey(c)){
                HashMap<Character, Integer> tmpMap = new HashMap<>();
                int r = i;
                
                while(r < s2.length() && map.containsKey(s2.charAt(r))){
                    char cR = s2.charAt(r);
                    tmpMap.put(cR, tmpMap.getOrDefault(cR, 0)+1);
                    
                    while(tmpMap.get(cR) > map.get(cR)){
                        char iR = s2.charAt(i);
                        tmpMap.put(iR, tmpMap.getOrDefault(iR, 0)-1);
                        i++;
                    }
                    
                    if(map.equals(tmpMap))
                        return true;
                    
                    r++;
                }
                
                i = r;
            }
        }
        
        return false;
    }
}
