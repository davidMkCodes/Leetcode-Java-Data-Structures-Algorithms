import java.util.HashMap;
import java.util.PriorityQueue;
//Leetcode #621
//https://leetcode.com/problems/task-scheduler/
//Time Complexity: O(n)
//Space Complexity: O(n)
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        if(n == 0) return tasks.length;
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(char c: tasks) map.put(c, map.getOrDefault(c, 0) + 1);
        
        PriorityQueue<Character> que = new PriorityQueue<Character>(
            (a,b) -> map.get(b) - map.get(a));
                    
        for(char key : map.keySet())
            que.add(key);
        
        HashMap<Integer, Character> mapIdx = new HashMap<>();
        int i = 0;
        while(map.size() != 0){
            
            if(que.size() > 0){
                char c = que.poll();
                map.put(c, map.get(c)-1);
                
                if(map.get(c) == 0)
                    map.remove(c);
                else mapIdx.put(i+n, c);
            }
            
            if(mapIdx.containsKey(i)){
                char c = mapIdx.get(i);
                

                if(map.containsKey(c))
                    que.add(c);
            }
            
            i++;
        }
                    
        return i;
    }
}
