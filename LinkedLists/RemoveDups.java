import java.util.HashSet;

//Cracking the Coding Interview Book
//Time Complexity: O(n)
//Space Complexity: O(n)
public class RemoveDups {
    public static Node removeDup(Node head){
        if(head == null)
            return null;

        HashSet<Integer> set = new HashSet<>();
        set.add(head.data);
        Node prev = head;
        Node curr = head.next;
        while(curr != null){
            if(set.contains(curr.data)){
                curr = curr.next;
                prev.next = curr;
            }
            else{
                set.add(curr.data);
                prev = curr;
                curr = curr.next;
            }
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
