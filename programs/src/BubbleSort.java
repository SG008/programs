import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {9, 5, 4, 2, 7, 3, 6, 8, 1, 0};
//        sort(arr);
        recursiveBubbleSort(arr, arr.length - 1, 0);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {

        int length = arr.length - 1;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void recursiveBubbleSort(int[] arr, int length, int index) {

        if (length == 0) {
            return;
        }

        if (index < length) {
            if (arr[index] > arr[index + 1]) {
                swap(arr, index, index + 1);
            }
            recursiveBubbleSort(arr, length, index + 1);
        } else {
            recursiveBubbleSort(arr, length - 1, 0);
        }
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
