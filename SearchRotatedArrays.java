import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchRotatedArrays {
    public static void main(String[] args) {
        int[] arr = {1,0,1,1,1};
        int target = 0;
        System.out.println(search(arr, target));
    }

    public static boolean search(int[] nums, int target) {
        int pivot = findPivot(nums);

        if (pivot != -1) {
            if (nums[0] > target) {
                return binarySearch(nums, target, pivot, nums.length - 1);
            } else {
                return binarySearch(nums, target, 0, pivot);
            }
        }
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }

            if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
                if (start < end && arr[start] > arr[start + 1]) {
                    return start;
                }

                start++;

                if (start < end && arr[end] < arr[end - 1]) {
                    return (end - 1);
                }

                end--;
            } else if (arr[start] < arr[mid] || (arr[mid] == arr[start] && arr[mid] > arr[end])) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    private static boolean binarySearch(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return true;
            }

            if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return false;
    }
}
