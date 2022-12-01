import java.util.HashMap;

//Leetcode #146
//https://leetcode.com/problems/lru-cache/
//Time Complexity: O(1)
//Space Complexity: O(capacity)
public class LRUCache {
    HashMap<Integer, DNode> map;
    DNode head;
    DNode tail;
    int maxSize;
    
    public LRUCache(int capacity) {
        map = new HashMap<Integer, DNode>();
        this.head = null;
        this.tail = null;
        this.maxSize = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        
        DNode getNode = map.get(key);
        
        if(tail != getNode){
            if(head == getNode){
                head = head.next;
                head.prev = null;
                getNode.next = null;
                
                tail.next = getNode;
                getNode.prev = tail;
                tail = getNode;
            }else{
                getNode.prev.next = getNode.next;
                getNode.next.prev = getNode.prev;
                
                getNode.next = null;
                getNode.prev = tail;
                tail.next = getNode;
                tail = getNode;    
            }
        }
        
        return getNode.value; 
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            DNode rNode = map.get(key);
            
            if(rNode == head && rNode == tail){
                head = null;
                tail = null;
            }
            else if(rNode == head){
                head = head.next;
                head.prev = null;
                rNode.next = null;
            }
            else if(rNode == tail){
                tail = tail.prev;
                tail.next = null;
                rNode.prev = null;
            }else{
                rNode.prev.next = rNode.next;
                rNode.next.prev = rNode.prev;
                rNode.next = null;
                rNode.prev = null;
            }
            map.remove(rNode.key);
        }
        
        DNode newNode = new DNode(key, value);
        
        if(map.size() == 0){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        
        map.put(key, newNode);
        
        if(map.size() > maxSize){
            DNode LRU = head;
            head = head.next;
            
            if(head != null)
                head.prev = null;
                
            LRU.next = null;
            
            map.remove(LRU.key);
        }
    }
    
    class DNode{
        int value;
        int key;
        DNode prev = null;
        DNode next = null;
        
        
        public DNode(int k, int v){
            this.key = k;
            this.value = v;
        }
    }
}
