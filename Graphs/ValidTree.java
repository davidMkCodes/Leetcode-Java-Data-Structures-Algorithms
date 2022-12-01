import java.util.HashSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

//Leetcode #261
//https://leetcode.com/problems/graph-valid-tree/
//Time Complexity: O(n)
//Space Complexity: O(n)
public class ValidTree {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1) 
            return false;
         
         HashSet<Integer> visited = new HashSet<Integer>();
         HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
         Queue<Integer> que = new LinkedList<>();
         
         for(int i = 0; i < edges.length; i++){
             int n1 = edges[i][0];
             int n2 = edges[i][1];
             
             if(!map.containsKey(n1)) map.put(n1, new HashSet<Integer>());
             if(!map.containsKey(n2)) map.put(n2, new HashSet<Integer>());
 
             map.get(n1).add(n2);
             map.get(n2).add(n1);
         }
         
         que.add(0);
         visited.add(0);
         while(!que.isEmpty()){
             int curr = que.poll();
             
             if(!map.containsKey(curr))
                 continue;
             
             for(int i : map.get(curr)){
                 if(!visited.contains(i)){
                     visited.add(i);
                     que.add(i);
                 }
             }
         }
         
         return visited.size() == n;
     }
}
