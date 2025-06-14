import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class kthSmallestElement {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(15, 4, 7, 8, 34, 9, 6);
        List<Integer> a = arr;
        Collections.sort(a);
        System.out.println(a);
        Scanner s = new Scanner(System.in);
        int k = s.nextInt();
        kthSmallest(arr, k);
    }

    private static void kthSmallest(List<Integer> arr, int k) {
        int max = Integer.MIN_VALUE;

        for (int i : arr) {
            max = Math.max(max, i);
        }

        int[] freq = new int[max + 1];
        Arrays.fill(freq, 0);

        for (Integer integer : arr) {
            freq[integer] += 1;
        }

        for (int value : freq) {
            System.out.print(value + " ");
        }

        int count = 0;
        for (int j = 0; j <= max; j++) {
            count += freq[j];
            if (count >= k) {
                System.out.println(j);
                return;
            }
        }

    }
}
