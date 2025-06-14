package ArrayQuestions;

import java.util.Arrays;

public class MoveZerosToEnd {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 0, 4, 3, 0, 5, 0};
//        int[] arr = {10, 20, 30};
        int[] arr = {0, 0};
        moveZeros(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void moveZeros(int[] arr) {
        int fPoint = 0;
        int sPoint = 0;

        for (int j : arr) {
            if (j != 0) {
                swap(arr, fPoint, sPoint);
                fPoint++;
            }
            sPoint++;
        }
    }

    private static void swap(int[] arr, int ind1, int ind2) {
        int tmp = arr[ind2];
        arr[ind2] = arr[ind1];
        arr[ind1] = tmp;
    }
}
