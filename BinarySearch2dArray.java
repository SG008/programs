import java.util.Arrays;

public class BinarySearch2dArray {
    public static void main(String[] args) {

//        int[][] matrix = new int[][]{
//                {10, 20, 30, 40},
//                {15, 25, 35, 45},
//                {28, 29, 37, 49},
//                {33, 34, 38, 50}
//        };
//        search(matrix, 0);

        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        System.out.println(Arrays.toString(binarySearch(matrix, 45)));
    }

    private static void search(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                System.out.println("found element at row:" + row + " column:" + col);
                return;
            } else if (matrix[row][col] < target) {
                row++;
            } else if (matrix[row][col] > target) {
                col--;
            }
        }
        System.out.println("no element found");
    }

    private static int[] binarySearch(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length - 1;

        if (row == 1) {
            return rowSearch(matrix, row, 0, col - 1, target);
        }

        int rStart = 0;
        int rEnd = row - 1;
        int cMid = col / 2;

        while (rStart < (rEnd - 1)) { //while this is true we have more than 2 rows

            int rMid = (rEnd + rStart) / 2;

            if (matrix[rMid][cMid] == target) {
                return new int[]{rMid, cMid};
            } else if (matrix[rMid][cMid] < target) {
                rStart = rMid;
            } else if (matrix[rMid][cMid] > target) {
                rEnd = rMid;
            }
        }

        //now we only have 2 rows
        if (target >= matrix[rStart][0] && target <= matrix[rStart][matrix[rStart].length - 1]) {

            return rowSearch(matrix, rStart, 0, matrix[rStart].length - 1, target);
        }

        return rowSearch(matrix, rStart + 1, 0, matrix[rStart].length - 1, target);

    }

    private static int[] rowSearch(int[][] matrix, int row, int cStart, int cEnd, int target) {

        while (cStart <= cEnd) {
            int mid = (cStart + cEnd) / 2;
            if (matrix[row][mid] == target) {
                return new int[]{row, mid};
            } else if (matrix[row][mid] > target) {
                cEnd = mid - 1;
            } else if (matrix[row][mid] < target) {
                cStart = mid + 1;
            }
        }

        return new int[]{-1, -1};
    }
}
