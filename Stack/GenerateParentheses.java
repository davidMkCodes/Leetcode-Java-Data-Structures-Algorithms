import java.util.List;
import java.util.ArrayList;

//Leetcode #22
//https://leetcode.com/problems/generate-parentheses/
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        str.append('(');
        getCombinations(list, str, 1, 0, n);
        
        return list;
    }
    
    public void getCombinations(List<String> list, StringBuilder str, int open, int close, int max){
        if(open+close == max*2){
            list.add(str.toString());
            return;
        }
        
        if(open < max){
            str.append('(');
            getCombinations(list, str, open+1, close, max);
            str.deleteCharAt(str.length()-1);
        }
        
        if(close < open){
            str.append(')');
            getCombinations(list, str, open, close+1, max);
            str.deleteCharAt(str.length()-1);
        }
        
        
        
    }
}
