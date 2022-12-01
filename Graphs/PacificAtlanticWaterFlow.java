
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//Leetcode #417
//https://leetcode.com/problems/pacific-atlantic-water-flow/
//Time Complexity: O(m*n)
//Space Complexity: O(m*n)
public class PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        
        
        int[][] pacific = new int[heights.length][heights[0].length];
        for(int i = 0; i < heights.length; i++)
            checkPacific(i, 0, pacific, heights);
        for(int j = 0; j < heights[0].length; j++)
            checkPacific(0, j, pacific, heights);
        
        int[][] atlantic = new int[heights.length][heights[0].length];
        for(int i = 0; i < heights.length; i++)
            checkPacific(i, heights[0].length-1, atlantic, heights);
        for(int j = 0; j < heights[0].length; j++)
            checkPacific(heights.length-1, j, atlantic, heights);
        
        
        for(int i = 0; i < heights.length; i++){
            for(int j = 0; j < heights[0].length; j++){
                if(pacific[i][j] == 1 && atlantic[i][j] == 1){
                    List<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(i);
                    tmp.add(j);
                    list.add(tmp);
                }
            }
        }
        return list;
    }
   
    
    private void checkPacific(int i, int j, int[][]pacific, int[][]heights){
        Queue<int[]> que = new LinkedList<>();
            
        if(pacific[i][j] == 0){
            que.add(new int[]{i, j});
            pacific[i][j] = 1;
        }

        while(!que.isEmpty()){
            int[] curr = que.poll();
            int x = curr[0];
            int y = curr[1];

            if(x+1 < heights.length && pacific[x+1][y] == 0 && heights[x+1][y] >= heights[x][y]){
                que.add(new int[]{x+1,y});
                pacific[x+1][y] = 1;
            }
            if(y+1 < heights[0].length && pacific[x][y+1] == 0 && heights[x][y+1] >= heights[x][y]){
                que.add(new int[]{x,y+1});
                pacific[x][y+1] = 1;
            }
            if(x-1 >= 0 && pacific[x-1][y] == 0 && heights[x-1][y] >= heights[x][y]){
                que.add(new int[]{x-1,y});
                pacific[x-1][y] = 1;
            }
            if(y-1 >= 0 && pacific[x][y-1] == 0 && heights[x][y-1] >= heights[x][y]){
                que.add(new int[]{x,y-1});
                pacific[x][y-1] = 1;
            }

        }
    }
}
