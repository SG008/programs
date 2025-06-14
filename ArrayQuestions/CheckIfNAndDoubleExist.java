/*
*Given an array arr of integers, check if there exist two indices i and j such that :

i != j
0 <= i, j < arr.length
arr[i] == 2 * arr[j]
* */
//https://leetcode.com/problems/check-if-n-and-its-double-exist/description/?envType=problem-list-v2&envId=array

package ArrayQuestions;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CheckIfNAndDoubleExist {
    public static void main(String[] args) {
        int[] arr = {3,1,7,11};
        System.out.println(checkIfExist(arr));
    }

    public static boolean checkIfExist(int[] arr) {
        Set<Integer> nums = new HashSet<>();

        for (int e : arr) {
            nums.add(e);

            if (nums.contains((e * 2)) || nums.contains((e/2))) {
                return true;
            }
        }

        return false;
    }
}
