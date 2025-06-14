package basicCodingQuestions;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class ReverseAString {
    public static void main(String[] args) {
        String a = "mam";
        reverseStringWithCollections(a);
        reverseString(a);
    }

    public static void reverseString(String str) {
        StringBuilder b = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            b.append(str.charAt(i));
        }

        System.out.println("Reversed String :" + b);
        isPalindrome(str, b.toString());
    }

    public static void reverseStringWithCollections(String str) {
        String reversedUsingStream = str.chars()
                .mapToObj(c -> (char) c) // converting int to char
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),  // collecting results
                        list -> {
                            Collections.reverse(list);
                            return list.stream();
                        }))
                .map(String::valueOf) // characters mapped to string
                .collect(Collectors.joining());
        System.out.println("Reversed String using streams :" + reversedUsingStream);
    }

    public static void isPalindrome(String a, String b) {
        if (a.equalsIgnoreCase(b)) {
            System.out.println("The strings are palindromes.");
        } else {
            System.out.println("The strings are not palindromes.");
        }
    }
}
