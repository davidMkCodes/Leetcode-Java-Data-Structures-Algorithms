import java.util.HashSet;

//Leetcode #202
//https://leetcode.com/problems/happy-number/
class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> visited = new HashSet<Integer>();
        
        while(n != 1){
            if(visited.contains(n))
                return false;
            
            visited.add(n);
            
            StringBuilder s = new StringBuilder();
            s.append(n);
            
            n = 0;
            for(int i = 0; i < s.length(); i++)
                n += (Character.getNumericValue(s.charAt(i))*
                        Character.getNumericValue(s.charAt(i)));
        }
        
        return true;
    }
}
