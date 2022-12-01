import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;

//Leetcode #127
//https://leetcode.com/problems/word-ladder/
//Time Complexity: O(n^2 * m)
//Space Complexity: O(n^2*m)
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord))
            return 0;
        
        HashMap<String, HashSet<String>> map = new HashMap<>();
        for(String word : wordList)
            if(!beginWord.equals(word) && validTransformation(beginWord, word)){
                if(!map.containsKey(beginWord))
                    map.put(beginWord, new HashSet<String>());
                map.get(beginWord).add(word);
            }
        
        if(map.isEmpty())
            return 0;
        
        for(String w1 : wordList){
            for(String w2 : wordList){
                if(w1.equals(w2) || (map.containsKey(w1) && map.get(w1).contains(w2))) 
                    continue;
                
                if(validTransformation(w1, w2)){
                    if(!map.containsKey(w1))
                        map.put(w1, new HashSet<String>());
                    if(!map.containsKey(w2))
                        map.put(w2, new HashSet<String>());
                    
                    map.get(w1).add(w2);
                    map.get(w2).add(w1);
                }
            }
        }
        
        
        Queue<String> que = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        que.add(beginWord);
        visited.add(beginWord);
        
        int level = 0;
        while(!que.isEmpty()){
            level++;
            int size = que.size();
            
            for(int i = 0; i < size; i++){
                String curr = que.poll();
                
                for(String w : map.get(curr)){
                    if(visited.contains(w))
                        continue;
                    if(w.equals(endWord))
                        return level+1;
                    
                    que.add(w);
                    visited.add(w);
                }
            }
        }
        
        
        return 0;
    }
    
    private boolean validTransformation(String word1, String word2){
        boolean swapUsed = false;
        for(int i = 0; i < word1.length(); i++){
            if(word1.charAt(i) == word2.charAt(i))
                continue;
            
            if(!swapUsed)
                swapUsed = true;
            else 
                return false;
        }
        
        return true;
    }
}
