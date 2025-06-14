package ArrayQuestions;

import java.util.Arrays;

public class AddingOneToNumber {
    public static void main(String[] args) {
        int[] arr = {9, 9, 9};
        int[] res = addOne(arr);
        System.out.println(Arrays.toString(res));
    }

    public static int[] addOne(int[] arr) {
        int carry = 1;
        int n = arr.length;
        for (int i = (n - 1); i >= 0 ; i--) {
            int num = arr[i] + carry;
            arr[i] = num % 10;
            carry = num / 10;
        }

        if (carry > 0) {
            int[] res = new int[n + 1];
            res[0] = carry;
            System.arraycopy(arr, 0, res, 1, arr.length);
            return res;
        }
        return arr;
    }
}
