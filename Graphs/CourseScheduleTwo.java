import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

//Leetcode #210
//https://leetcode.com/problems/course-schedule-ii/
//Time Complexity: O(v+e)
//Space COmplexity: O(v+e)
public class CourseScheduleTwo {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for(int i = 0; i < prerequisites.length; i++){
            int course = prerequisites[i][0];
            int req = prerequisites[i][1];
            
            if(!map.containsKey(course))
                map.put(course, new HashSet<Integer>());
            
            map.get(course).add(req);
        }
        List<Integer> order = new ArrayList<>();
        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> cleared = new HashSet<>();
        for(int i = 0; i < numCourses; i++){
            if(visited.contains(i))
                continue;
            
            if(!isCleared(i, visited, cleared, order, map))
                return new int[0];
        }
        
        int[] sol = new int[numCourses];
        for(int i = 0; i < order.size(); i++)
            sol[i] = order.get(i);
        
        return sol;
    
    }   
    
    private boolean isCleared(int course, HashSet<Integer> visited, HashSet<Integer> cleared, List<Integer> order, HashMap<Integer, HashSet<Integer>> map){
        if(cleared.contains(course))
            return true;
        
        if(!map.containsKey(course)){
            order.add(course);
            cleared.add(course);
            visited.add(course);
            return true;
        }
            
        if(visited.contains(course))
            return false;
        
        visited.add(course);
        
        for(int req : map.get(course)){
            if(!isCleared(req, visited, cleared, order, map))
                return false;
        }
        
        cleared.add(course);
        order.add(course);
        
        return true;
    }
}
