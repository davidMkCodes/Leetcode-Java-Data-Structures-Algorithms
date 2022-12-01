//Leetcode #141
//https://leetcode.com/problems/linked-list-cycle/
//Time Complexity: O(n)
//Space Compelexity: O(1)
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null)
            return false;
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(slow != null && fast != null && fast.next != null){
            if(slow == fast)
                return true;
            
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return false;
    }
}
