import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringSubsequence {

    private static List<String> subsequence = new ArrayList<>();

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 2};

//        System.out.println(findSubsequence("abc", ""));
        System.out.println(findSubsequence(nums));

    }

    private static ArrayList<String> findSubsequence(String str, String s) {

        if (str.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(s);
            return list;
        }

        ArrayList<String> left = findSubsequence(str.substring(1), s + str.charAt(0));
        ArrayList<String> right = findSubsequence(str.substring(1), s);

        left.addAll(right);

        return left;
    }


    private static List<List<Integer>> findSubsequence(int[] arr) {

        List<List<Integer>> outer = new ArrayList<>();
        int start = 0, end = 0;

        Arrays.sort(arr);

        outer.add(new ArrayList<>());

        for (int i = 0; i < arr.length; i++) {
            start = 0;
            int size = outer.size();

            if (i > 0 && arr[i] == arr[i - 1]) {
                start = end + 1;
            }

            end = outer.size() - 1;
            for (int j = start; j < size; j++) {
                List<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal);
            }
        }

        return outer;
    }
}
