import java.util.HashMap;

//Leetcode #981
//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
//Time Complexity: O(n^2)
//Space Complexity: O(n^2)
public class TimeMap {
    HashMap<String, HashMap<Integer, String>> map;
    public TimeMap() {
        map = new HashMap<String, HashMap<Integer, String>>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key))
            map.put(key, new HashMap<Integer, String>());
        
        
        map.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
       if(!map.containsKey(key))
           return "";
        
        if(map.get(key).containsKey(timestamp))
            return map.get(key).get(timestamp);
        
        for(int i = timestamp; i >= 0; i--){
            if(map.get(key).containsKey(i))
                return map.get(key).get(i);
        }
            
        
        return "";
    }
}
