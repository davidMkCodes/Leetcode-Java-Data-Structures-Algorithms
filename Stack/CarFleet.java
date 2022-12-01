import java.util.Stack;
import java.util.Arrays;

//Leetcode #853
//https://leetcode.com/problems/car-fleet/
//Time Complexity: O(nlogn) - nlogn because of sorting
//Space Complexity: O(n)
public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {        
        int[][] pairs = new int[position.length][2];
        for(int i = 0; i < pairs.length; i++)
            pairs[i] = new int[]{position[i], speed[i]};
        
        Arrays.sort(pairs, (a,b) -> a[0] - b[0]);
        
        Stack<Double> stack = new Stack<>();
        int fleetCount = 0;
        for(int i = pairs.length-1; i >= 0; i--){
            double currTime = (double) (target-pairs[i][0])/pairs[i][1]; 
            
            if(stack.isEmpty()){
                fleetCount++;
                stack.push(currTime);
            }
            else{
                if(currTime <= stack.peek()){
                    continue;
                }else{
                    fleetCount++;
                    stack = new Stack<>();
                    stack.push(currTime);
                }
            }
        }
        
        return fleetCount;
    }
}
