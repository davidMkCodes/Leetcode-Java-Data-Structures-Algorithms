import java.util.Stack;

//Leetcode #150
//https://leetcode.com/problems/evaluate-reverse-polish-notation/
//Time Complexity: O(n)
//Space Complexity: O(n)
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < tokens.length; i++){
            String s = tokens[i];
            
            if(s.compareTo("+") == 0|| s.compareTo("-") == 0 || s.compareTo("*") == 0|| s.compareTo("/") == 0){
                int rightVal = stack.pop();
                int leftVal = stack.pop();
                char c = s.charAt(0);
                
                if(c == '+')
                    stack.push(leftVal+rightVal);
                else if(c == '-')
                    stack.push(leftVal-rightVal);
                else if(c == '*')
                    stack.push(leftVal*rightVal);
                else if(c == '/')
                    stack.push(leftVal/rightVal);
                
            }else 
                stack.push(Integer.valueOf(s));
            
        }
        
        
        return stack.pop();
    }
}
