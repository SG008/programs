//You are given a sorted unique integer array nums.
//
//        A range [a,b] is the set of all integers from a to b (inclusive).
//
//        Return the smallest sorted list of ranges that cover all the numbers in the array exactly.
//        That is, each element of nums is covered by exactly one of the ranges,
//        and there is no integer x such that x is in one of the ranges but not in nums.
//
//        Each range [a,b] in the list should be output as:
//
//        "a->b" if a != b
//        "a" if a == b
//
//        Example 1:
//
//        Input: nums = [0,1,2,4,5,7]
//        Output: ["0->2","4->5","7"]
//        Explanation: The ranges are:
//        [0,2] --> "0->2"
//        [4,5] --> "4->5"
//        [7,7] --> "7"
//        Example 2:
//
//        Input: nums = [0,2,3,4,6,8,9]
//        Output: ["0","2->4","6","8->9"]
//        Explanation: The ranges are:
//        [0,0] --> "0"
//        [2,4] --> "2->4"
//        [6,6] --> "6"
//        [8,9] --> "8->9"
//https://leetcode.com/problems/summary-ranges/

import java.util.ArrayList;
import java.util.List;

public class SummaryRangesProblem {
    public static void main(String[] args) {
        int[] nums = {0, 2, 3, 4, 6, 8, 9};
        System.out.println(summaryRanges(nums));
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();

        if(nums.length == 0) {
            return res;
        } else if (nums.length == 1) {
            res.add(String.valueOf(nums[0]));
            return res;
        }


        int rangeEnd = 0;
        int rangeStart = 0;
        boolean flag = Boolean.FALSE;

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] == nums[j - 1] + 1) {
                rangeEnd = j;

                if (j == nums.length - 1) {
                    res.add(nums[rangeStart] + "->" + nums[rangeEnd]);
                }

            } else {
                if (rangeStart == rangeEnd) {
                    res.add(String.valueOf(nums[rangeStart]));
                } else {
                    res.add(nums[rangeStart] + "->" + nums[rangeEnd]);
                }

                if (j == nums.length - 1) {
                    flag = true;
                }
                rangeStart = j;
                rangeEnd = j;
            }
        }

        if (flag) {
            res.add(String.valueOf(nums[nums.length - 1]));
        }

        return res;
    }
}
