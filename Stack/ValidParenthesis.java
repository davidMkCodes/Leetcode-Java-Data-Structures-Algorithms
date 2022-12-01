import java.util.Stack;

//Leetcode #20
//https://leetcode.com/problems/valid-parentheses/
//Time Complexity: O(n)
//Space Complexity: O(n)
public class ValidParenthesis {
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if(c == '(' || c == '{' || c == '['){
                stack.add(c);
                continue;
            }
            
            if((c == ')' && (stack.isEmpty() || stack.peek() != '('))
              || (c == '}' && (stack.isEmpty() || stack.peek() != '{'))
              || (c == ']' && (stack.isEmpty() || stack.peek() != '[')))
                return false;
            else 
                stack.pop();
        }
        
        return stack.isEmpty();
    }
}
