//Leetcode #43
//https://leetcode.com/problems/multiply-strings/
//Time Complexity: O(n^2 + m*n)
//Space Cmplexity: O(n^2 + m*n)
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if(num1.charAt(0) == '0' || num2.charAt(0) == '0')
            return "0";
        
        if(num1.length() >= num2.length())
            return helper(num1, num2, num2.length()-1);
        else
            return helper(num2, num1, num1.length()-1);
    }
    
    private String helper(String num1, String num2, int j){
        int i = num1.length()-1;
        String product = "";
        
        int numZeros = (num2.length()-1)-j;
        for(i = numZeros; i > 0; i--)
            product = "0" + product;
            
        int currNum = Character.getNumericValue(num2.charAt(j));
        int carry = 0;
        for(i = num1.length()-1; i >= 0; i--){
            int n = (Character.getNumericValue(num1.charAt(i))*currNum) + carry;
            
            carry = 0;
            if(n >= 10) carry = n/10;
            n = n % 10;
            
            product = n + product;
        }
        
        if(carry > 0)
            product = carry + product;
        
        if(j-1 >= 0){
            String t = helper(num1, num2, j-1);
            
            if(product.length() >= t.length())
                product = addStrings(product, t);
            else
                product = addStrings(t, product);
            
        }
        
        return product;
    }
    
    private String addStrings(String num1, String num2){
        int i = num1.length()-1;
        int j = num2.length()-1;
        
        String sum = "";
        boolean carry = false;
        while(i >= 0 && j >= 0){
            int n = Character.getNumericValue(num1.charAt(i))
                + Character.getNumericValue(num2.charAt(j));
            
            if(carry){
                n++;
                carry = false;
            }
            
            if(n >= 10) carry = true;
            n = n % 10;
            sum = n + sum;
            
            i--;
            j--;
        }
        
        while(i >= 0){
            int n = Character.getNumericValue(num1.charAt(i));
            
            if(carry){
                n++;
                carry = false;
            }
            
            if(n >= 10) carry = true;
            n = n % 10;
            sum = n + sum;
            
            i--;
        }
        
        if(carry)
            sum = "1" + sum;
        
        return sum;
    }
}
