package ArrayQuestions;

//Given a binary array arr[] and an integer k,
// find the maximum length of a subarray containing all ones after flipping at most k zeroes to 1's.?
public class MaximiseMaxConsecutive1 {
    public static void main(String[] args) {
        int[] arr = {1, 0, 0, 1, 0, 1, 0, 1};
        int k = 2;
        findMax1(arr, k);
    }

    private static void findMax1(int[] arr, int k) {
        int left = 0;
        int right = 0;
        int zCount = 0;
        int maxLength = 0;
        int n = arr.length;
        while (right < n) {
            while (left < right && zCount > k) {
                if (arr[left] == 0) {
                    zCount--;
                }
                left++;
            }

            if (arr[right] == 0) {
                zCount++;
            }


            maxLength = Math.max(maxLength, (right - left + 1));
            right++;
        }

        System.out.println("Maximum consecutive 1's: " + maxLength);
        System.out.println("Left Index: " + left + " Right Index: " + right);
    }
 }
