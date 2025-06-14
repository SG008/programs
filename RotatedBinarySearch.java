
// pivot function can be used to also find the number of times the sorted array is rotated just return the pivot_index + 1
public class RotatedBinarySearch {

    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int key = 6;
        int target = 3;
        int pivot = findPivot(arr);

        if (arr[pivot] == target) {
            System.out.println(pivot);
            return;
        }
        if (arr[0] <= target && arr[pivot] > target) {
            binarySearch(arr, 0, pivot, target);
        } else {
            binarySearch(arr, pivot, arr.length, target);
        }
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

    // does not work for duplicate values
    public static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            if (mid > start && arr[mid] < arr[mid - 1]) {
                return (mid - 1);
            }
            if (arr[mid] <= arr[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static int findPivotWithDuplicates(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return (mid - 1);
            }

            // if elements at mid, start and end are equal
            if (arr[mid] == arr[start] && arr[mid] == arr[end]) {

                //skip the duplicates
                //NOTE : what if start or end are the pivot
                // checking if start is the pivot
                if (arr[start] > arr[start + 1]) {
                    return start;
                }
                start++;

                // checking if end is the pivot
                if (arr[end - 1] > arr[end]) {
                    return end - 1;
                }

                end--;
            } else if (arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    private static void binarySearch(int[] arr, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2;

            if(arr[mid] == target) {
                System.out.println(mid);
                return;
            }
            if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
    }

}
