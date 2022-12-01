import java.util.HashSet;
import java.util.HashMap;

//Leetcode #323
//https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
//Time Complexity: O(V+E)
//Space Complexity: O(V+E)
public class countComponents {
    public int countComponents(int n, int[][] edges) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        
        for(int[] edge : edges){
            int n1 = edge[0];
            int n2 = edge[1];
            
            if(!map.containsKey(n1))
                map.put(n1, new HashSet<>());
            if(!map.containsKey(n2))
                map.put(n2, new HashSet<>());
            
            map.get(n1).add(n2);
            map.get(n2).add(n1);
        }
        
        HashSet<Integer> visited = new HashSet<>();
        int componentCount = 0;
        for(int i = 0; i < n; i++){
            if(visited.contains(i))
                continue;
            
            componentCount++;
            dfs(i, visited, map);
        }
        
        return componentCount;
    }
    
    private void dfs(int n, HashSet<Integer> visited, HashMap<Integer, HashSet<Integer>> map){
       
        
        visited.add(n);
        if(!map.containsKey(n))
            return;
        HashSet<Integer> set = map.get(n);
        for(int i : set){
            if(visited.contains(i))
                continue;
            
            visited.add(i);
            dfs(i, visited, map);
        }
    }
}
