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
        // Check vertically above
        for (int i = 0; i < row; i++) {
            if (board[i][col]) return false;
        }

        // Check diagonal top-left
        for (int i = 1; i <= Math.min(row, col); i++) {
            if(board[row - i][col - i]) return false;
        }

        // Check diagonal top-right
        for (int i = 1; i <= Math.min(row, board.length - col - 1); i++) {
            if(board[row - i][col + i]) return false;
        }

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