import java.util.Arrays;

//https://leetcode.com/problems/rotate-image/description/
public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}};
        rotate(matrix);
        display(matrix);
    }

    public static void rotate(int[][] matrix) {
        int[][] temp = new int[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                temp[j][i] = matrix[i][j];
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int tmp = temp[j][temp[j].length - 1 - i];
                matrix[j][matrix[j].length - 1 - i] = temp[j][i];
                matrix[j][i] = tmp;
            }
        }

    }

    public static void display(int[][] intervals) {
        for (int[] arr : intervals) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
