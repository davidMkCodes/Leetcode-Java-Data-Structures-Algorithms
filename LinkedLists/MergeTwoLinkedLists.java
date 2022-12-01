//Leetcode #21
//https://leetcode.com/problems/merge-two-sorted-lists/
//Time Complexity: O(n+m)
//Space Complexity: O(1)
public class MergeTwoLinkedLists {
    public Node mergeTwoLists(Node l1, Node l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        if(l1.data <= l2.data)
            return merge(l1, l2);
        else
            return merge(l2, l1);
    }
    
    public Node merge(Node l1, Node l2){
        Node head = l1;
        Node prev = l1;
        l1 = l1.next;
        
        while(l1 != null && l2 != null){
            if(l1.data <= l2.data){
                prev = l1;
                l1 = l1.next;
            }else{
                Node t = l2.next;
                l2.next = l1;
                prev.next = l2;
                prev = l2;
                l2 = t;
            }
        }
        
        while(l2 != null){
            Node t = l2.next;
            l2.next = l1;
            prev.next = l2;
            prev = l2;
            l2 = t;
        }
        
        return head;
    }
}

class Node {
    Node next = null;
    int data;

    public Node(int d){
        this.data = d;
    }

    void appendToTail(int d){
        Node end = new Node(d);
        Node n = this;
        while(n.next != null){
            n = n.next;
        }
        n.next = end;
    }
}

