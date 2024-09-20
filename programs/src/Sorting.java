import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
//        insertionSort(arr);
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(mergeSort(arr)));
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    private static void insertionSort(int[] arr) {
        for (int i = 0; i <= arr.length - 2; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    private static void swap(int[] arr, int fIndex, int sIndex) {
        int temp = arr[fIndex];
        arr[fIndex] = arr[sIndex];
        arr[sIndex] = temp;
    }

    private static void quickSort(int[] arr, int low, int high) {

        if (low >= high) {
            return;
        }

        int s = low;
        int e = high;
        int mid = s + (e - s) / 2;
        int pivot = arr[mid];

        while (s <= e) {
            while (arr[s] < pivot) {
                s++;
            }
            while (arr[e] > pivot) {
                e--;
            }

            if (s <= e) {
                swap(arr, s, e);
                s++;
                e--;
            }
        }

        //pivot is at the correct position
        quickSort(arr, low, e);
        quickSort(arr, s, high);
    }

    private static int[] mergeSort(int[] arr) {

        int length = arr.length;

        if (length == 1) {
            return arr;
        }

        int mid = length / 2;

        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, length));

        return merge(left, right);

    }

    private static int[] merge(int[] first, int[] second) {

        int fLength = first.length;
        int sLength = second.length;
        int[] mergedArray = new int[fLength + sLength];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < fLength && j < sLength) {
            if (first[i] < second[j]) {
                mergedArray[k] = first[i];
                i++;
            } else {
                mergedArray[k] = second[j];
                j++;
            }
            k++;
        }

        while (i < fLength) {
            mergedArray[k] = first[i];
            i++;
            k++;
        }

        while (j < sLength) {
            mergedArray[k] = second[j];
            j++;
            k++;
        }


        return mergedArray;
    }
}
