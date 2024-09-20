//Write a function that reverses a string. The input string is given as an array of characters s.
//        You must do this by modifying the input array in-place with O(1) extra memory.
//        Example 1:
//
//        Input: s = ["h","e","l","l","o"]
//        Output: ["o","l","l","e","h"]
//        Example 2:
//
//        Input: s = ["H","a","n","n","a","h"]
//        Output: ["h","a","n","n","a","H"]

import java.lang.reflect.Array;
import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        char[] s = {'H','a','n','n','a','h'};
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }

    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while(left < right) {
            char t = s[right];
            s[right] = s[left];
            s[left] = t;
            left++;
            right--;
        }
    }
}
