import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

//https://leetcode.com/problems/create-target-array-in-the-given-order/
class CreateTargetArray {
    public static void main(String[] args) {
//        int[] nums = {0,1,2,3,4};
//        int[] index = {0,1,2,2,1};

//        System.out.println(Arrays.toString(createTargetArray(nums, index)));

//        System.out.println(isPangram("thequickbrownfoxjumpsoverthelazydog"));

        List<List<String>> items = Arrays.asList(
                Arrays.asList("phone", "blue", "pixel"),
                Arrays.asList("computer", "silver", "lenovo"),
                Arrays.asList("phone", "gold", "iphone")
        );

        System.out.println(countItemMatchingRule(items, "color", "silver"));
    }
    public static int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> res = new ArrayList<>();

        int k = 0;

        while (k < index.length) {
            res.add(index[k], nums[k]);
            k++;
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public static boolean isPangram(String str) {
        List<String> chars = Arrays.asList(str.split(""));
        return chars.stream().distinct().toList().size() == 26;
    }

    public static int countItemMatchingRule(List<List<String>> items, String ruleKey, String ruleValue) {
        int ind = Arrays.asList("type", "color", "name").indexOf(ruleKey);
        long count = items.stream().filter(lst -> lst.get(ind).equalsIgnoreCase(ruleValue)).count();
        return (int) count;
    }
    
    public static void invertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            int eCol = image[i].length - 1;
            for (int j = 0; j < eCol / 2; j++) {
                int temp = image[i][j];
                image[i][j] = image[i][eCol - j] == 0 ? 1 : 0;
                image[i][eCol - j] = temp == 0 ? 1 : 0;
            }
            if ((eCol + 1) % 2 != 0) {
                image[i][eCol/2 + 1] = image[i][eCol/2 + 1] == 0 ? 1 : 0;
            }
        }
    }
}