import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

//Leetcode #271
//https://leetcode.com/problems/encode-and-decode-strings/
public class EncodeDecodeStrings {
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public String encode(List<String> strs) {
        if (strs.size() == 0) return Character.toString((char)258);
    
        String d = Character.toString((char)257);
        StringBuilder sb = new StringBuilder();
        for(String s: strs) {
          sb.append(s);
          sb.append(d);
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
      }
    
    //Time Complexity: O(n)
    //Space Complexity: O(n)
      public List<String> decode(String s) {
        String d = Character.toString((char)258);
          
        if (s.equals(d)) 
            return new ArrayList();
    
        d = Character.toString((char)257);
        return Arrays.asList(s.split(d, -1));
      }
}
