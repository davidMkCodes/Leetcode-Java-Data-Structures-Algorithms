//Leetcode #50
//https://leetcode.com/problems/powx-n/
//Time Complexity: O(n)
//Space Complexity: O(n)
public class Pow {
    public double myPow(double x, int n) {
        if(n == 0)
            return 1;
        
        return getPow(x, n);
    }
    
    private double getPow(double x, int n){
        if(n == 1)
            return x;
        else if(n == -1)
            return 1/x;
        
        int count = 0;
        if(n < 0){
            x = 1/x;
            count = -(n/2);
        }
        else count = n/2;
        
        double pow = getPow(x, count);
        pow *= pow;
        
        if(n % 2 != 0)
            pow *= x;
        
        return pow;
    }
}
