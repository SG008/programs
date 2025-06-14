package basicCodingQuestions;

import java.util.Arrays;

public class CircularRotationByK {
    public static void main(String[] args) {
        int[] arr = {1 ,2, 3, 4, 5};
        rotate(arr, 6); // work only when rotations are given <= length
    }

    public static void rotate(int[] arr, int k) {
        int[] tmp = new int[k];

        System.arraycopy(arr, 0, tmp, 0, k);

        for (int i = k; i < arr.length; i++) {
            arr[i - k] = arr[i];
        }

        for (int i = 0; i < k; i++) {
            arr[arr.length - 1 - i] = tmp[k - i - 1];
        }

        System.out.println(Arrays.toString(arr));
    }
}
