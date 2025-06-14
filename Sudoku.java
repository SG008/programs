public class Sudoku {
    public static void main(String[] args) {

        int[][] board = new int[][]{
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };
        if(sudokuSol(board)) {
            display(board);
        }
        else {
            System.out.println("Board cannot be solved");
        }
    }

    private static boolean sudokuSol(int[][] board) {

        int n = board.length;
        int row = -1;
        int col = -1;


        boolean emptyLeft = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    emptyLeft = false;
                    break;
                }
            }

            if (!emptyLeft) {
                break;
            }
        }

        if (emptyLeft) {
            return true;
        }

        for (int number = 1; number <= 9; number++) {
            if (isSafe(board, row, col, number)) {
                board[row][col] = number;
                if (sudokuSol(board)) {
                    return true;
                } else {
                    board[row][col] = 0;
                }
            }
        }

        return false;
    }

    private static void display(int[][] board) {
        for (int[] row : board) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static boolean isSafe(int[][] board, int row, int col, int num) {

        //row check
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        //column check
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }

        int boardSqrt = (int) Math.sqrt(board.length);
        int rowStart = row - row % boardSqrt;
        int colStart = col - col % boardSqrt;

        for (int i = rowStart; i < boardSqrt; i++) {
            for (int j = colStart; j < boardSqrt; j++) {
                if (board[i + rowStart][j + colStart] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}
