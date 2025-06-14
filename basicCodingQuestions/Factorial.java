package basicCodingQuestions;

import java.util.stream.IntStream;

public class Factorial {
    public static void main(String[] args) {
        fact(4);
        factUsingStream(5);
        System.out.println(factRecursive(5));
    }

    public static void fact(int n) {
        int f = 1;
        for (int i = 1; i <= n; i++) {
            f *= i;
        }

        System.out.println(f);
    }

    public static void factUsingStream(int n) {
        System.out.println(IntStream.rangeClosed(1, n).reduce(1, (a, b) -> a * b));
    }

    public static int factRecursive(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        return n * factRecursive(n - 1);
    }
}
