//Cracking the Coding Interview Book
//Time Complexity: O(n)
//Space Complexity: O(1)
public class KthToLast {
    public static Node kthToLast(Node head, int k){
        if(head == null || k < 1)
            return null;

        Node slow = head;
        Node fast = head;
        while(k != 0){
            fast  = fast.next;
            k--;

            if(fast == null && k > 0)
                return null;
        }

        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }
}
