
//Leetcode #48
//https://leetcode.com/problems/rotate-image/
//Time Complexity: O(n^2)
//Space Complexity: O(1)
public class RotateImage {
    public void rotate(int[][] matrix) {
        
        int n = matrix.length-1;
        
        for(int i = 0; i < matrix.length-1; i++){
            
            for(int j = i; j < matrix[0].length-i-1; j++){
                int tmp = matrix[i][j];
                
                //down to up
                
                matrix[i][j] = matrix[n-j][i];
                int newI = n-j;
                int newJ = i;
                    
                //right to down
                
                matrix[newI][newJ] = matrix[n-newJ][newI];
                int t = newJ;
                newJ = newI;
                newI = n-t;
                
                //up to right
                matrix[newI][newJ] = matrix[n-newJ][newI];
                t = newI;
                newI = n - newJ;
                newJ = t;
                    
                //left to up
                matrix[newI][newJ] = tmp;
                
            }
        }
    }
}
