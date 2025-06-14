import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringSubsequence {

    public static void main(String[] args) {

        int[] nums = {1, 3, 2, 4};

        findArraySubs(List.of(1,3,2,4), new ArrayList<>());

//        System.out.println(findSubsequence("abc", ""));
//        System.out.println(findSubsequence(nums));

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

    public static void findArraySubs(List<Integer> up, List<Integer> p) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        List<Integer> temp = new ArrayList<>(p);
        int i = up.get(0);
        p.add(i);
        findArraySubs(up.subList(1, up.size()), p);
        findArraySubs(up.subList(1, up.size()), temp);


    }
}
