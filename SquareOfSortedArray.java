//Given an integer array nums sorted in non-decreasing order, return an array of the squares of
// each number sorted in non-decreasing order.
//        Example 1:
//
//        Input: nums = [-4,-1,0,3,10]
//        Output: [0,1,9,16,100]
//        Explanation: After squaring, the array becomes [16,1,0,9,100].
//        After sorting, it becomes [0,1,9,16,100].
//        Example 2:
//
//        Input: nums = [-7,-3,2,3,11]
//        Output: [4,9,9,49,121]
//[-5,-3,-2,-1] -- > [1,4,9,25]
//[-10000,-9999,-7,-5,0,0,10000] --> [0,0,25,49,99980001,100000000,100000000]
//https://leetcode.com/problems/squares-of-a-sorted-array/description/

import java.util.Arrays;

public class SquareOfSortedArray {
    public static void main(String[] args) {
        int[] nums = {-10000, -9999, -7, -5, 0, 0, 10000};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }

    public static int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {

            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[i] = nums[left] * nums[left];
                left++;
            } else {
                result[i] = nums[right] * nums[right];
                right--;
            }

        }

        return result;
    }

}
