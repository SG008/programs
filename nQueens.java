public class nQueens {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        System.out.println(nQueensSol(board, 0));
    }

    private static int nQueensSol(boolean[][] board, int row) {

        if (row == board.length) {
            display(board);
            System.out.println();
            return 1;
        }

        int count = 0;

        //placing the queen and checking for every col and row
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                count += nQueensSol(board, row + 1);
                board[row][col] = false;
            }
        }

        return count;
    }

    private static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean element : row) {
                if (element) {
                    System.out.print("Q ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {

        //vertical check
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }

        //left diagonal check
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row - i][col - i]) {
                return false;
            }
        }

        //right diagonal check
        int maxRight = Math.min(row, board.length - col - 1);
        for (int i = 1; i <= maxRight; i++) {
            if (board[row - i][col + i]) {
                return false;
            }
        }

        return true;
    }
}
