//Leetcode #70
//https://leetcode.com/problems/climbing-stairs/
//Time Complexity: O(n)
//Space Complexity: O(1)
public class ClimbingStairs {
    public int climbStairs(int n) {
        if(n == 0 || n == 1 || n == 2)
            return n;
        
        int twoBehind = 1;
        int oneBehind = 2;
        
        for(int i = 3; i <= n; i++){
            int curr = oneBehind + twoBehind;
            
            twoBehind = oneBehind;
            oneBehind = curr;
        }
        
        return oneBehind;
    }
}
