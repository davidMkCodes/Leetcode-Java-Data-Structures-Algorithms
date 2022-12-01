//Cracking the Coding Interview Book
//Time Complexity: O(n+m)
//Space Complexity: O(1)
public class SumLists {
    public static Node nodeReversed(Node l1, Node l2){
        if(l1 == null && l2 == null) 
            return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        Node n1 = l1;
        Node n2 = l2;
        int carry = 0;
        while(n1 != null && n2 != null){
            int sum = n1.data + n2.data + carry;
            carry = 0;
            n1.data = sum % 10;
            n2.data = sum % 10;
            if(sum >= 10)
                carry++;

            if(n1.next == null && n2.next == null && carry > 0){
                n1.next = new Node(carry);
                return l1;
            }
            n1 = n1.next;
            n2 = n2.next;
        }

        boolean l1Longer = false;
        boolean l2Longer = false;
        while(n1 != null){
            l1Longer = true;
            int sum = n1.data + carry;
            carry = 0;
            n1.data = sum % 10;
            if(sum >= 10)
                carry++;

            if(n1.next == null && carry > 0){
                n1.next = new Node(carry);
                break;
            }

            n1 = n1.next;
        }

        while(n2 != null){
            l2Longer = true;
            int sum = n2.data + carry;
            carry = 0;
            n2.data = sum % 10;
            if(sum >= 10)
                carry++;

            if(n2.next == null && carry > 0){
                n2.next = new Node(carry);
                break;
            }

            n2 = n2.next;
        }

        if(l1Longer)return l1;
        if(l2Longer) return l2;

        return l1;
    }


    public static Node NodeInOrder(Node l1, Node l2){
        if(l1 == null && l2 == null)
            return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        int s1 = 0;
        Node n1 = l1;
        while(n1 != null){
            n1 = n1.next;
            s1++;
        }
        
        int s2 = 0;
        Node n2 = l2;
        while(n2 != null){
            n2 = n2.next;
            s2++;
        }

        int diff = Math.abs(s1 - s2);
        n1 = l1;
        n2 = l2;
        if(s1 > s2){
            while(diff != 0){
                if(diff == 1 && n1.next.data + n2.next.data >= 10)
                    n1.data++;
                n1 = n1.next;
                diff--;
            }
        }else if(s2 > s1){
            while(diff != 0){
                if(diff == 1 && n1.next.data + n2.next.data >= 10)
                    n2.data++;
                n2 = n2.next;
                diff--;
            }
        }else{
            if(n1.data + n2.data >= 10){
                Node tmp = new Node(1);
                tmp.next = l1;
                l1 = tmp;
            }
        }
        int sum = n1.data + n2.data;
        n1.data = sum % 10;
        n2.data = sum % 10;

        while(n1.next != null && n2.next != null){
            sum = n1.next.data + n2.next.data;
            n1.next.data = sum % 10;
            n2.next.data = sum % 10;
            if(sum >= 10){
                n1.data++;
                n2.data++;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        

        return s1>=s2 ? l1 : l2;
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
