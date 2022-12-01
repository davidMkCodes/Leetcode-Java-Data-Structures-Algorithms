import java.util.PriorityQueue;

//Leetcode #1046
//https://leetcode.com/problems/last-stone-weight/
//Time Complexity: O(n)
//Space Complexity: O(n)
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1)
            return stones[0];
        
        PriorityQueue<Integer> que = new PriorityQueue<>((a,b) -> b-a);
        
        for(int n : stones)
            que.add(n);
            
        while(que.size() >= 2){
            int x = que.poll();
            int y = que.poll();
            
            if(x != y)
                que.add(Math.abs(x-y));
        }
        
        if(!que.isEmpty())
            return que.poll();
        
        return 0;
    }
}
