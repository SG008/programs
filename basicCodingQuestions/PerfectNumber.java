package basicCodingQuestions;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

//positive number where sum of it's positive divisor is equal to the number
// e.g. for 6 --> divisor : 1,2,3 -> 1+2+3 = 6
public class PerfectNumber {
    public static void main(String[] args) {
        int num = 496;
        isPerfect(num);
        isPerfectUsingStream(num);
    }

    public static void isPerfect(int num) {
        int sum = 0;
        for (int i = 1; i <= num/2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }

        if (sum == num) {
            System.out.println("perfect num");
            return;
        }
        System.out.println("not perfect num");
    }

    public static void isPerfectUsingStream(int num) {

        int sum = IntStream.rangeClosed(1, num / 2).boxed()
                .filter(i -> num % i == 0).toList()
                .stream().mapToInt(Integer::intValue).sum();

        if (sum == num) {
            System.out.println("perfect num");
            return;
        }
        System.out.println("not perfect num");
    }
}
