package ArrayQuestions;

public class MaxConsecutive1And0 {
    public static void main(String[] args) {
//        int[] arr = {1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1};
//        int[] arr = {0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1};
        int[] arr = {1, 0, 0, 0, 0};
        getMaxConsecutiveElement(arr);
    }

    private static void getMaxConsecutiveElement(int[] arr) {
        int count = 1;
        int maxCount = 0;
        int element = arr[0];
        int i = 1;

        for (i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
            } else {
                if (count > maxCount) {
                    maxCount = count;
                    element = arr[i - 1];
                }
                count = 1;
            }
        }

        if (count > maxCount) {
            maxCount = count;
            element = arr[i - 1];
        }

        System.out.println("Element: " + element + " has max consecutive count: " + maxCount);
    }
}
