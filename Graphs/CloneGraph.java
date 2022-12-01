import java.util.HashMap;
import java.util.Queue;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

//Leetcode #133
//https://leetcode.com/problems/clone-graph/
//Time Complexity: O(n+m)
//Space Complexity: O(n)
public class CloneGraph {
    public Node cloneGraph(Node node) {
        if(node == null)
            return node;
        
        HashMap<Integer, List<Node>> neighborsMap = new HashMap<>();
        Queue<Node> que = new LinkedList<>();
        
        que.add(node);
        neighborsMap.put(node.val, node.neighbors);
        
        while(!que.isEmpty()){
            Node curr = que.poll();
            if(!neighborsMap.containsKey(curr.val))
                neighborsMap.put(curr.val, curr.neighbors);
            
            for(int i = 0; i < curr.neighbors.size(); i++){
                Node tmp = curr.neighbors.get(i);
                
                if(!neighborsMap.containsKey(tmp.val))
                    que.add(tmp);
            }
        }
                  
        Node cloneHead = new Node(1);
        HashMap<Integer, Node> cloneNodesMap = new HashMap<>();
        cloneNodesMap.put(1, cloneHead);
        for(int i = 1; i < neighborsMap.size(); i++){
            Node cloneCurr = new Node(i+1);
            cloneNodesMap.put(i+1, cloneCurr);
        }
        
        for(int i = 0; i < cloneNodesMap.size(); i++){
            List<Node> adjList = neighborsMap.get(i+1);
            Node curr = cloneNodesMap.get(i+1);
            
            for(int j = 0; j < adjList.size(); j++){
                curr.neighbors.add(cloneNodesMap.get(adjList.get(j).val));
            }
            
        }
        
        return cloneHead;
    }
}

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}