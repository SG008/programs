package ArrayQuestions;

import java.util.Arrays;

/*
Consider every sub-array of size k starting from the beginning of the array and reverse it. We need to handle some special cases.

If k is not a multiple of n where n is the size of the array, for the last group we will have less than k elements left, we need to reverse all remaining elements.
If k = 1, the array should remain unchanged. If k >= n, we reverse all elements present in the array.
*/
public class ReverseArrayInGroups {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int k = 3;

        reverseInGroups(arr, k);

        System.out.println(Arrays.toString(arr));
    }

    static void reverseInGroups(int[] arr, int k) {
        int n  = arr.length;
        for (int i = 0; i < arr.length; i += k) {
            int left = i;
            int right = Math.min(i + k - 1, n - 1);

            // reversing subarray
            while (left < right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
    }

    public static void swap (int[] arr, int ind1, int ind2) {
        int temp = arr[ind2];
        arr[ind2] = arr[ind1];
        arr[ind1] = temp;
    }
}
