//Given an integer array nums, return an array answer such that answer[i]
// is equal to the product of all the elements of nums except nums[i].
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
// You must write an algorithm that runs in O(n) time and without using the division operation.
//        Example 1:
//
//        Input: nums = [1,2,3,4]
//        Output: [24,12,8,6]
//        Example 2:
//
//        Input: nums = [-1,1,0,-3,3]
//        Output: [0,0,9,0,0]

//[-1,1,0,-3,3] --> [-9,-9,9,3,-3]
//https://leetcode.com/problems/product-of-array-except-self/

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] products = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            for (int num : nums) {
                if (nums[i] == num) {
                    continue;
                }
                products[i] = num;
            }
        }

        return products;
    }
}
