public class nKnights {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        nKnightsSol(board, 0,0,4);
    }

    private static void nKnightsSol(boolean[][] board, int row, int col, int knights) {
         if(knights == 0) {
             display(board);
             System.out.println();
             return;
         }

         if(row == board.length-1 && col == board.length) {
             return;
         }

         if(col == board.length) {
             nKnightsSol(board, row+1,0,knights);
             return;
         }

         if(isSafe(board,row,col)) {
             board[row][col] = true;
             nKnightsSol(board, row, col+1,knights-1);
             board[row][col] = false;
         }

         nKnightsSol(board, row, col+1,knights);


    }

    private static boolean isSafe(boolean[][] board, int row, int col) {

        if(ifBoardPositionValid(board,row-2,col-1)) {
            if(board[row-2][col-1]) {
                return false;
            }
        }

        if(ifBoardPositionValid(board,row-1,col-2)) {
            if(board[row-1][col-2]) {
                return false;
            }
        }

        if(ifBoardPositionValid(board,row-2,col+1)) {
            if(board[row-2][col+1]) {
                return false;
            }
        }

        if(ifBoardPositionValid(board,row-1,col+2)) {
            if(board[row-1][col+2]) {
                return false;
            }
        }

        return true;
    }

    private static boolean ifBoardPositionValid(boolean[][] board, int row, int col) {
        return col >= 0 && col < board.length && row >= 0 && row < board.length;
    }

    private static void display(boolean[][] board) {
         for (boolean[] arr: board) {
             for (boolean element : arr) {
                 if(element) {
                     System.out.print("K ");
                 }
                 else {
                     System.out.print("X ");
                 }
             }
             System.out.println();
         }
    }
}
