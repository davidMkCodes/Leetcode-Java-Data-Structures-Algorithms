import java.util.PriorityQueue;;

//Leetcode #973
//https://leetcode.com/problems/k-closest-points-to-origin/
//Time Complexity: O(n)
//Space Complexity: O(k)
public class KthClosest {
    public int[][] kClosest(int[][] points, int k) {        
        PriorityQueue<int[]> que = new PriorityQueue<int[]>(
            (a,b) -> (Math.sqrt(a[0]*a[0] + a[1]*a[1])) <= 
            (Math.sqrt(b[0]*b[0] + b[1]*b[1])) ? 1 : -1);
        
        for(int[] p : points){
            que.add(p);
            
            if(que.size() > k)
                que.poll();
        }
        
        int[][] sol = new int[k][2];
        for(int i = 0; i < sol.length; i++){
            if(!que.isEmpty()){
                int[] p = que.poll();
                sol[i][0] = p[0];
                sol[i][1] = p[1];
            }
        }
        
        return sol;
    }
}
