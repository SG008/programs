import java.util.function.Function;
import java.util.stream.Collectors;

public class LongestSubstring {
    public static void main(String[] args) {
        String s = "dvdf";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int f = 0;
        int sec = 1;
        int rs = 1;
        int len = s.length();
        while (f < len && sec <= (len - 1)) {
            if (containDuplicates(s.substring(f, sec + 1))) {
                f++;
            } else {
                sec++;
            }
            rs = Math.max(rs, (sec - f));
        }

        return rs;
    }

    public static boolean containDuplicates(String str) {
        long c = str.chars().mapToObj(i -> (char) i)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(es -> es.getValue() > 1).count();

        return c != 0;
    }
}
