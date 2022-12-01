import java.util.HashMap;
import java.util.HashSet;

//Leetcode #207
//https://leetcode.com/problems/course-schedule/
//Time Complexity: O(nodes+edges)
//Space Complexity: O(nodes+edges)
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for(int i = 0; i < prerequisites.length; i++){
            int course = prerequisites[i][1];
            int prereq = prerequisites[i][0];
        
            if(!map.containsKey(course)) map.put(course, new HashSet<Integer>());
            
            map.get(course).add(prereq);
        }
        
        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> cleared = new HashSet<>();
        for(int i = 0; i < numCourses; i++){
            if(visited.contains(i))
                continue;
            
            if(!isCleared(i, visited, cleared, map))
                return false;
        }
        
        return true;
    }
    
    private boolean isCleared(int course,HashSet<Integer> visited, HashSet<Integer> cleared, HashMap<Integer, HashSet<Integer>> map){
        if(cleared.contains(course)) return true;
        
        if(!map.containsKey(course)){
            cleared.add(course);
            visited.add(course);
            
            return true;
        }
        
        if(visited.contains(course))
            return false;
        
        visited.add(course);
        
        for(int req : map.get(course)){
            if(!isCleared(req, visited, cleared, map))
                return false;
        }
        
        cleared.add(course);
        
        return true;
    }
}
