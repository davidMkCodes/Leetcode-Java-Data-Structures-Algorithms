
//Leetcode #74
//https://leetcode.com/problems/search-a-2d-matrix/
//Time Complexity: O(log(mn))
//Space Complexity: O(1)
public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int l = 0;
        int r = matrix.length-1;
        
        while(l <= r){
            int m = l + (r-l)/2;
            
            if(target >= matrix[m][0] && target <= matrix[m][matrix[0].length-1]){
                int row = m;
                l = 0;
                r = matrix[0].length-1;
                
                while(l <= r){
                    m = l + (r-l)/2;
                    
                    if(matrix[row][m] == target)
                        return true;
                    
                    if(matrix[row][m] < target)
                        l = m+1;
                    else
                        r = m-1;
                }
                
                return false;
            }
            
            if(matrix[m][0] < target)
                l = m+1;
            else
                r = m-1;
        }
        
        return false;
    }
}
