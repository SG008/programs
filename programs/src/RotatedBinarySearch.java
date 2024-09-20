public class RotatedBinarySearch {

    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int key = 6;
        System.out.println(search(arr, key, 0, arr.length - 1));
    }

    public static int search(int[] arr, int key, int start, int end) {

        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        if (arr[mid] == key) {
            return mid;
        }

        if (arr[start] <= arr[mid]) {
            if (key >= arr[start] && key <= arr[mid]) {
                return (search(arr, key, start, mid - 1));
            } else {
                return search(arr, key, mid + 1, end);
            }
        } else if (key >= arr[mid] && key <= arr[end]) {
            return search(arr, key, mid + 1, end);
        } else {
            return search(arr, key, start, mid - 1);
        }
    }

}
