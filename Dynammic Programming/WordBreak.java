import java.util.HashSet;
import java.util.List;

//Leetcode #139
//https://leetcode.com/problems/word-break/
//Time Complexity: O(n^3)
//Space Complexity: O(n)
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        
        HashSet<String> set = new HashSet<>();
        for(String word : wordDict)
            set.add(word);

        boolean[]dp = new boolean[s.length()+1];
        for(int i = 0; i < dp.length; i++)
            dp[i] = false;
        dp[dp.length-1] = true;
        
        for(int i = s.length()-1; i >= 0; i--){
            
            for(int j = s.length(); j >= i; j--){
                String currString = s.substring(i,j);
                
                if(set.contains(currString) && dp[i] != true){
                    dp[i] = dp[j];
                }
                
            }
            
        }
        
        return dp[0];
    }
}
