import java.util.HashSet;

//Leetcode #36
//https://leetcode.com/problems/valid-sudoku/
//Time Complexity: O(n*n) [technically O(1) b/c fixed board]
//Space Complexity: O(n*n) [technically O(1) b/c fixed board]
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if(board.length != 9 || board[0].length != 9)
            return false;
        
        HashSet<Character>[] rowSet = new HashSet[9];
        HashSet<Character>[] colSet = new HashSet[9];
        HashSet<Character>[] numSet = new HashSet[9];
        
        for(int i = 0; i < 9; i++){
            rowSet[i] = new HashSet<>();
            colSet[i] = new HashSet<>();
            numSet[i] = new HashSet<>();
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                char currNum = board[i][j];
                
                if(currNum == '.')
                    continue;
                
                int z = getNumSet(i, j);
                
                if(rowSet[i].contains(currNum)) 
                    return false;        
                if(colSet[j].contains(currNum)) 
                    return false;
                if(numSet[z].contains(currNum)) 
                    return false;
                
                rowSet[i].add(currNum);
                colSet[j].add(currNum);
                numSet[z].add(currNum);
            }
        }
        
        return true;
    }
    
    public int getNumSet(int i, int j){
        if(i >= 0 && i <= 2){
            if(j >= 0 &&  j <= 2)
                return 0;
            else if(j >= 3 && j <= 5)
                return 1;
            else
                return 2;
        }
        else if(i >= 3 && i <= 5){
            if(j >= 0 &&  j <= 2)
                return 3;
            else if(j >= 3 && j <= 5)
                return 4;
            else
                return 5;
        }
        else{
            if(j >= 0 &&  j <= 2)
                return 6;
            else if(j >= 3 && j <= 5)
                return 7;
            else
                return 8;
        }
    }
}
