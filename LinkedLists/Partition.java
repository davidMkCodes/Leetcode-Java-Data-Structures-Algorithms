//Cracking the Coding Interview Book
//Time Complexity: O(n)
//Space Complexity: O(1)
class Partition{
    public static Node partition(Node head, int p){
        if(head == null || head.next == null)
            return head;

        Node curr = head;
        while(curr.next != null){
            if(curr.next.data < p){
                Node tmp = curr.next;
                curr.next = tmp.next;
                tmp.next = head;
                head = tmp;
            }else{
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
