package basicCodingQuestions;

import java.util.stream.IntStream;

public class CheckPrime {
    public static void main(String[] args) {
        isPrime(4);
        isPrimeUsingStream(4);
    }

    public static void isPrime(int n) {
        if (n == 0 || n == 1 ) {
            System.out.println("not prime");
        }
        if (n == 2) {
            System.out.println("No. is prime");
        }

        for (int i = 2; i <= n/2; i++) {
            if (n % i == 0) {
                System.out.println("not prime");
                return;
            }
        }
        System.out.println("No. is prime");
    }

    public static void isPrimeUsingStream(int n) {
        if (n == 0 || n == 1 ) {
            System.out.println("not prime");
        }
        if (n == 2) {
            System.out.println("No. is prime");
            return;
        }

        boolean present = IntStream.rangeClosed(2, n/2).filter(i -> n % i != 0).findFirst().isPresent();

        if (present) {
            System.out.println("No. is prime");
            return;
        }
        System.out.println("not prime");
    }
}
