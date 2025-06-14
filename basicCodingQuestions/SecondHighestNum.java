package basicCodingQuestions;

import java.util.Arrays;
import java.util.Collections;

public class SecondHighestNum {
    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 8, 1, 9, 4};
        int highestPlace = 3;
        int nHighest = findNHighest(arr, highestPlace);
        System.out.println(highestPlace +" highest number: " + nHighest);
        System.out.println("Seconds highest num: " + findSecondHighest(arr));
    }

    public static int findNHighest(int[] arr, int num) {
        return Arrays.stream(arr).mapToObj(i -> (Integer) i)
                .sorted(Collections.reverseOrder())
                .toList()
                .get(num - 1);
    }

    public static int findSecondHighest(int[] arr) {
        int highest = Integer.MIN_VALUE;
        int secHighest = Integer.MIN_VALUE;

        for (int i : arr) {
            if (i > highest) {
                secHighest = highest;
                highest = i;
            } else if (i > secHighest) {
                secHighest = i;
            }
        }

        return secHighest;
    }
}
