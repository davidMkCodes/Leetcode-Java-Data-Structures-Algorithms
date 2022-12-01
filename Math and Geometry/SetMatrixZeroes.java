//Leetcode #73
//https://leetcode.com/problems/set-matrix-zeroes/
//Time Complexity: O(n*m)
//Space Complexity: O(n*m)
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(visited[i][j])
                    continue;
                else if(matrix[i][j] == 0)
                    helper(i, j, matrix, visited);
            }
        }
    }
    
    private void helper(int i, int j, int[][]matrix, boolean[][] visited){
        
        visited[i][j] = true;
        
        for(int z = j; z < matrix[0].length; z++){
            if(visited[i][z] || matrix[i][z] == 0)
                continue;
            
            matrix[i][z] = 0;
            visited[i][z] = true;
        }
        
        for(int z = j; z >= 0; z--){
             if(visited[i][z] || matrix[i][z] == 0)
                 continue;
            
            matrix[i][z] = 0;
            visited[i][z] = true;
        }
        
        for(int z = i; z < matrix.length; z++){
             if(visited[z][j] || matrix[z][j] == 0)
                continue;
            matrix[z][j] = 0;
            visited[z][j] = true;
        }
        
        for(int z = i; z >= 0; z--){
             if(visited[z][j] || matrix[z][j] == 0)
                continue;
            matrix[z][j] = 0;
            visited[z][j] = true;
        }
    }
}
