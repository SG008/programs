package basicCodingQuestions;

import java.util.Arrays;

public class UsingNumberDigits {
    public static void main(String[] args) {
        int num = 153;
        armStrongNum(num);
        sumOfDigits(num);
    }

    public static void armStrongNum(int num) {
        String n = num + "";
        String[] digits = n.split("");
        int digitsSum = Arrays.stream(digits)
                .map(Integer::parseInt).map(i -> (i * i * i))
                .mapToInt(Integer::intValue)
                .sum();

        if (digitsSum == num) {
            System.out.println("Armstrong");
            return;
        }
        System.out.println("Not Armstrong");
    }

    public static void sumOfDigits(int num) {
        String n = num + "";

        int sum = Arrays.stream(n.split("")).map(Integer::parseInt).mapToInt(Integer::intValue).sum();

        System.out.println("Sum of digits: " + sum);
    }
}
