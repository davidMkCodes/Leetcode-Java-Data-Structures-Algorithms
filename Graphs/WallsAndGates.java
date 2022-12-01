import java.util.Queue;
import java.util.LinkedList;

//Leetcode #286
//https://leetcode.com/problems/walls-and-gates/
//Time Complexity: O(m*n)
//Space Complexity: O(m*n)
public class WallsAndGates {
    public void wallsAndGates(int[][] rooms) {
        
        Queue<int[]> que = new LinkedList<>();
        
        for(int i = 0; i < rooms.length; i++){
            for(int j = 0; j < rooms[0].length; j++){
                if(rooms[i][j] == 0)
                    que.add(new int[]{i,j});
            }
        }
        
        while(!que.isEmpty()){
            int size = que.size();
            
            for(int i = 0; i < size; i++){
                int[] p = que.poll();
                int x = p[0];
                int y = p[1];
                int nearestGate = rooms[x][y]+1;
                
                if(x-1 >= 0 && nearestGate < rooms[x-1][y]){
                    que.add(new int[]{x-1,y});
                   rooms[x-1][y] = nearestGate;
                }
                if(y-1 >= 0 && nearestGate < rooms[x][y-1]){
                    que.add(new int[]{x,y-1});
                    rooms[x][y-1] = nearestGate;
                }
                if(x+1 < rooms.length && nearestGate < rooms[x+1][y]){
                    que.add(new int[]{x+1,y});
                    rooms[x+1][y] = nearestGate;
                }
                if(y+1 < rooms[0].length && nearestGate < rooms[x][y+1]){
                    que.add(new int[]{x,y+1});
                    rooms[x][y+1] = nearestGate;
                }
            }
        }
    }
}
