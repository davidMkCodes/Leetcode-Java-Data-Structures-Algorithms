//Leetcode #66
//https://leetcode.com/problems/plus-one/
//Time Complexity: O(n)
//Space Complexity: O(n)
public class PlusOne {
    public int[] plusOne(int[] digits) {
        
        int i = digits.length-1;
        while(digits[i] == 9){
            digits[i] = 0;
            
            i--;
            
            if(i < 0){
                int[] tmp = new int[digits.length+1];
            
                for(int j = 0; j < digits.length; j++)
                    tmp[j+1] = digits[j];
            
                digits = tmp;
                i++;
            }
        }
        
        digits[i]++;
        
        return digits;
    }
}
