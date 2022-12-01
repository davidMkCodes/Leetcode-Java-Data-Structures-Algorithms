import java.util.HashSet;

//Cracking the Coding Interview Book
//Time Complexity: O(n)
//Space Complexity: O(n)
public class LoopDetection {
    public static Node loopDetection(Node head){
        if(head == null)
            return null;

        HashSet<Node> set = new HashSet<>();
        Node curr = head;
        while(curr != null){
            if(set.contains(curr))
                return curr;

            set.add(curr);
            curr = curr.next;
        }

        return null;
    }
}
