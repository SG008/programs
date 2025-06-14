import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}};
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int sCol = 0;
        int sRow = 0;
        int eCol = matrix[sCol].length - 1;
        int eRow = matrix.length - 1;
        int i = 0;
        int j = 0;
        boolean isRev = false;
        while (eCol >= sCol && eRow >= sRow) {
            if (!isRev) {
                while (j <= eCol) {
                    res.add(matrix[i][j]);
                    j++;
                }
                sRow++;
                i = sRow;
                j--;
                while (i <= eRow) {
                    res.add(matrix[i][j]);
                    i++;
                }
                eCol--;
                j = eCol;
                i--;
                isRev = true;
            } else {
                while (j >= sCol) {
                    res.add(matrix[i][j]);
                    j--;
                }
                eRow--;
                i = eRow;
                j++;
                while (i >= sRow) {
                    res.add(matrix[i][j]);
                    i--;
                }
                sCol++;
                j = sCol;
                isRev = false;
                i = sRow;
            }

        }
        
        return res;
    }
}
