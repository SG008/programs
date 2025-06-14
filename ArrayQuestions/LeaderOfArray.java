package ArrayQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//An element is a Leader if it is greater than or equal to all the elements to its right side.
public class LeaderOfArray {
    public static void main(String[] args) {
        int[] arr = { 16, 17, 4, 3, 5, 2 };
        findLeader(arr);
    }

    private static void findLeader(int[] arr) {
        List<Integer> res = new ArrayList<>();
        int currLeader = Integer.MIN_VALUE;
        for (int i = (arr.length - 1); i >= 0 ; i--) {
            if (arr[i] > currLeader) {
                res.add(arr[i]);
                currLeader = arr[i];
            }
        }

        Collections.reverse(res);
        System.out.println(res);
    }
}
