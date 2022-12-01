//Leetcode #206 - ITERATIVE
//https://leetcode.com/problems/reverse-linked-list/
//Time Complexity: O(n)
//Space Complexity: O(1)
public class ReverseLinkedList {
    public Node reverseList(Node head) {
        if(head == null || head.next == null)
            return head;
        
        Node prev = null;
        Node curr = head;
        while(curr != null){
            
            Node tmp = curr.next;
            curr.next = prev;
            
            prev = curr;
            curr = tmp;
        }
        
        return prev;
    }
}
