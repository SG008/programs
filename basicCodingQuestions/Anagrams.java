package basicCodingQuestions;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Anagrams {
    public static void main(String[] args) {
        String a = "listen";
        String b = "silent";
        isAnagramUsingSoring(a, b);
        isAnagramUsingFrequency(a, b);
        isAnagramUsingStreams(a, b);
    }

    public static void isAnagramUsingSoring(String str1, String str2) {
        if (str1.length() != str1.length()) {
            System.out.println("Not an anagram");
        }

        char[] a = str1.toCharArray();
        Arrays.sort(a);
        char[] b = str2.toCharArray();
        Arrays.sort(b);

        if (Arrays.equals(a, b)) {
            System.out.println("Using sort : are anagram");
        } else {
            System.out.println("Using sort : are not anagram");
        }

    }

    public static void isAnagramUsingFrequency(String str1, String str2) {
        if (str1.length() != str1.length()) {
            System.out.println("Not an anagram");
        }

        int[] freq = new int[26];

        for (int i = 0; i < str1.length(); i++) {
            freq[str1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < str2.length(); i++) {
            freq[str2.charAt(i) - 'a']--;
        }

        for (int count : freq) {
            if(count != 0) {
                System.out.println("using count --> not anagram");
                return;
            }
        }
        System.out.println("using count --> are anagram");
    }

    public static void isAnagramUsingStreams(String str1, String str2) {
        if (str1.length() != str2.length()) {
            System.out.println("Not an anagram");
        }

        Map<Character, Long> str1Collect = str1.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Character, Long> str2Collect = str2.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


        if(!str1Collect.equals(str2Collect)) {
                System.out.println("using stream --> not anagram");
                return;
        }
        System.out.println("using stream --> are anagram");
    }
}
