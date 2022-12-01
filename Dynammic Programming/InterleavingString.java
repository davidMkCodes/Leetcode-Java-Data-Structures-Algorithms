//Leetcode #97
//https://leetcode.com/problems/interleaving-string/
//Time Complexity: O(m*n)
//Space COmplexity: O(m*n)
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length())
            return false;
        
        boolean[][]dp = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;
        for(int i = 1; i < dp.length; i++){
            if(s1.charAt(i-1) == s3.charAt(i-1) && dp[i-1][0])
                dp[i][0] = true;
            else dp[i][0] = false;
        }
        
        for(int j = 1; j < dp[0].length; j++){            
            if(s2.charAt(j-1) == s3.charAt(j-1) && dp[0][j-1])
                dp[0][j] = true;
            else dp[0][j] = false;
        }
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                int idx = i+j-1;
                
                if((s1.charAt(i-1) == s3.charAt(idx) && dp[i-1][j]) || 
                   (s2.charAt(j-1) == s3.charAt(idx) &&  dp[i][j-1]))
                    dp[i][j] = true;
                else
                    dp[i][j] = false;
            }
        }
        
        return dp[dp.length-1][dp[0].length-1];
    }
}
