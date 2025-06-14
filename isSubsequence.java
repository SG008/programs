//Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
// A subsequence of a string is a new string that is formed from the original string by deleting some (can be none)
// of the characters without disturbing the relative positions of the remaining characters.
// (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
//        Example 1:
//
//        Input: s = "abc", t = "ahbgdc"
//        Output: true
//        Example 2:
//
//        Input: s = "axc", t = "ahbgdc"
//        Output: false
//https://leetcode.com/problems/is-subsequence/description/

public class isSubsequence {
    public static void main(String[] args) {
        System.out.println(isSubsequence("acb", "ahbgdc"));
    }

    public static boolean isSubsequence(String s, String t) {
        int str1Len = s.length();
        int str2Len = t.length();
        int i = 0;
        int j = 0;

        if(str1Len > str2Len) {
            return false;
        }

        if(str1Len == 1 && str2Len == 1) {
            return s.charAt(0) == t.charAt(0);
        }

        while(i < str1Len && j < str2Len) {

            if(t.charAt(j) == s.charAt(i)) {
                i++;
            }
            j++;
        }

        if(j >= str2Len - 1 && i < str1Len) {
            return false;
        }

        return true;
    }

}
