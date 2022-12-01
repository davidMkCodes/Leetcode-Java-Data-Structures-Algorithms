import java.util.HashMap;

//Leetcode #242
//https://leetcode.com/problems/valid-anagram/
//Time Complexity: O(n)
//Space Complexity: O(n)
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(Character c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        
        for(Character c : t.toCharArray()){
            if(!map.containsKey(c))
                return false;
            map.put(c, map.get(c)-1);
            
            if(map.get(c) == 0)
                map.remove(c);
        }
        
        if(!map.isEmpty())
            return false;
        
        return true;
    }
}
