
//Leetcode #79
//https://leetcode.com/problems/word-search/
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j< board[0].length; j++){
                if(board[i][j] == word.charAt(0) && search(i, j, 0, visited, board, word))
                    return true;
            }
        }
        
        return false;
    }
    
    private boolean search(int i, int j, int sIdx, boolean[][] visited, char[][] board, String word){
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 
           || sIdx >= word.length() || board[i][j] != word.charAt(sIdx) ||visited[i][j])
            return false;
    
        visited[i][j] = true;
        if(sIdx == word.length()-1)
            return true;
        
        boolean found = search(i-1, j, sIdx+1, visited, board, word) || 
            search(i+1, j, sIdx+1, visited, board, word) || 
            search(i, j-1, sIdx+1, visited, board, word) || 
            search(i, j+1, sIdx+1, visited, board, word);
        
        
        visited[i][j] = false;
        return found;
    }
}
