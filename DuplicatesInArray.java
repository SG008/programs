import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DuplicatesInArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 5, 6, 7, 8, 9, 10};
//        System.out.println(containsDuplicates(arr));
        containsNearbyDuplicate(arr, 5);

    }

    private static boolean containsDuplicates(int[] arr) {
        if (Arrays.stream(arr).distinct().count() != arr.length) {
            return true;
        }
        return false;
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> elementsIndexes = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (elementsIndexes.containsKey(nums[i])) {
                int lastIndex = elementsIndexes.get(nums[i]);
                // Check if the difference is within k
                if (i - lastIndex <= k) {
                    return true;
                }
            }
            elementsIndexes.put(nums[i],i);
        }

        return false;
    }
}
