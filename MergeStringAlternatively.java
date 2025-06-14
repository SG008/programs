//You are given two strings word1 and word2. Merge the strings by adding letters in alternating order,
// starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.
//
//        Return the merged string.
//
//
//
//        Example 1:
//
//        Input: word1 = "abc", word2 = "pqr"
//        Output: "apbqcr"
//        Explanation: The merged string will be merged as so:
//        word1:  a   b   c
//        word2:    p   q   r
//        merged: a p b q c r
//        Example 2:
//
//        Input: word1 = "ab", word2 = "pqrs"
//        Output: "apbqrs"
//        Explanation: Notice that as word2 is longer, "rs" is appended to the end.
//        word1:  a   b
//        word2:    p   q   r   s
//        merged: a p b q   r   s
//        Example 3:
//
//        Input: word1 = "abcd", word2 = "pq"
//        Output: "apbqcd"
//        Explanation: Notice that as word1 is longer, "cd" is appended to the end.
//        word1:  a   b   c   d
//        word2:    p   q
//        merged: a p b q c   d
//https://leetcode.com/problems/merge-strings-alternately/description/


public class MergeStringAlternatively {
    public static void main(String[] args) {
        System.out.println(mergeAlternately("abcd", "pq"));
    }

    public static String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        boolean flag = Boolean.TRUE;
        int str1Len = word1.length();
        int str2Len = word2.length();
        int i = 0;
        int j = 0;
        while (i < str1Len && j < str2Len) {

            if (flag) {
                result.append(word1.charAt(i));
                flag = false;
                i++;
            } else {
                result.append(word2.charAt(j));
                flag = true;
                j++;
            }
        }

        while(i < str1Len) {
            result.append(word1.charAt(i));
            i++;
        }

        while(j < str2Len) {
            result.append(word2.charAt(j));
            j++;
        }

        return result.toString();
    }
}
