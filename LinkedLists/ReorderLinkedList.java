//Leetcode #143
//https://leetcode.com/problems/reorder-list/
//Time Complexity: O(n)
//Space Complexity: O(1)
public class ReorderLinkedList {
    public void reorderList(Node head) {
        if(head == null)
            return;
        
        Node slow = head;
        Node fast = head;
        
        while(slow.next != null && (fast.next != null && fast.next.next != null)){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        Node lastOfFirst = slow;
        slow = slow.next;
        lastOfFirst.next = null;
        
        Node prev = null;
        
        while(slow != null){
            Node t = slow.next;
            slow.next = prev;
            
            prev = slow;
            slow = t;
        }
        
        Node first = head;
        Node second = prev;
        while(first != null && second != null){
            Node t = second.next;
            second.next = first.next;
            first.next = second;
            
            second = t;
            first = first.next.next;
            
        }
    }
}
