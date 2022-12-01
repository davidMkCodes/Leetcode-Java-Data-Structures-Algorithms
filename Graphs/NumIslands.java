import java.util.Queue;
import java.util.LinkedList;

//Leetcode #200
//https://leetcode.com/problems/number-of-islands/
//Time Complexity: O(m*n)
//Space Complexity: O(m*n)
public class NumIslands {
    public int numIslands(char[][] grid) {
        
        int numIslands = 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    grid[i][j] = '0';
                    numIslands++;
                    
                    Queue<int[]> que = new LinkedList<>();
                    que.add(new int[]{i,j});
                    while(!que.isEmpty()){
                        int[] idx = que.poll();
                        int a = idx[0];
                        int b = idx[1];
                        
                        if(a+1 < grid.length && grid[a+1][b] == '1'){
                            grid[a+1][b] = '0';
                            que.add(new int[]{a+1,b});
                        }
                        
                        if(a-1 >= 0 && grid[a-1][b] == '1'){
                            grid[a-1][b] = '0';
                            que.add(new int[]{a-1,b});
                        }
                        
                        if(b+1 < grid[0].length && grid[a][b+1] == '1'){
                            grid[a][b+1] = '0';
                            que.add(new int[]{a, b+1});
                        }
                        
                        if(b-1 >= 0 && grid[a][b-1] == '1'){
                            grid[a][b-1] = '0';
                            que.add(new int[]{a, b-1});
                        }
                    }
                }
            }
        }
        
        return numIslands;
    }
}
