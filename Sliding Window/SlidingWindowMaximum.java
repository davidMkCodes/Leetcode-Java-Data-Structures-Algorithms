import java.util.LinkedList;
import java.util.Deque;

//Leetcode #239
//https://leetcode.com/problems/sliding-window-maximum/
//Time Complexity: O(n)
//Space Complexity: O(n)
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int[]output = new int[nums.length-k+1];
        Deque<Integer> deque = new LinkedList<>();
        
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            int range = i-k+1;
            while(!deque.isEmpty() && deque.peekFirst() < range)
                deque.pollFirst();
            
            while(!deque.isEmpty() && nums[i] > nums[deque.peekLast()])
                deque.pollLast();
            
            deque.offer(i);
            
            if(i >= k-1){
                output[j] = nums[deque.peekFirst()];
                j++;
            }
        }
        
        return output;
    }
}
