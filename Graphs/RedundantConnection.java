
//Leetcode #684
//https://leetcode.com/problems/redundant-connection/
//Time Complexity: O(n^2)
//Space COmplexity: O(n^2)
public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int[] unions = new int[1001];
        
        for(int i = 0; i < unions.length; i++)
            unions[i] = i;
        
        for(int[] edge : edges){
            int n1 = edge[0];
            int n2 = edge[1];
            
            if(getParent(n1, unions) == getParent(n2, unions))
                return edge;
            
            unions[getParent(n2, unions)] = getParent(n1, unions);
        }
        
        return new int[2];
    }
    
    private int getParent(int n, int[] unions){
        if(unions[n] != n)
            return getParent(unions[n], unions);
        
        return unions[n];
    }
}
