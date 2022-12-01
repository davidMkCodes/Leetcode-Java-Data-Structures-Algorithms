//Cracking the Coding Interview Book
//Time Complexity: O(n)
//Space Complexity: O(1)
public class DeleteMiddleNode {
    public static Node deleteMiddleNode(Node head, Node dNode){
        if(head == null || (head.next == null && head == dNode) || dNode == null)
            return null;

        Node curr = head;
        while(curr.next != null){
            if(curr.next == dNode){
                curr.next = curr.next.next;
                return head;
            }
            curr = curr.next;
        }

        return head;
    }
}
