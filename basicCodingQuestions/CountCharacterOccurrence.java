package basicCodingQuestions;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountCharacterOccurrence {
    public static void main(String[] args) {
        String str = "Hello World";
        char c = 'o';

        countOccurrence(str, c);
        countOccurrenceUsingStreams(str, c);
        countCharFreqUsingStream(str);
    }

    public static void countOccurrence(String str, char c) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                count++;
            }
        }
        System.out.println("Character '" + c + "' occurs " + count + " times.");
    }

    public static void countOccurrenceUsingStreams(String str, char c) {

        long count = str.chars().mapToObj(i -> (char) i)
                .filter(ch -> ch == c)
                .count();

        System.out.println("Using streams --> Character '" + c + "' occurs " + count + " times.");
    }

    public static void countCharFreqUsingStream(String str) {
        Map<Character, Long> collect = str.chars().mapToObj(i -> (char) i)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(collect);
    }
}
