import java.util.HashSet;

//Cracking the Coding Interview Book
//Time Complexity: O(n + m)
//Space Complexity: O(n+m)
public class Intersection {
    public static boolean intersection(Node l1, Node l2){
        if(l1 == null || l2 == null)
            return false;

        HashSet<Node> set = new HashSet<>();
        
        while(l1 != null){
            set.add(l1);
            l1 = l1.next;
        }

        while(l2 != null){
            if(set.contains(l2))
                return true;

            l2 = l2.next;
        }
        
        return false;
    }
}
