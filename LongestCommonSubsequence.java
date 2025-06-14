//Write a function to find the longest common prefix string amongst an array of strings.
//
//        If there is no common prefix, return an empty string "".
//        Example 1:
//
//        Input: strs = ["flower","flow","flight"]
//        Output: "fl"
//        Example 2:
//
//        Input: strs = ["dog","racecar","car"]
//        Output: ""
//        Explanation: There is no common prefix among the input strings.

//https://leetcode.com/problems/longest-common-prefix/description/

import java.util.Arrays;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String[] strs = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        String res = "";
        Arrays.sort(strs);
        String str1 = strs[0];
        String str2 = strs[strs.length - 1];
        int i = 0;
        int j = 0;

        while (i < str1.length() && j < str2.length()) {
            if(str1.charAt(i) == str2.charAt(j)) {
                res += str1.charAt(i);
            } else {
                break;
            }
            i++;
            j++;
        }


        return res;
    }
}


