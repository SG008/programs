public class FindPeakInMountainArray {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 12, 10, 6, 2};
        findPeak(arr);
    }

    private static void findPeak(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int mid = start + (end - start) / 2;

        while (start < end) {
            mid = start + (end - start) / 2;

            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(arr[mid]);
    }
}
