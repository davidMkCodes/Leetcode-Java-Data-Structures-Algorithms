import java.util.LinkedList;
import java.util.Queue;

//Leetcode #130
//https://leetcode.com/problems/surrounded-regions/
//Time Complexity: O(m*n)
//Space Complexity: O(m*n)
public class SurroundedRegions {
    public void solve(char[][] board) {
        
        for(int i = 0; i < board.length; i++){
            if(board[i][0] == 'O')
                bfs(i, 0, board);
            if(board[i][board[0].length-1] == 'O')
                bfs(i, board[0].length-1, board);
        }
        for(int j = 0; j < board[0].length; j++){
            if(board[0][j] == 'O')
                bfs(0, j, board);
            if(board[board.length-1][j] == 'O')
                bfs(board.length-1,j, board);
        }
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                if(board[i][j] == 'T')
                    board[i][j] = 'O';
            }
        }
    }
    
    public void bfs(int i, int j, char[][]board){
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{i,j});
        board[i][j] = 'T';
        while(!que.isEmpty()){
            int[]p = que.poll();
            int x = p[0];
            int y = p[1];
            
            if(x-1 >= 0 && board[x-1][y] == 'O'){
                que.add(new int[]{x-1,y});
                board[x-1][y] = 'T';
            }
            if(y-1 >= 0 && board[x][y-1] == 'O'){
                que.add(new int[]{x, y-1});
                board[x][y-1] = 'T';
            }
            if(x+1 < board.length && board[x+1][y] == 'O'){
                que.add(new int[]{x+1,y});
                board[x+1][y] = 'T';
            }
            if(y+1 < board[0].length && board[x][y+1] == 'O'){
                que.add(new int[]{x,y+1});
                board[x][y+1] = 'T';
            }
        }
    }
}
