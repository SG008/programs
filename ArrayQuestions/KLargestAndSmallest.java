package ArrayQuestions;

import java.util.Collections;
import java.util.PriorityQueue;

public class KLargestAndSmallest {
    public static void main(String[] args) {
        int k = 3;
//        int[] arr = {1, 23, 12, 9, 30, 2, 50};
        int[] arr = {-10, -3, 5, 6, -20};

        // Min Heap
        /**
         * Heap 1 12 23
         * Heap 9 12 23
         * Heap 12 23 30
         * Heap 23 30 50 --> Result
         */

        //Max Heap
        /*
         * Heap 23 12 1
         * Heap 12 9 1
         * Heap 9 2 1 --> Result
         */

        largest(arr, k);
        smallest(arr, k);
    }

    private static void largest(int[] arr, int k) {
        PriorityQueue<Integer> min = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            min.add(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if (arr[i] > min.peek()) {
                min.poll();
                min.add(arr[i]);
            }
        }

        System.out.println("Largest " + k + " elements : " + min);
    }

    private static void smallest(int[] arr, int k) {
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            max.add(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if (arr[i] < max.peek()) {
                max.poll();
                max.add(arr[i]);
            }
        }

        System.out.println("Smallest " + k + " elements" + max);
    }
}
