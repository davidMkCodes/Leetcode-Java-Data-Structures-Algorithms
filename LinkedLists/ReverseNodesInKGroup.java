//Leetcode #25
// https://leetcode.com/problems/reverse-nodes-in-k-group/
//Time Complexity: O(n)
//Space Complexity: O(1)
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){
            int count = k;
            
            ListNode start = curr;
            
            while(count-1 > 0){
                curr = curr.next;
                count--;
                
                if(curr == null)
                    break;
            }
            
            if(curr == null)
                break;
            
            ListNode end = curr;
            ListNode afterEnd = end.next;
            
            reverseList(start, end);
            
            if(prev == null)
                head = end;
            
            start.next = afterEnd;
           
            if(prev != null)
                prev.next = end;
            prev = start;
            curr = afterEnd;
        }
        
        return head;
    }
    
    public void reverseList(ListNode start, ListNode end){
        
        ListNode prev = null;
        ListNode curr = start;
        
        while(curr != end){
            ListNode t = curr.next;
            curr.next = prev;
            prev = curr;
            curr = t;
        }
        
        curr.next = prev;
        
        
    }
}