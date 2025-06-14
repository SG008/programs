package ArrayQuestions;

import java.util.Arrays;

public class RemoveOccurrenceOfElement {
    public static void main(String[] args) {
//        int[] arr = {0, 1, 3, 0, 2, 2, 4, 2};
        int[] arr = {2, 2, 2, 2};
        int ele = 2;

//        removeElementOccurrence(arr, ele);
        removeDuplicatesFromSortedArray(arr);
//        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int[] arr, int ind1, int ind2) {
        int temp = arr[ind2];
        arr[ind2] = arr[ind1];
        arr[ind1] = temp;
    }

    private static void removeElementOccurrence(int[] arr, int e) {
        int fp = 0;
        int sp = 0;
        while (sp < arr.length) {
            if (arr[sp] == e) {
                sp++;
            } else {
                swap(arr, fp, sp);
                fp++;
                sp++;
            }
        }
    }

    private static void removeDuplicatesFromSortedArray(int[] arr) {
        int k = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] != arr[i]) {
                arr[k] = arr[i];
                k++;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
