public class SearchInMountainArray {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 12, 10, 2};
        int target = 100;

        search(arr, target);
    }

    private static void search(int[] arr, int target) {
        int peakElementIndex = findPeakElementIndex(arr);

        if (peakElementIndex != -1) {

            if (arr[peakElementIndex] == target) {
                System.out.println(peakElementIndex);
                return;
            }

            int firstHalf = binarySearch(arr, target, true, 0, peakElementIndex);
            int secondHalf = binarySearch(arr, target, false, peakElementIndex + 1, arr.length - 1);

            if (firstHalf == -1) {
                System.out.println(secondHalf);
                return;
            }
            if (secondHalf == -1) {
                System.out.println(firstHalf);
                return;
            }
            System.out.println(Math.min(firstHalf, secondHalf));
        }
    }

    private static int findPeakElementIndex(int[] arr) {
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
        return mid;
    }

    private static int binarySearch(int[] arr, int target, boolean isAsc, int start, int end) {

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }
            if (isAsc) {
                if (arr[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (arr[mid] > target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
