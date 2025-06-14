package basicCodingQuestions;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NonRepeatingCharacter {
    public static void main(String[] args) {
        nonRepeatingChars("Hello World");

    }

    public static void nonRepeatingChars(String str) {
        List<Character> list = str.chars().mapToObj(i -> (char) i)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(es -> es.getValue() == 1)
                .map(Map.Entry::getKey).sorted().toList();

        System.out.println(list);
    }
}
