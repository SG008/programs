
import java.util.Arrays;

//Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
// and return an array of the non-overlapping intervals that cover all the intervals in the input.
//        Example 1:
//
//        Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//        Output: [[1,6],[8,10],[15,18]]
//        Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
//        Example 2:
//
//        Input: intervals = [[1,4],[4,5]]
//        Output: [[1,5]]
//        Explanation: Intervals [1,4] and [4,5] are considered overlapping.
//https://leetcode.com/problems/merge-intervals/description/
public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {
                {1, 4}, {4, 5}
        };

        display(merge(intervals));
    }

    public static int[][] merge(int[][] intervals) {
        int[][] res = new int[intervals.length][2];
        int k = 0;

        res[0][0] = intervals[0][0];
        res[0][1] = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (res[k][1] >= intervals[i][0] && res[k][1] < intervals[i][1]) {
                res[k][0] = Math.min(res[k][0], intervals[i][0]);
                res[k][1] = intervals[i][1];
            } else if (res[k][1] >= intervals[i][1] && res[k][0] < intervals[i][1]) {
            } else {
                k++;

                res[k][0] = intervals[i][0];
                res[k][1] = intervals[i][1];

            }
        }

        return res;
    }

    public static void display(int[][] intervals) {
        for (int[] arr : intervals) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
