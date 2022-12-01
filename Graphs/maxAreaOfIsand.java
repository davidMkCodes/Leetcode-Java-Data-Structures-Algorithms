import java.util.LinkedList;
import java.util.Queue;

//Leetcode #695
//https://leetcode.com/problems/max-area-of-island/
//Time Complexity: O(m*n)
//Space Complexity: O(m*n)
public class maxAreaOfIsand {
    public int maxAreaOfIsland(int[][] grid) {
        
        int maxArea = 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    int currArea = 0;
                    
                    Queue<int[]> que = new LinkedList<>();
                    que.add(new int[]{i,j});
                    grid[i][j] = 0;
                    
                    while(!que.isEmpty()){
                        int[] idx = que.poll();
                        int x = idx[0];
                        int y = idx[1];
                        
                        currArea++;
                        
                        if(x-1 >= 0 && grid[x-1][y] == 1){
                            que.add(new int[]{x-1,y});
                            grid[x-1][y] = 0;
                        } 
                        if(x+1 < grid.length && grid[x+1][y] == 1) {
                            que.add(new int[]{x+1,y});
                            grid[x+1][y] = 0;
                        }
                        if(y-1 >= 0 && grid[x][y-1] == 1){
                            que.add(new int[]{x, y-1});
                            grid[x][y-1] = 0;
                        }
                        if(y+1 < grid[0].length && grid[x][y+1] == 1){
                            que.add(new int[]{x,y+1});
                            grid[x][y+1] = 0;
                        }
                    }
                    
                    maxArea = Math.max(maxArea, currArea);
                }
            }
        }
        
        
        
        return maxArea;
    }
}
