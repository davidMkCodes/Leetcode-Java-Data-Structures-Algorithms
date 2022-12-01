import java.util.Stack;

//Leetcode #739
//https://leetcode.com/problems/daily-temperatures/
//Time Complexity: O(n)
//Space Complexity: O(n)
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures.length == 1)
            return new int[1];
        
        int[] output = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();
        
        for(int i = 0; i < temperatures.length-1; i++){
            int currTemp = temperatures[i];
            int nextTemp = temperatures[i+1];
            
            int[] t = new int[2];
            if(currTemp < nextTemp){
                output[i] = 1;
                
                while(!stack.isEmpty() && stack.peek()[1] < nextTemp){
                    t = stack.pop();
                    output[t[0]] = i+1 - t[0];
                }
            }
            else{
                t[0] = i;
                t[1] = currTemp;
                stack.add(t);
            }
            
            
        }
        
        return output;
    }
}
