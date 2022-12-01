import java.util.List;
import java.util.ArrayList;

//Leetcode #39
//https://leetcode.com/problems/combination-sum/
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> allLists = new ArrayList<>();
        helper(0, new ArrayList<>(), 0, candidates, target, allLists);
        
        System.out.println();
        return allLists;
    }
    
    private void helper(int sum, List<Integer> list, int cIdx, int[] candidates, int target, List<List<Integer>> allLists){
        
        for(int i = cIdx; i < candidates.length; i++){
            int n = candidates[i];
            
            if(sum + n == target){
                List<Integer> t = new ArrayList<>(list);
                t.add(n);
                
                allLists.add(t);
            }else if(sum + n < target){
                List<Integer> t = new ArrayList<>(list);
                t.add(n);
                
                helper(sum+n, t, i,candidates, target, allLists);
            } 
        }
    }
}
