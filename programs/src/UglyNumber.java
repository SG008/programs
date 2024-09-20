//An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
//        Given an integer n, return true if n is an ugly number.
//
//        Example 1:
//
//        Input: n = 6
//        Output: true
//        Explanation: 6 = 2 × 3
//        Example 2:
//
//        Input: n = 1
//        Output: true
//        Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
//        Example 3:
//
//        Input: n = 14
//        Output: false
//        Explanation: 14 is not ugly since it includes the prime factor 7.
//https://leetcode.com/problems/ugly-number/description/

import java.util.Arrays;
import java.util.List;

public class UglyNumber {
    public static void main(String[] args) {
        System.out.println(isUgly(8));
    }

    public static boolean isUgly(int n) {
        if (n == 1)
            return true;

        List<Integer> factors = Arrays.asList(2, 3, 5);

        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                if (!factors.contains(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
