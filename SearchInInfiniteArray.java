public class SearchInInfiniteArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                    11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
                    21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
                    31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
                    41, 42, 43, 44, 45, 46, 47, 48, 49, 50};

        int target = 15;
        int start = 0;
        int end = 1;
        while (arr[start] < target) {
            int newStart = end + 1;
            end = end + (end - start) * 2;
            start = newStart;
        }
        binarySearch(arr, target, start, end);
    }

    public static void binarySearch(int[] arr, int target, int start, int end) {

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                System.out.println("target found at index: " + mid);
                break;
            }
            else if (arr[mid] < target) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }

        }
    }
}
