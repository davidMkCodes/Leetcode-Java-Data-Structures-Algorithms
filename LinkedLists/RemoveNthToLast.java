//Leetcode #19
//https://leetcode.com/problems/remove-nth-node-from-end-of-list/
//Time Complexity: O(n)
//Space Complexity: O(1)
public class RemoveNthToLast {
    public Node removeNthFromEnd(Node head, int n) {
        
        Node slow = head;
        Node fast = head;
        
        while(n > 0 && fast != null){
            fast = fast.next;
            n--;
        }
        
        if(fast == null) return head.next;
        
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        
        slow.next = slow.next.next;
        
        return head;
    }
}
