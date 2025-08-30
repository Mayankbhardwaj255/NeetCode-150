 public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];  // 4x4 chessboard
        System.out.println(queens(board, 0));   // Start placing from row 0
    }

    static int queens(boolean[][] board, int row) {
        if (row == board.length) {
            display(board);        // Base case: placed all queens
            System.out.println();  // Print the solution
            return 1;              // Count this valid arrangement
        }

        int count = 0;
        for (int col = 0; col < board.length; col++) {
            if(isSafe(board, row, col)) {
                board[row][col] = true;           // Place queen
                count += queens(board, row + 1);  // Recur for next row
                board[row][col] = false;          // Backtrack
            }
        }

        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
     //check horizontally:-
     for(int j = 0; j<n; j++){
      if (board[row][j])
         return false;
     }
     
        // Check vertically above
        for (int i = 0; i < row; i++) {
            if (board[i][col]) return false;
        }

        // Check for left diagonal:-

     for(int i =row, j=col; i>=0, j>=0; i--,j--){
      if(board[i][j])
       return false;
     }

     //For right diagonal:-

     for(int i=row, j=col; i>=0; j<n; i--,j++){
      if(board[i][j])
       return false;
     }
     return false;

      return true;
    }

    private static void display(boolean[][] board) {
        for(boolean[] row : board) {
            for(boolean element : row) {
                System.out.print(element ? "Q " : "X ");
            }
            System.out.println();
        }
    }
}
