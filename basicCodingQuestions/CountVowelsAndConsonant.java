package basicCodingQuestions;

public class CountVowelsAndConsonant {
    public static void main(String[] args) {
        String str = "Hello";
        countVowelsAndConsonants(str);
        countVowelsAndConsonantsUsingStreams(str);
    }

    public static void countVowelsAndConsonants(String str) {
        int v = 0;
        int c = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o'
            || str.charAt(i) == 'u') {
                v++;
            }
            else {
                c++;
            }
        }
        System.out.println("Vowels count : " + v + "\nConsonant count : " + c);
    }

    public static void countVowelsAndConsonantsUsingStreams(String str) {
        long v = str.chars().mapToObj(c -> (char) c)
                .filter(c -> isVowel(c) == 1).count();

        long con = str.chars().mapToObj(c -> (char) c)
                .filter(c -> Character.isLetter(c) && isVowel(c) == -1).count();

        System.out.println("Vowels count : " + v + "\nConsonant count : " + con);
    }

    public static int isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) >= 0 ? 1 : -1;
    }
}
