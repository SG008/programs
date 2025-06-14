package ArrayQuestions;

import java.util.Arrays;

public class ArrayRotationByKTime {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6 };
        int k = 8;
        k = k % arr.length;
        rotateArray(arr, k);
        System.out.println(Arrays.toString(arr));
    }

    private static void rotateArray (int[] arr, int n) {
        reverseArray(arr, 0, (n - 1));
        reverseArray(arr, n, arr.length - 1);
        reverseArray(arr, 0, arr.length - 1);
    }

    private static void reverseArray(int[] arr, int start, int end)  {
        while (start < end) {
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
    }
}
