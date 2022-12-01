import java.util.List;
import java.util.ArrayList;

//Leetcode #54
//https://leetcode.com/problems/spiral-matrix/
//Time Complexity: O(n*m)
//Space Complexity: O(n*m)
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> list = new ArrayList<>();
        int upperBound = 0;
        int leftBound = 0;
        int rightBound = matrix[0].length;
        int lowerBound = matrix.length;
        
        int i = 0;
        int j = 0;
        while(i >= upperBound && i < lowerBound && j >= leftBound && j < rightBound){
        
            //j++ to rightBound
            while(j < rightBound){
                list.add(matrix[i][j]);
                j++;
            }
            j--;
            i++;
            
            if(i < upperBound || i >= lowerBound || j < leftBound || j >+ rightBound)
                break;
            //i++ to lowerBound
            while(i < lowerBound){
                list.add(matrix[i][j]);
                i++;
            }
            i--;
            j--;
            if(i < upperBound || i >= lowerBound || j < leftBound || j >+ rightBound)
                break;
            //j-- to leftBound
            while(j >= leftBound){
                list.add(matrix[i][j]);
                j--;
            }
            
            j++;
            i--;
            if(i < upperBound || i >= lowerBound || j < leftBound || j >+ rightBound)
                break;
            //i-- to upperBound-1
            while(i >= upperBound+1){
                list.add(matrix[i][j]);
                i--;
            }
            
            i++;
            j++;
            //adjust bounds and i and j
            upperBound++;
            leftBound++;
            rightBound--;
            lowerBound--;
        }
        
        return list;
    }
}
