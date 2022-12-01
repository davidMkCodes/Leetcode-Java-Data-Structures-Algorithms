//Leetcode #875
//https://leetcode.com/problems/search-a-2d-matrix/
//Time Complexity: O(nlogn)
//Space Complexity: O(1)
public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        
        
        int minEatingSpeed = Integer.MIN_VALUE;
        int minIdx = -1;
        int l = 1;
        int r = 1;
        for(int p : piles)
            r = Math.max(r, p);
        
        
        while(l <= r){
            int m = l + (r-l)/2;
            
            int eatingSpeed = 0;
            for(int i = 0; i < piles.length; i++){
                double rate = (double) piles[i]/m;
            
                eatingSpeed += Math.ceil(rate);
            }
            
            if(Math.abs(eatingSpeed-h) <= Math.abs(minEatingSpeed-h) && eatingSpeed <= h){
                minEatingSpeed = eatingSpeed;
                minIdx = m;
            }
                
            
            if(eatingSpeed <= h)
                r = m-1;
            else 
                l = m+1;
        }
        
        return minIdx;
    }
}
