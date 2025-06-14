//Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
// find two numbers such that they add up to a specific target number.
// Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
//Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
//The tests are generated such that there is exactly one solution. You may not use the same element twice.
//
//        Your solution must use only constant extra space.
//        Example 1:
//
//        Input: numbers = [2,7,11,15], target = 9
//        Output: [1,2]
//        Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
//        Example 2:
//
//        Input: numbers = [2,3,4], target = 6
//        Output: [1,3]
//        Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
//        Example 3:
//
//        Input: numbers = [-1,0], target = -1
//        Output: [1,2]
//        Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoSum {
    public static void main(String[] args) {
//        int[] nums = {2, 7, 11, 15};
//        System.out.println(Arrays.toString(twoSumOfSortedArray(nums, 9)));

        int[] arr = {-8, 10, 12, -15, 15, 24};
        int target = 0;
        System.out.println(Arrays.toString(twoSumOfAbsoluteSortedArray(arr, target)));
    }

    // using 2 pointer solution --> works on sorted array
    public static int[] twoSumOfSortedArray(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int[] result = new int[2];

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                return result;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return result;
    }

    // hashing method works on unsorted array
    public static boolean twoSumOfUnsortedArray(int[] array, int target) {
        int[] res = new int[2];

        Set<Integer> el = new HashSet<>();

        for (int i = 0; i < array.length; i++) {
            int comp = target - array[i];

            if (el.contains(comp)) {
                return true;
            }

            el.add(array[i]);
        }

        return false;
    }

    // 3 cases of 2 pointer method for absolute sorted array
    // absolute sorted array are array which are sorted based on absolute values of array i.e array contains negative integer
    // but positive of that integer is greater that previous element
    public static int[] twoSumOfAbsoluteSortedArray(int[] arr, int target) {
        int[] res = new int[2];

        // case 1: both are positive
        for (int i = 0, j = arr.length - 1; i < j;) {
            if (arr[i] < 0) {
                i++;
            } else if (arr[j] < 0) {
                j--;
            } else {
                int sum = arr[i] + arr[j];
                if (sum == target) {
                    res[0] = i + 1;
                    res[1] = j + 1;
                    return res;
                }
                if (sum < target) {
                    i++;
                } else {
                    j--;
                }
            }


        }

        //case 2: both are negative
        for (int i = 0, j = arr.length - 1; i < j;) {
            if (arr[i] > 0) {
                i++;
            } else if (arr[j] > 0) {
                j--;
            } else {
                int sum = arr[i] + arr[j];
                if (sum == target) {
                    res[0] = i + 1;
                    res[1] = j + 1;
                    return res;
                }
                if (sum < target) {
                    j--;
                } else {
                    i++;
                }
            }
        }

        //case 3: one is positive and one is negative (here we can assume that i is positive and j is negative)
        for (int i = 0, j = 0; i < arr.length && j < arr.length;) {
            if (arr[i] < 0) {
                i++;
            } else if (arr[j] > 0) {
                j++;
            } else {
                int sum = arr[i] + arr[j];

                if (sum == target) {
                    res[0] = Math.min(i + 1, j + 1);
                    res[1] = Math.max(i + 1, j + 1);
                    return res;
                }
                // if sum is smaller, move to larger value
                if (sum < target) {
                    i++;
                }
                // if sum is larger, move toward smaller value
                else {
                    j++;
                }
            }

        }
        return res;
    }
}
