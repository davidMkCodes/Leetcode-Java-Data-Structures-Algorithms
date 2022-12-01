import java.util.PriorityQueue;

//Leetcode #703
//https://leetcode.com/problems/kth-largest-element-in-a-stream/
//Time Complexity: O(nlogn)
//Space Complexity: O(n)
public class KthLargest {
    PriorityQueue<Integer> que;
    int size;
    
    public KthLargest(int k, int[] nums) {
        this.que = new PriorityQueue<Integer>((a,b) -> a-b);
        this.size = k;
        
        for(int i = 0; i < nums.length; i++){
            que.add(nums[i]);
            
            if(que.size() > size)
                que.poll();
        }
    }
    
    public int add(int val) {
        que.add(val);
        
        if(que.size() > size)
            que.poll();
        
        return que.peek();
    }
}
