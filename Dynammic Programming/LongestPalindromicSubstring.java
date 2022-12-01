
//Leetcode #5
//https://leetcode.com/problems/longest-palindromic-substring/
//Time Complexity: O(n^2)
//Space Complexity: O(n)
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        
        String longestPalindrome = "";
        boolean isEven = s.length()%2 == 0;
        for(int i = 0; i < s.length(); i++){
            String palindrome = checkLength(s, i, false);
            
            if(palindrome.length() > longestPalindrome.length())
                longestPalindrome = palindrome;
            
            if(i+1 < s.length() && s.charAt(i) == s.charAt(i+1)){
                palindrome = checkLength(s, i, true);
                if(palindrome.length() > longestPalindrome.length())
                longestPalindrome = palindrome;
            }
                
        }
        
        return longestPalindrome;
    }
    
    private String checkLength(String s, int i, boolean isEven){
        int j = i;
        
        if(isEven)
            j++;
            
        while(i-1 >= 0 && j+1 < s.length() && (s.charAt(i-1) == s.charAt(j+1))){
            i--;
            j++;
        }
        
        return s.substring(i, j+1);
    }
}
