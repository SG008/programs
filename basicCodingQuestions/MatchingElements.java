package basicCodingQuestions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

// find duplicates elements
public class MatchingElements {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 4, 5, 3};
        findMatchingElementUsingStream(arr);
        findMatchingElement(arr);
    }

    public static void findMatchingElementUsingStream(int[] arr) {
        List<Integer> collect = Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()))
                .entrySet().stream().filter(es -> es.getValue() > 1)
                .map(Map.Entry::getKey).toList();

        System.out.println(collect);
    }

    public static void findMatchingElement(int[] arr) {
        Set<Integer> set = new HashSet<>();

        for (int i : arr) {
            if (!set.add(i)) {
                System.out.println(i);
            }
        }
    }
}

