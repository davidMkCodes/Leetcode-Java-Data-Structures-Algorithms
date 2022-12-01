import java.util.PriorityQueue;

//Leetcode #215
//https://leetcode.com/problems/kth-largest-element-in-an-array/
//Time Complexity: O(n)
//Space Complexity: O(k)
public class KthLargestInArray {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> que = new PriorityQueue<>();
        
        for(int n : nums){
            que.add(n);
            
            if(que.size() > k)
                que.poll();
        }
        
        return que.poll();
    }
}
