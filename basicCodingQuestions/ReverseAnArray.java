package basicCodingQuestions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseAnArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};

        reverseArray(arr);
        reverseArrayUsingStream(arr);
    }

    public static void reverseArray(int[] arr) {
        int end = arr.length;

        for (int i = 0; i < end/2; i++) {
            int tmp = arr[end - 1 - i];
            arr[end - 1 - i] = arr[i];
            arr[i] = tmp;
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void reverseArrayUsingStream(int[] arr) {
        int end = arr.length;

        List<Integer> a = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Collections.reverse(a);

        System.out.println(a);
    }
}
