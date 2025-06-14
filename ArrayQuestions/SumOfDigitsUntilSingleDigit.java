package ArrayQuestions;

// finding-sum-of-digits-of-a-number-until-sum-becomes-single-digit
public class SumOfDigitsUntilSingleDigit {
    public static void main(String[] args) {
        int i = 9;
        int mod = i % 9;
        System.out.println(mod == 0 ? 9 : mod);
    }
}
