import java.util.Arrays;

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {1,2,0,3};
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println(findMissing(arr));
    }

    public static void cyclicSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            if (arr[i] == i || arr[i] > arr.length - 1) {
                i++;
            }
            else {
                swap(arr, i, arr[i]);
            }
        }
    }

    public static void swap(int[] arr, int fIndex, int sIndex) {
        int tmp = arr[fIndex];
        arr[fIndex] = arr[sIndex];
        arr[sIndex] = tmp;
    }

    public static int findMissing(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i != arr[i]) {
                return i;
            }
        }
        return arr.length;
    }

}
