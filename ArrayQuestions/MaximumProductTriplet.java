package ArrayQuestions;

public class MaximumProductTriplet {
    public static void main(String[] args) {
        int[] arr = {10, 3, 5, 6, 20};
        tripletProduct(arr);
    }

    private static void tripletProduct(int[] arr) {
        int maxA = Integer.MIN_VALUE;
        int maxB = Integer.MIN_VALUE;
        int maxC = Integer.MIN_VALUE;
        int minA = Integer.MAX_VALUE;
        int minB = Integer.MAX_VALUE;

        for (int j : arr) {
            if (j > maxA) {
                maxC = maxB;
                maxB = maxA;
                maxA = j;
            } else if (j > maxB) {
                maxC = maxB;
                maxB = j;
            } else if (maxC < j) {
                maxC = j;
            }

            if (j < minA) {
                minB = minA;
                minA = j;
            } else if (j < minB) {
                minB = j;
            }
        }

        int product = Math.max((maxA * maxB * maxC), (maxA * minB * minA));
        System.out.println("Maximum sum of triplet is : " + product);
    }
}
