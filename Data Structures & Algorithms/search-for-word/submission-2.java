class Solution {

    public boolean helper(char[][] board, int i, int j, boolean[][] matrix, String output, String word){
        
    
        if(output.length()==word.length()){
            // System.out.println(output);
            if(output.equals(word)){
                return true;
            }
            else{
                return false;
            }
        }
        if(i<0 || i>=board.length || j<0 || j>=board[0].length){
            return false;
        }

        if(matrix[i][j]==true){
            return false;
        }

        output+=board[i][j];
        matrix[i][j] = true;
        boolean ans = (helper(board, i-1, j, matrix, output, word) || helper(board, i+1, j, matrix, output, word) || helper(board, i, j-1, matrix, output, word) || helper(board, i, j+1, matrix, output, word));
        matrix[i][j] = false;
        return ans;
    }

    public boolean exist(char[][] board, String word) {
        boolean ans = false;

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                ans = (ans || helper(board, i, j, new boolean[board.length][board[0].length], "", word));
            }
        }
        return ans;
    }
}
