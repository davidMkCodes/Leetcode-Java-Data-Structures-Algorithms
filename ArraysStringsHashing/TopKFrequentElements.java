import java.util.HashMap;
import java.util.PriorityQueue;

//Leetcode #347
//https://leetcode.com/problems/top-k-frequent-elements/
//Time Complexity: O(n)
//Space Complexity: O(n)
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> que = new PriorityQueue<>
            ((n1,n2) -> map.get(n2) - map.get(n1));
        
        for(int n : nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        
        for(int key : map.keySet()){
            que.add(key);
        }
        
        int[] topK = new int[k];
        for(int i = 0; i < topK.length; i++)
            topK[i] = que.poll();
        
        return topK;
    }
}
