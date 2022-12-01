import java.util.HashSet;

//Cracking the Coding Interview Book
//Time Complexity: O(m*n)
//Space Complexity: O(n)
public class StringRotation {
    public static boolean isSubstring(String str1, String str2){
        if(str1.length() != str2.length())
            return false;

        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < str2.length(); i++){
            if(str2.charAt(i) == str1.charAt(0))
                set.add(i);
        }

        for(Integer j : set){
            for(int i = 0; i < str1.length(); i++){
                if(str1.charAt(i) != str2.charAt(j)){
                    break;
                }

                if(i+1 == str1.length())
                    return true;

                j++;
                if(j == str2.length())
                    j = 0;


            }
        }

        return false;
    }
}
