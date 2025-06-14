package basicCodingQuestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReplaceElementWithRank {
    public static void main(String[] args) {
        int[] arr = {100, 5, 70, 2};
        replaceWithRank(arr);
        replaceWithRankUsingStream(arr);
    }

    public static void replaceWithRank(int[] arr) {
        int[] newArr = arr.clone();
        Arrays.sort(newArr);

        HashMap<Integer, Integer> ranks = new HashMap<>();
        int rank = 1;
        for(int n : newArr) {
            if (!ranks.containsKey(n)) {
                ranks.put(n, rank);
                rank++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            Integer r = ranks.get(arr[i]);
            arr[i] = r;
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void replaceWithRankUsingStream(int[] arr) {
        List<Integer> newArr = Arrays.stream(arr).boxed().distinct().sorted().toList();

        Map<Integer, Integer> ranks = IntStream.range(0, newArr.size()).boxed()
                .collect(Collectors.toMap(newArr::get, i -> i + 1));

        System.out.println(Arrays.toString(Arrays.stream(arr).map(ranks::get).toArray()));
    }
}
