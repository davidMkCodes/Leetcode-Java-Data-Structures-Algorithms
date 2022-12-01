//Leetcode #2
//https://leetcode.com/problems/add-two-numbers/
//Time Complexity: O(max(m,n))
//Space Complexity: O(1)
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null)
            return null;
        
        ListNode t1 = l1;
        ListNode t2 = l2;
        while(t1 != null && t2 != null){
            t1 = t1.next;
            t2 = t2.next;
        }
            
        if(t2 != null && t1 == null)
            return helper(l2, l1);
        
        
        return helper(l1, l2);
    }
    
    public ListNode helper(ListNode head, ListNode l2){
        ListNode l1 = head;
        
        int carry = 0;
        while(l1 != null & l2 != null){
            int sum = l1.val + l2.val + carry;
            
            l1.val = (sum % 10);
            
            if(sum >= 10) carry = 1;
            else carry = 0;
            
            if(l1.next == null && carry == 1){
                l1.next = new ListNode(1);
                l1 = l1.next;
            }
                
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while(l1 != null){
            int sum = l1.val + carry;
            
            l1.val = (sum % 10);
            
            if(sum >= 10) carry = 1;
            else carry = 0;
            
            if(l1.next == null && carry == 1){
                l1.next = new ListNode(1);
                l1 = l1.next;
            }
                
            l1 = l1.next;
        }
            
            
        return head;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
