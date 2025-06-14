package ArrayQuestions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlternativePosAndNeg {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, -4, -1, 4};
        int[] arr = { 2, 3, -4, -1, 6, -9 };
        arrangePosAndNegNumber(arr);
        arrPosAndNegNumber(arr);
    }


    // maintain element relative order
    // time --> O(n) and space -> O(n)
    private static void arrangePosAndNegNumber(int[] arr) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        for (int i : arr) {
            if (i < 0) {
                neg.add(i);
            }
            else {
                pos.add(i);
            }
        }

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < pos.size() && j < neg.size()) {
            arr[k++] = pos.get(i);
            arr[k++] = neg.get(j);
            i++;
            j++;
        }

        while (i < pos.size()) {
            arr[k++] = pos.get(i);
            i++;
        }

        while (j < neg.size()) {
            arr[k++] = neg.get(i);
            j++;
        }

        System.out.println(Arrays.toString(arr));
    }

    //not maintaining elements order
    //space --> 1 and time --> O(n)
    private static void arrPosAndNegNumber(int[] arr) {
        int i = 0;
        int n = arr.length;
        int j = arr.length - 1;

        while (i < j) {
            while (i < (n - 1) && arr[i] > 0) {
                i++;
            }

            while (j > 0 && arr[j] < 0) {
                j--;
            }

            if (i < j) {
                swap(arr, i, j);
            }
        }

        int k = 1;
        while (k < n && i < n) {
            swap(arr, k, i);
            k+=2;
            i+=1;
        }

        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] arr, int fInd, int sInd) {
        int tmp = arr[fInd];
        arr[fInd] = arr[sInd];
        arr[sInd] = tmp;
    }
}
