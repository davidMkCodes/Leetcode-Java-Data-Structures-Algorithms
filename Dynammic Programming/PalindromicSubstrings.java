//Leetcode #647
//https://leetcode.com/problems/palindromic-substrings/
//Time Complexity: O(n^2)
//Space Complexity: O(1)
public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int countSubstrings = 0;
        
        for(int i = 0; i < s.length(); i++){
            countSubstrings += getSubstringCount(i, s, false);
            
            if(i+1 < s.length() && s.charAt(i) == s.charAt(i+1))
                countSubstrings += getSubstringCount(i, s, true);
        }
        
        return countSubstrings;
    }
    
    private int getSubstringCount(int i, String s, boolean isEven){
        int count = 1;
        int j = i;
        
        if(isEven)
            j++;
            
        while((i-1 >= 0 && j+1 < s.length()) && s.charAt(i-1) == s.charAt(j+1)){
            i--;
            j++;
            count++;
        }
        
        
        return count;
    }
}
