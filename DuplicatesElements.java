import java.util.Arrays;

public class DuplicatesElements {
    public static void main(String[] args) {
        int[] arr = {1, 1};
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(findDuplicate(arr));
    }

    public static void cyclicSort(int[] arr) {
        int i = 0;

        while (i < arr.length - 1) {
            if (arr[i] == (i + 1)) {
                i++;
            } else if ((arr[arr[i] - 1]) == arr[i]) {
                i++;
            }
            else {
                swap(arr, i, arr[i] - 1);
            }
        }
    }

    public static void swap(int[] arr, int fIndex, int sIndex) {
        int tmp = arr[fIndex];
        arr[fIndex] = arr[sIndex];
        arr[sIndex] = tmp;
    }

    public static int findDuplicate(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != (i + 1)) {
                return arr[i];
            }
        }
        return -1;
    }
}
