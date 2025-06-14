package ArrayQuestions;

import java.util.Arrays;

public class MaximumSubarray {
    public static void main(String[] args) {
//        int[] arr = {-2, 6, -3, -10, 0, 2}; //--> 180(max prod)
//        int[] arr = {2, 3, -8, 7, -1, 2, 3};
        int[] arr = {1,2,3,4};
//        maxProduct(arr);
//        maxSum(arr);

        countSubarrayProductLessThenK(arr, 10);
    }

    private static void maxProduct(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int leftProd = 1;
        int rightProd = 1;
        int ans = 0;

        while (left <= arr.length && right >= 0) {
            if (leftProd == 0) {
                leftProd = 1;
            }
            if (rightProd == 0) {
                rightProd = 1;
            }

            leftProd *= arr[left];
            rightProd *= arr[right];
            ans = Math.max(ans, Math.max(leftProd, rightProd));

            left++;
            right--;
        }

        System.out.println(ans);
    }

    private static void maxSum(int[] arr) {
        int res = arr[0];
        int maxEnding  = arr[0];
        int start = 0;
        int end = 0;

        for (int i = 0; i < arr.length; i++) {

            if (maxEnding + arr[i] < arr[i]) {
                maxEnding = arr[i];
                start = i;
            } else {
                maxEnding += arr[i];
            }

            if (res < maxEnding) {
                res = maxEnding;
                end = i;
            }

//            maxEnding = Math.max(maxEnding + arr[i], arr[i]);
//            res = Math.max(maxEnding, res);
        }

        System.out.println(res);
        System.out.println(Arrays.toString(Arrays.copyOfRange(arr, start, (end + 1))));
    }

    private static void countSubarrayProductLessThenK(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;
        int leftProd = 1;
        int rightProd = 1;
        int ans = 0;

        while (left <= arr.length && right >= 0) {
            if (leftProd == 0) {
                leftProd = 1;
            }
            if (rightProd == 0) {
                rightProd = 1;
            }

            leftProd *= arr[left];
            rightProd *= arr[right];
//            ans = Math.max(ans, Math.max(leftProd, rightProd));

            if (leftProd < k) {
                ans++;
            }
            if (rightProd < k) {
                ans++;
            }

            left++;
            right--;
        }

        System.out.println(ans);
    }
}
