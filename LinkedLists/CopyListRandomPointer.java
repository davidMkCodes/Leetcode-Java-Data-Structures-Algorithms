import java.util.HashMap;

//Leetcode #138
//https://leetcode.com/problems/copy-list-with-random-pointer/
//Time Complexity: O(n)
//Space Complexity: O(n)
public class CopyListRandomPointer {
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        
        HashMap<Node, Node> map = new HashMap<>();
        
        Node copyHead = new Node(head.val);
        Node copyCurr = copyHead;
        Node curr = head;
        map.put(curr, copyCurr);
        while(curr.next != null){
            
            
            copyCurr.next = new Node(curr.next.val);
            copyCurr = copyCurr.next;
            curr = curr.next;
            map.put(curr, copyCurr);
        }
        
        curr = head;
        copyCurr = copyHead;
        while(curr != null){
            if(curr.random != null)
                copyCurr.random = map.get(curr.random);
            
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        
        return copyHead;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
