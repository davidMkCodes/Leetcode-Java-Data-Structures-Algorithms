import java.util.Queue;
import java.util.LinkedList;

//Leetcode #994
//https://leetcode.com/problems/rotting-oranges/
//Time Complexity: O(m*n)
//Space Complexity: O(m*n)
public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        
        Queue<int[]> que = new LinkedList<>();
        int numOranges = 0;
        int numRotten = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    que.add(new int[]{i,j});
                    numRotten++;
                    numOranges++;
                }
                else if(grid[i][j] == 1)
                    numOranges++;
            }
        }
        
        if(numRotten == 0 && numOranges > 0)
            return -1;
        else if(numOranges == 0)
            return 0;
        
        int time = 0;
        while(!que.isEmpty()){
            time++;
            int size = que.size();
            
            for(int i = 0; i < size; i++){
                int[] p = que.poll();
                int x = p[0];
                int y = p[1];
                
                if(x-1 >= 0 && grid[x-1][y] == 1){
                    que.add(new int[]{x-1,y});
                    grid[x-1][y] = 2;
                    numRotten++;
                }
                if(y-1 >= 0 && grid[x][y-1] == 1){
                    que.add(new int[]{x, y-1});
                    grid[x][y-1] = 2;
                    numRotten++;
                }
                if(x+1 < grid.length && grid[x+1][y] == 1){
                    que.add(new int[]{x+1,y});
                    grid[x+1][y] = 2;
                    numRotten++;
                }
                if(y+1 < grid[0].length && grid[x][y+1] == 1){
                    que.add(new int[]{x,y+1});
                    grid[x][y+1] = 2;
                    numRotten++;
                }
            }
        }
        
        if(numOranges == numRotten)
            return time-1;
        
        return -1;
    }
}
