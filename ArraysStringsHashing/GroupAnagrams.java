import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

//Leetcode #49
//https://leetcode.com/problems/group-anagrams/
//Time Complexity: O(n^2)
//Space Complexity: O(n^2)
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> list = new ArrayList<>();
        List<HashMap<Character, Integer>> listOfMaps = new ArrayList<>();
        for(int i = 0; i < strs.length; i++){
            String s = strs[i];
            HashMap<Character, Integer> tempMap = new HashMap<>();
            
            for(Character c : s.toCharArray())
                tempMap.put(c, tempMap.getOrDefault(c, 0) + 1);
            
            if(listOfMaps.isEmpty()){
                listOfMaps.add(tempMap);
                list.add(new ArrayList<>());
                list.get(0).add(s);
                continue;
            }
            
            boolean mapFound = false;
            for(int j = 0; j < listOfMaps.size(); j++){
                if(tempMap.equals(listOfMaps.get(j))){
                    mapFound = true;
                    list.get(j).add(s);
                }
            }
            
            if(!mapFound){
                listOfMaps.add(tempMap);
                list.add(new ArrayList<>());
                list.get(list.size()-1).add(s);
            }
        }
        
        return list;
    }
}
