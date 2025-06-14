import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Given an integer array nums,
// return all the triplets [nums[i], nums[j], nums[k]]
// such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
//        Notice that the solution set must not contain duplicate triplets.
//        Example 1:
//
//        Input: nums = [-1,0,1,2,-1,-4]
//        Output: [[-1,-1,2],[-1,0,1]]
//        Explanation:
//        nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
//        nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
//        nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
//        The distinct triplets are [-1,0,1] and [-1,-1,2].
//        Notice that the order of the output and the order of the triplets does not matter.
//        Example 2:
//
//        Input: nums = [0,1,1]
//        Output: []
//        Explanation: The only possible triplet does not sum up to 0.
//        Example 3:
//
//        Input: nums = [0,0,0]
//        Output: [[0,0,0]]
//        Explanation: The only possible triplet sums up to 0.
//https://leetcode.com/problems/3sum/description/

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
//        System.out.println(threeSumToMatchTarget(nums, 0));
        System.out.println(threeSumUsingSorting(nums, 0));
    }

    public static List<List<Integer>> threeSumToMatchTarget(int[] nums, int target) {
        Set<List<Integer>> res = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            Set<Integer> el = new HashSet<>();

            for (int j = i + 1; j < nums.length; j++) {
                int sec = target - (nums[i] + nums[j]);

                if (el.contains(sec)) {
                    List<Integer> result = new ArrayList<>(List.of(nums[i], nums[j], sec));
                    Collections.sort(result);
                    res.add(result);
                }
                el.add(nums[j]);
            }
        }
        return res.stream().toList();
    }

    public static List<List<Integer>> threeSumUsingSorting(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
             int l = i + 1;
             int r = nums.length - 1;
             int rem = target - nums[i];

             while (l < r) {
                 int sum = nums[l] + nums[r];
                 if (rem == sum) {
                     List<Integer> result = new ArrayList<>(List.of(nums[i], nums[l], nums[r]));
                     Collections.sort(result);
                     res.add(result);
                 }

                 if (target > sum) {
                     l++;
                 } else {
                     r--;
                 }
             }
        }
        return res.stream().toList();
    }
}
