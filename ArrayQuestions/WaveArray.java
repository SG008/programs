package ArrayQuestions;

import java.util.Arrays;

public class WaveArray {
    public static void main(String[] args) {
        int[] arr = {10, 90, 49, 2, 1, 5, 23};
        convertToWaveArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    /*
        Traverse all even positioned elements of the input array, and do the following.
        If the current element is smaller than the previous odd element, swap the previous and current.
        If the current element is smaller than the next odd element, swap next and current.
    */
    private static void convertToWaveArray(int[] arr) {
        for (int i = 0; i < arr.length; i+=2) {
            if (i > 0 && arr[i] < arr[i - 1]) {
                swap(arr, i, (i - 1));
            } if (i < (arr.length - 1) && arr[i] < arr[i + 1]) {
                swap(arr, i , (i + 1));
            }
        }
    }

    private static void swap(int[] arr, int fInd, int sInd) {
        int tmp = arr[fInd];
        arr[fInd] = arr[sInd];
        arr[sInd] = tmp;
    }
}
